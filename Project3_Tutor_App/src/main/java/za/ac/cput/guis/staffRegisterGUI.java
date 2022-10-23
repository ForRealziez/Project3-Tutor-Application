
package za.ac.cput.guis;
/*
 Project 3
 Author: Titilayo Nikelwa Ore-ofe Akinjole (220283982)
 Staff Registration GUI
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class staffRegisterGUI implements ActionListener{

    //Creating object of JFrame class
    JFrame frame;

    //Objects
    String[] gender= new String[]{"CHOOSE GENDER","Male", "Female"};

    JLabel nameLabel = new JLabel("NAME: ");
    JTextField nameTextField = new JTextField();


    JLabel surnameLabel = new JLabel("SURNAME: ");
    JTextField surnameTextField = new JTextField();

    JLabel genderLabel = new JLabel("GENDER: ");
    JComboBox genderComboBox = new JComboBox(gender);

    JLabel passwordLabel = new JLabel("PASSWORD: ");
    JPasswordField passwordField = new JPasswordField();

    JLabel confirmPasswordLabel = new JLabel("CONFIRM: ");
    JPasswordField confirmPasswordField = new JPasswordField();

    JLabel physicalAddressLabel = new JLabel("PHYSICAL ADDRESS: ");
    JTextField physicalAddressTextField = new JTextField();

    JLabel emailLabel = new JLabel("EMAIL: ");
    JTextField emailTextField = new JTextField();

    JLabel courseLabel = new JLabel("COURSE: ");
    JTextField courseTextField = new JTextField();

    JButton registerButton = new JButton("REGISTER");
    JButton resetButton = new JButton("RESET");


    //Constructor

    staffRegisterGUI(){
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
    }

    public void createWindow(){
        //Properties of JFrame//
        frame = new JFrame();
        frame.setTitle("Staff Registration Form");
        frame.setBounds(40,40,450,900);
        frame.getContentPane().setBackground(Color.blue);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    public void setLocationAndSize(){
        nameLabel.setBounds(20,20,70,70);
        nameTextField.setBounds(200,43,165,23);

        surnameLabel.setBounds(20, 70, 100, 70);
        surnameTextField.setBounds(200,93,165,23);

        genderLabel.setBounds(20,120,80,70);
        genderComboBox.setBounds(200,143,165,23);

        emailLabel.setBounds(20,170,100,70);
        emailTextField.setBounds(200,193,165,23);

        physicalAddressLabel.setBounds(20,220,140,70);
        physicalAddressTextField.setBounds(200,243,165,23);

        courseLabel.setBounds(20,270,100,70);
        courseTextField.setBounds(200,293,165,23);

        passwordLabel.setBounds(20,320,100,70);
        passwordField.setBounds(200,343,165,23);

        confirmPasswordLabel.setBounds(20,370,140,70);
        confirmPasswordField.setBounds(200,393,165,23);

        registerButton.setBounds(70,470,100,35);
        resetButton.setBounds(220,470,100,35);

    }

    public void addComponentsToFrame(){
        frame.add(nameLabel);
        frame.add(surnameLabel);
        frame.add(genderLabel);
        frame.add(emailLabel);
        frame.add(physicalAddressLabel);
        frame.add(courseLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordField);
        frame.add(nameTextField);
        frame.add(surnameTextField);
        frame.add(genderComboBox);
        frame.add(emailTextField);
        frame.add(physicalAddressTextField);
        frame.add(courseTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(registerButton);
        frame.add(resetButton);

    }
    public void actionEvent(){

        //add action listener to buttons
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

//    public static void main(String[] args) {
//        new staffRegisterGUI();
//    }
}
