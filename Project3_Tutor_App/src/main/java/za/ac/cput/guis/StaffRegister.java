package za.ac.cput.guis;

import za.ac.cput.database.StaffDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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

    private void reset() {
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
             reset();
         }
         else {
             JOptionPane.showMessageDialog(this,
                     "Failed to register new user",
                     "try again",
             JOptionPane.ERROR_MESSAGE);
         }
         
    }
    public StaffDatabase user;
    private StaffDatabase addUserToDatabase(String name, String surname, String gender, String email, String address, String course, String password) {
        StaffDatabase user = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (name, surname, gender, email, address, course, password)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,surname);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,address);
            preparedStatement.setString(6, course);
            preparedStatement.setString(7, password);

//            int addedRows = preparedStatement.executeUpdate();
//            if (addedRows > 0){
//                user = new StaffDatabase();
//                user.name = name;
//                user.surname = surname;
//                user.gender = gender;
//                user.email = email;
//                user.address = address;
//                user.course = course;
//                user.password = password;
//            }
            stmt.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        return user;
    }

    public static void main(String[] args) {
        StaffRegister myForm = new StaffRegister(null);
        StaffDatabase user = myForm.user;
        if(user != null){
            System.out.println("Successful registration of: " + name);
        }
        else{
            System.out.println("Registration invalid");
        }
    }
}
