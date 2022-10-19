package za.ac.cput.guis;

/*
 * ResourceGui.java
 * author Mogamad Taariq Phillips : 220166153
 */
import za.ac.cput.database.Database;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class ResourceGUI extends JFrame implements ActionListener
{
    JLabel lblImage, lblHeading, lblItemName, lblDescription, lblOwner, lblAvailability;
    JComboBox cboItemName;
    JTextField txtOwner;
    JTextArea txtDescription;
    JPanel panelAvailability, panelCenter, panelNorth, panelSouth;
    JRadioButton radAvailable , radUnavailable;
    ButtonGroup AvailabilityButtonGroup;
    JButton btnHome,btnNext, btnExit;
    Font ft1, ft2, ft3;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String imageName, Availability, iName, Description, ownerContact;

    public ResourceGUI()
    {
        super("Resources");

        ft1 = new Font("Times New Roman", Font.PLAIN, 16);
        ft2 = new Font("Verdana", Font.PLAIN, 27);
        ft3 = new Font("Verdana", Font.BOLD, 30);

        lblHeading = new JLabel("Resources", SwingConstants.CENTER);
        lblHeading.setFont(ft3);
        lblHeading.setForeground(Color.white);

        panelCenter = new JPanel();
        panelCenter.setBackground(Color.decode("#17252A"));

        panelNorth = new JPanel();
        panelNorth.setBackground(Color.decode("#17252A"));

        panelSouth = new JPanel();
        panelSouth.setBackground(Color.decode("#17252A"));

        imageName = "Project3_Tutor_App/src/main/java/za/ac/cput/guis/images/";
        lblImage = new JLabel(new ImageIcon(imageName));
        // Images will be of the selected item

        lblItemName = new JLabel("Item Name: ", SwingConstants.CENTER);
        lblItemName.setFont(ft2);
        lblItemName.setForeground(Color.white);
        //combo box will link to database to show selectable items
        cboItemName = new JComboBox();
        cboItemName.setForeground(Color.white);
        cboItemName.setBackground(Color.decode("#2B7A78"));

        lblDescription = new JLabel("Description: ", SwingConstants.CENTER);
        lblDescription.setFont(ft2);
        lblDescription.setForeground(Color.white);
        // Descriptions of the various different items will change as an item is selected
        txtDescription = new JTextArea();
        txtDescription.setEditable(false);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setForeground(Color.white);
        txtDescription.setBackground(Color.decode("#2B7A78"));

        lblOwner = new JLabel("Owner's Contact: ", SwingConstants.CENTER);
        lblOwner.setFont(ft2);
        lblOwner.setForeground(Color.white);
        txtOwner = new JTextField(20);
        // Descriptions of the various different items will change as an item is selected
        txtOwner = new JTextField();
        txtOwner.setEditable(false);
        txtOwner.setForeground(Color.white);
        txtOwner.setBackground(Color.decode("#2B7A78"));

        lblAvailability = new JLabel("Availability: ");
        lblAvailability.setFont(ft3);
        lblAvailability.setForeground(Color.white);
        panelAvailability = new JPanel();
        radAvailable = new JRadioButton("Available");
        radAvailable.setForeground(Color.white);
        radAvailable.setBackground(Color.decode("#17252A"));
        radUnavailable = new JRadioButton("Unavailable");
        radUnavailable.setForeground(Color.white);
        radUnavailable.setBackground(Color.decode("#17252A"));
        AvailabilityButtonGroup = new ButtonGroup();
        AvailabilityButtonGroup.add(radAvailable);
        AvailabilityButtonGroup.add(radUnavailable);
        panelAvailability.setLayout(new GridLayout(1, 2));
        panelAvailability.add(radAvailable);
        panelAvailability.add(radUnavailable);

        btnHome = new JButton("Home");
        btnHome.setForeground(Color.white);
        btnHome.setBackground(Color.decode("#3AAFA9"));
        btnHome.setFont(ft2);

        btnNext = new JButton("Search");
        btnNext.setForeground(Color.white);
        btnNext.setBackground(Color.decode("#3AAFA9"));
        btnNext.setFont(ft2);

        btnExit = new JButton("Exit");
        btnExit.setForeground(Color.white);
        btnExit.setBackground(Color.decode("#3AAFA9"));
        btnExit.setFont(ft2);

    }

    public void updateItemName()
    {
        try {
            pst = con.prepareStatement("select * from resources");
            rs = pst.executeQuery();
            while(rs.next())
            {
                cboItemName.addItem(rs.getString("Item_Name"));
            }
        } catch (Exception e) {}
    }

    public void setGUI()
    {
        connect();
        updateItemName();

        panelCenter.setLayout(new GridLayout(4, 7));
        panelNorth.setLayout(new GridLayout(0, 1));

        panelNorth.add(lblHeading);

        panelCenter.add(lblItemName);
        panelCenter.add(cboItemName);

        panelCenter.add(lblDescription);
        panelCenter.add(txtDescription);

        panelCenter.add(lblOwner);
        panelCenter.add(txtOwner);

        panelCenter.add(lblImage);

        panelCenter.add(panelAvailability);

//        panelSouth.add(panelButton);
        panelSouth.add(btnNext);
        panelSouth.add(btnHome);
        panelSouth.add(btnExit);

        btnNext.addActionListener(this);
        btnExit.addActionListener(this);
        btnHome.addActionListener(this);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setSize(800, 850);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Search"))
        {
            try {

                iName = (String) cboItemName.getSelectedItem();
                pst = con.prepareStatement("select * from resources where Item_Name = ?");
                pst.setString(1, iName);
                rs = pst.executeQuery();

                if(rs.next()==true)
                {
                    Description = rs.getString("Description");
                    ownerContact = rs.getString("Owner_Contact");
                    Availability = rs.getString("Availability");
                    imageName = rs.getString("ImageID");

                    txtDescription.setText(Description);
                    txtOwner.setText(ownerContact);
                    lblImage.setIcon(new ImageIcon("Project3_Tutor_App/src/main/java/za/ac/cput/guis/images/"+imageName));

                    if(Availability.equals("true")){
                        radAvailable.setSelected(true);
                    }   else {
                        radAvailable.setSelected(false);
                    }
                    if(Availability.equals("false")){
                        radUnavailable.setSelected(true);
                    }   else {
                        radUnavailable.setSelected(false);
                    }
                }

                else
                {
                    txtDescription.setText("");
                    txtOwner.setText("");
                    JOptionPane.showMessageDialog(null,"Invalid Item Name selected");

                }
            }

            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == btnHome)
        {
            dispose();
            new za.ac.cput.gui.HomePageGUI().setGUI();
        }
        else if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }

    public void connect()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tutorapp", "root","");
            System.out.println("Database Connection Success");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}