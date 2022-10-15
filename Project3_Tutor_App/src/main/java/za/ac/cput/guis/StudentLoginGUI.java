/**
 * @author Moegammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.guis;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StudentLoginGUI extends JPanel {
    private JLabel lblloginHeader;
    private JLabel lblSubHeader;
    private JLabel lblEmailAddress;
    private JTextField txtEmail;
    private JLabel lblPassword;
    private JTextField tstPassword;
    private JButton btnLogin;
    private JLabel lblRegister;
    private JButton btnRegister;
    private JLabel lblEmailErr;
    private JLabel lblPasswordErr;

    public StudentLoginGUI() {
        //construct components
        lblloginHeader = new JLabel ("Student login");
        lblSubHeader = new JLabel ("Fill in required detail");
        lblEmailAddress = new JLabel ("Email address");
        txtEmail = new JTextField (5);
        lblPassword = new JLabel ("Password");
        tstPassword = new JTextField (5);
        btnLogin = new JButton ("Login");
        lblRegister = new JLabel ("Dont have a Account");
        btnRegister = new JButton ("Register");
        lblEmailErr = new JLabel ("*Required*");
        lblPasswordErr = new JLabel ("*Required*");

        //adjust size and set layout
        setPreferredSize (new Dimension (478, 331));
        setLayout (null);

        //add components
        add (lblloginHeader);
        add (lblSubHeader);
        add (lblEmailAddress);
        add (txtEmail);
        add (lblPassword);
        add (tstPassword);
        add (btnLogin);
        add (lblRegister);
        add (btnRegister);
        add (lblEmailErr);
        add (lblPasswordErr);

        //set component bounds will be changed again
        lblloginHeader.setBounds (124, 10, 230, 25);
        lblSubHeader.setBounds (10, 40, 225, 25);
        lblEmailAddress.setBounds (10, 75, 225, 25);
        txtEmail.setBounds (10, 105, 225, 25);
        lblPassword.setBounds (10, 140, 225, 25);
        tstPassword.setBounds (10, 175, 225, 25);
        btnLogin.setBounds (10, 230, 100, 25);
        lblRegister.setBounds (15, 285, 220, 25);
        btnRegister.setBounds (250, 285, 100, 25);
        lblEmailErr.setBounds (285, 105, 100, 25);
        lblPasswordErr.setBounds (285, 175, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Student login");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new StudentLoginGUI());
        frame.pack();
        frame.setVisible (true);
    }
}