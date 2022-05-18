/**
 * @author MoeGammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.guis;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterStudentGUI extends JPanel implements ActionListener{
    private JLabel lblHeader;
    private JLabel lblSubHeader;

    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblEmailError;

    private JLabel lblPassword;
    private JTextField txtPassWord;
    private JLabel lblPassWordError;

    private JLabel lblPasswordCon;
    private JTextField txtPassWordCon;
    private JLabel lblPassWordConError;

    private JLabel lblCourse;
    private JComboBox cmbCourse;
    private JLabel lblCourseError;

    private JButton btnRegister;
    private JLabel lblHaveAAcc;
    private JButton btnLogin;

    public RegisterStudentGUI(){
        //construct preComponents
        String[] cmbCourseItems = {"Select","ADP", "CMD", "MUD"};

        //construct components
        lblHeader = new JLabel ("Student Registration");
        lblSubHeader = new JLabel ("Fill in the required details");

        lblEmail = new JLabel ("Email Address");
        txtEmail = new JTextField (5);
        lblEmailError = new JLabel ("*Required*");

        lblPassword = new JLabel ("Password");
        txtPassWord = new JTextField (5);
        lblPassWordError = new JLabel ("*Required*");

        lblPasswordCon = new JLabel ("Password Confirmation");
        txtPassWordCon = new JTextField (5);
        lblPassWordConError = new JLabel ("*Required*");

        lblCourse = new JLabel ("Course");
        cmbCourse = new JComboBox (cmbCourseItems);
        lblCourseError = new JLabel ("*Required*");

        btnRegister = new JButton ("Register");

        lblHaveAAcc = new JLabel ("Already have a account");
        btnLogin = new JButton ("Login");


        //adjust size and set layout
        this.setPreferredSize (new Dimension (535, 535));
        this.setLayout (null);

        //add components
        add (lblHeader);
        add (lblSubHeader);

        add (lblEmail);
        add (txtEmail);
        add (lblEmailError);

        add (lblPassword);
        add (txtPassWord);
        add (lblPassWordError);

        add (lblPasswordCon);
        add (txtPassWordCon);
        add (lblPassWordConError);

        add (lblCourse);
        add (cmbCourse);
        add (lblCourseError);

        add (btnRegister);

        add (lblHaveAAcc);
        add (btnLogin);


        btnRegister.addActionListener(this);
        btnLogin.addActionListener(this);


        //set component bounds
        lblHeader.setBounds (10, 10, 180, 25);
        lblSubHeader.setBounds (10, 55, 180, 25);

        lblEmail.setBounds (10, 85, 100, 25);
        txtEmail.setBounds (10, 115, 180, 25);
        lblEmailError.setBounds (225, 115, 100, 25);

        lblPassword.setBounds (10, 160, 100, 25);
        txtPassWord.setBounds (10, 190, 180, 25);
        lblPassWordError.setBounds (225, 190, 100, 25);

        lblPasswordCon.setBounds (10, 240, 100, 25);
        txtPassWordCon.setBounds (10, 265, 180, 25);
        lblPassWordConError.setBounds (225, 265, 100, 25);

        lblCourse.setBounds (10, 325, 100, 25);
        cmbCourse.setBounds (10, 355, 100, 25);
        lblCourseError.setBounds (225, 355, 100, 25);

        btnRegister.setBounds (10, 440, 100, 25);
        lblHaveAAcc.setBounds (10, 490, 180, 25);

        btnLogin.setBounds (210, 490, 100, 25);


        lblEmailError.setVisible(false);
        lblPassWordError.setVisible(false);
        lblPassWordConError.setVisible(false);
        lblCourseError.setVisible(false);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            btnRegister.setEnabled(true);
        }if (txtEmail.getText().isEmpty()) {
            lblEmailError.setVisible(true);
        }else if (txtPassWord.getText().isEmpty()) {
            lblPassWordError.setVisible(true);

        }
        else if (txtPassWordCon.getText().isEmpty()) {
            lblPassWordConError.setVisible(true);

        }
        else if (txtPassWordCon.getText().isEmpty()) {
            lblPassWordConError.setVisible(true);

        }else if (cmbCourse.getSelectedItem().equals("Select") ) {
            lblCourseError.setVisible(true);
        }else {

            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Details Saved");

            //Saving Student inputs to text file
            File textFile = new File("Student register detail.txt");
            FileWriter myWrite = null;
            try {
                myWrite = new FileWriter(textFile);
                myWrite.write("\n=================================");
                myWrite.write("\nInformation on Student");
                myWrite.write("\n=================================");
                myWrite.write("\n" + "Email Address :" + txtEmail.getText());
                myWrite.write("\n" + "Password :" + txtPassWord.getText());
                myWrite.write("\n" + "Password Conformation :" + txtPassWordCon.getText());
                myWrite.write("\n" + "Date of Birth :" + cmbCourse.getSelectedItem());
                myWrite.close();
            } catch (IOException ioe) {
                // Logger.getLogger(SecondFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("An Error occured in writing the File => IOException: " + ioe.getMessage());
            }
            System.out.println("Successfully Wrote txt file to project Dictionary");
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Student register");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new RegisterStudentGUI());
        frame.pack();
        frame.setVisible (true);
    }
}