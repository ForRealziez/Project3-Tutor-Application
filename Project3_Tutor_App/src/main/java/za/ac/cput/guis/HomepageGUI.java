package za.ac.cput.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomepageGUI extends JFrame implements ActionListener {

    private JFrame mainFrame;

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

        mainFrame = new JFrame("Homepage");

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
        btnLogout.setBorder(BorderFactory.createLineBorder(Color.black));
        btnLogout.setPreferredSize(new Dimension(27, 27));

        btnStudentDetails = new JButton("Student Details");
        btnStudentDetails.setBorder(BorderFactory.createLineBorder(Color.black));
        btnTutors = new JButton("Tutors");
        btnTutors.setBorder(BorderFactory.createLineBorder(Color.black));
        btnShop = new JButton("Purchases");
        btnShop.setBorder(BorderFactory.createLineBorder(Color.black));

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

        mainFrame.add(panelNorth, BorderLayout.NORTH);
        mainFrame.add(panelCenter, BorderLayout.CENTER);
        mainFrame.add(panelSouth, BorderLayout.SOUTH);
        mainFrame.getContentPane().setBackground(Color.RED);
        setUndecorated(true);
        mainFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        mainFrame.setSize(650,500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);}
        });

    }

    public void actionPerformed(ActionEvent e){

        switch (e.getActionCommand()) {

            case "Logout" -> {

                System.exit(0);

                break;}

        }}

    public static void main(String[] args) {
        new HomepageGUI().setGUI();
    }

}

