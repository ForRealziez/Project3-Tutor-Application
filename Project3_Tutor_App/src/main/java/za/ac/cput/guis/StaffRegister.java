package za.ac.cput.guis;

import za.ac.cput.database.StaffDatabase;
import za.ac.cput.entity.staffRegister;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;

public class StaffRegister extends JDialog {
    static String name;
    private JTextField tfName;
    private JTextField tfSurname;
    private JTextField tfGender;
    private JTextField tfEmail;
    private JTextField tfAddress;
    private JTextField tfCourse;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JPanel registerPanel;

    public StaffRegister(JFrame parent){
        super(parent);
        setTitle("Create a new account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(550,574));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        setVisible(true);
    }
    public staffRegister user;
    private void reset() {

        tfName.setText("");
        tfSurname.setText("");
        tfGender.setText("");
        tfEmail.setText("");
        tfAddress.setText("");
        tfCourse.setText("");
        pfPassword.setText("");
        pfConfirmPassword.setText("");
    }

    private void registerUser() {
         //String name = tfName.getText();
         name = tfName.getText();
        String surname = tfSurname.getText();
         String gender = tfGender.getText();
         String email = tfEmail.getText();
         String address = tfAddress.getText();
         String course = tfCourse.getText();
         String password = String.valueOf(pfPassword.getPassword());
         String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());

         if(name.isEmpty() || surname.isEmpty() || gender.isEmpty() || email.isEmpty() || address.isEmpty() || course.isEmpty() || password.isEmpty() ){
             JOptionPane.showMessageDialog(this,
                     "Please enter all fields",
                     "try again",
                     JOptionPane.ERROR_MESSAGE);
             return;
         }

         if(!password.equals(confirmPassword)){
             JOptionPane.showMessageDialog(this,
                     "Password does not match",
                     "try again",
                     JOptionPane.ERROR_MESSAGE);
             return;
         }

         user = addUserToDatabase(name, surname, gender, email, address, course, password);
         if(user != null){
             JOptionPane.showMessageDialog(this,
                     "Successfully Registered",
                     "Success",
                     JOptionPane.INFORMATION_MESSAGE);
             reset();
         } else {
             JOptionPane.showMessageDialog(this,
                     "Failed to register new user",
                     "try again",
             JOptionPane.ERROR_MESSAGE);
         }
         
    }

    private staffRegister addUserToDatabase(String name, String surname, String gender, String email, String address, String course, String password) {
        staffRegister user = null;
        final String DB_URL = "jdbc:mysql://localhost/projectApp";
        final String USERNAME = "root";
        final String PASSWORD = "Giant123";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);



            String sql = """
                        INSERT INTO Staff (staffid, name, surname, gender, email, address, course, password)
                        VALUES (?,?, ?, ?, ?, ?, ?, ?)""";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            String staffID = UUID.randomUUID().toString();
            preparedStatement.setString(1, staffID);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3,surname);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5,email);
            preparedStatement.setString(6,address);
            preparedStatement.setString(7, course);
            preparedStatement.setString(8, password);

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0){
                user = new staffRegister();
                user.setStaffID(staffID);
                user.setName(name);
                user.setSurname(surname);
                user.setGender(gender);
                user.setEmail(email);
                user.setPhysicalAddress(address);
                user.setCourse(course);
                user.setPassword(password);
            }
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        StaffRegister myForm = new StaffRegister(null);
        staffRegister user = myForm.user;
        if(user != null){
            System.out.println("Successful registration of: " + name);
        }
        else{
            System.out.println("Registration invalid");
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
