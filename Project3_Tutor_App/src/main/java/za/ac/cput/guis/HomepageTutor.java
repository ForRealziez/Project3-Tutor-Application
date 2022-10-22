package za.ac.cput.guis;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HomepageTutor extends JFrame implements ActionListener {

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

    public HomepageTutor() {
        super("Home Page");

        font1 = new Font("Verdana", Font.BOLD | Font.ITALIC,50);
        font2 = new Font("Verdana", Font.BOLD | Font.ITALIC,25);

        mainFrame = new JFrame("Homepage");

        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();

        lblAppImage = new JLabel(new ImageIcon("Students.jpg"));
        lblTutorImage = new JLabel(new ImageIcon("Tutors.jpg"));
        lblCPUTImage = new JLabel(new ImageIcon("CPUT.jpg"));

        lblAppName = new JLabel("Student Tutors");
        lblAppName.setFont(font1);
        lblAppName.setForeground(Color.decode("#2B7A78"));
        lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
        lblAppName.setVerticalAlignment(SwingConstants.CENTER);

        lblHomePage = new JLabel("Home Page");
        lblHomePage.setFont(font2);
        lblHomePage.setForeground(Color.decode("#2B7A78"));
        lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
        lblHomePage.setVerticalAlignment(SwingConstants.CENTER);
        //Set font+size here

        txtAboutApp = new JLabel("<html>The purpose of this application is to allow <br/>" +
                " student to seek the necessary learning resources they <br/>" +
                " need to persue their studies at CPUT. <br/> </html>");
        txtAboutApp.setForeground(Color.decode("#DEF2F1"));
        txtAboutTutor = new JLabel("<html> <br/> Tutoring can help strengthen subject comprehension, boost " +
                "confidence, and build important learning <br/> skills." +
                " Tutoring gives students individualized attention that " +
                "they don't get in a crowded classroom.</html>");
        txtAboutTutor.setForeground(Color.decode("#DEF2F1"));
        txtCPUTLinks = new JLabel("<html>https://myclassroom.cput.ac.za/ <br/>");

        txtCPUTLinks.setForeground(Color.decode("#DEF2F1"));

        txtCPUTLinks.setCursor(new Cursor(Cursor.HAND_CURSOR));

        txtCPUTLinks.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    Desktop.getDesktop().browse(new URI("https://myclassroom.cput.ac.za"));

                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnLogout = new JButton("Logout");
        btnLogout.setForeground(Color.white);
        btnLogout.setBackground(Color.decode("#3AAFA9"));
        btnLogout.setBorder(BorderFactory.createLineBorder(Color.black));
        btnLogout.setPreferredSize(new Dimension(27, 27));

        btnStudentDetails = new JButton("Tutor Details");
        btnStudentDetails.setForeground(Color.white);
        btnStudentDetails.setBackground(Color.decode("#3AAFA9"));
        btnStudentDetails.setBorder(BorderFactory.createLineBorder(Color.black));

        btnTutors = new JButton("Tutors");
        btnTutors.setForeground(Color.white);
        btnTutors.setBackground(Color.decode("#3AAFA9"));
        btnTutors.setBorder(BorderFactory.createLineBorder(Color.black));

        btnShop = new JButton("Purchases");
        btnShop.setForeground(Color.white);
        btnShop.setBackground(Color.decode("#3AAFA9"));
        btnShop.setBorder(BorderFactory.createLineBorder(Color.black));

        //Background colours
        panelNorth.setBackground(Color.decode("#17252A"));
        panelCenter.setBackground(Color.decode("#17252A"));
        panelSouth.setBackground(Color.decode("#17252A"));

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

            case "Tutor Details" -> {

                JOptionPane.showMessageDialog(null,"Tutor Details");
                break;
            }
            case "Tutors" -> {

                JOptionPane.showMessageDialog(null,"Tutor Page");
                break;
            }
            case  "Purchases" -> {

                JOptionPane.showMessageDialog(null,"Purchases.");
                break;
            }

        }}

    public static void main(String[] args) {
        new HomepageTutor().setGUI();
    }

}

