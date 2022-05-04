package za.ac.cput.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomepageGUI extends JFrame implements ActionListener{

    private JPanel panelNorth;
    private JPanel panelCenter;
    private JPanel panelSouth;

    private JLabel lblAppName;
    private JLabel lblHomePage;
    private JButton btnLogout;

    private JLabel lblAppImage;
    private JLabel lblTutorImage;
    private JLabel lblCPUTImage;
    private JLabel txtAboutApp;
    private JLabel txtAboutTutor;
    private JLabel txtCPUTLinks;

    private JButton btnStudentDetails;
    private JButton btnTutors;
    private JButton btnShop;

    private Font font1;
    private Font font2;

    public HomepageGUI() {
        super("Home Page");

        font1 = new Font("Times New Roman", Font.BOLD | Font.ITALIC,50);
        font2 = new Font("Courier", Font.ITALIC,25);

        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        lblAppImage = new JLabel(new ImageIcon("Students.jpg"));
        lblTutorImage = new JLabel(new ImageIcon("Tutors.jpg"));
        lblCPUTImage = new JLabel(new ImageIcon("CPUT.jpg"));

        lblAppName = new JLabel("Student Tutors");
        lblAppName.setFont(font1);
        lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
        lblAppName.setVerticalAlignment(SwingConstants.CENTER);

        lblHomePage = new JLabel("Home Page");
        lblHomePage.setFont(font2);
        lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
        lblHomePage.setVerticalAlignment(SwingConstants.CENTER);
        //Set font+size here

        txtAboutApp = new JLabel("<html>The purpose of this application is to allow <br/>" +
                " student to seek the necessary learning resources they <br/>" +
                " need to persue their studies at CPUT.</html>");
        txtAboutTutor = new JLabel("<html>Tutoring can help strengthen subject comprehension, boost <br/>" +
                "confidence, and build important learning skills.<br/>" +
                " Tutoring gives students individualized attention that <br/>" +
                "they don't get in a crowded classroom.</html>");
        txtCPUTLinks = new JLabel("<html>https://myclassroom.cput.ac.za/ <br/>" +
                "https://www.cput.ac.za/students/about/sos <br/>" +
                "https://opa.cput.ac.za/ <br/>");

        btnLogout = new JButton("Logout");
        btnStudentDetails = new JButton("Student Details");
        btnTutors = new JButton("Tutors");
        btnShop = new JButton("Purchases");

        //Background colours
        panelNorth.setBackground(Color.CYAN);
        panelCenter.setBackground(Color.CYAN);
        panelSouth.setBackground(Color.CYAN);

    }

    public void setGUI() {
        panelNorth.setLayout(new GridLayout(2,1));
        panelCenter.setLayout(new GridLayout(4,2));
        panelSouth.setLayout(new GridLayout(1,4));

        panelNorth.add(lblAppName);
        panelNorth.add(lblHomePage);

        panelCenter.add(lblAppImage);
        panelCenter.add(txtAboutApp);
        panelCenter.add(lblTutorImage);
        panelCenter.add(txtAboutTutor);
        panelCenter.add(lblCPUTImage);
        panelCenter.add(txtCPUTLinks);

        panelSouth.add(btnStudentDetails);
        panelSouth.add(btnTutors);
        panelSouth.add(btnShop);
        panelSouth.add(btnLogout);

        btnStudentDetails.addActionListener(this);
        btnTutors.addActionListener(this);
        btnShop.addActionListener(this);
        btnLogout.addActionListener(this);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.getContentPane().setBackground(Color.RED);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        //Add Action Listeners for Buttons
    }

    public static void main(String[] args) {
        new HomepageGUI().setGUI();
    }

}
