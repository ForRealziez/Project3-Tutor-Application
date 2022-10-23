package za.ac.cput.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TutorLogin extends JDialog{
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnRegister;
    private JPanel loginPanel;
    private JButton homeButton;

    public TutorLogin(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(550,574));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                final String DB_URL = "jdbc:mysql://localhost/projectApp";
                final String USERNAME = "root";
                final String PASSWORD = "";

                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                    String sql = "SELECT * FROM Staff WHERE email =? AND password =?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        });


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginA tt = new LoginA();
                tt.dispose();
                tt.setTitle("LoginA");
                tt.setVisible(true);

            }
        });
    }


    public static void main(String[] args) {
        TutorLogin TutorLogin = new TutorLogin(null);



    }
}
