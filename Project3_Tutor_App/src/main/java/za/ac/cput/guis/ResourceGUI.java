package za.ac.cput.guis;

/*
 * ResourceGui.java
 * author Mogamad Taariq Phillips : 220166153
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
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
    JButton btnNext, btnExit;
    Font ft1, ft2, ft3;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String imageName, Availability, iName, Description, ownerContact;

    public ResourceGUI()
    {
        super("Resources");

        ft1 = new Font("Times New Roman", Font.ITALIC, 16);
        ft2 = new Font("Verdana", Font.PLAIN, 14);
        ft3 = new Font("Verdana", Font.BOLD, 30);

        lblHeading = new JLabel("Resources", SwingConstants.CENTER);
        lblHeading.setFont(ft3);

        panelCenter = new JPanel();
        panelCenter.setBackground(Color.LIGHT_GRAY);

        panelNorth = new JPanel();
        panelNorth.setBackground(Color.LIGHT_GRAY);

        panelSouth = new JPanel();
        panelSouth.setBackground(Color.LIGHT_GRAY);
        imageName = "Resource.PNG";
        lblImage = new JLabel(new ImageIcon(imageName));
        // Images will be of the selected item

        lblItemName = new JLabel("Item Name: ", SwingConstants.CENTER);
        lblItemName.setFont(ft2);
        //combo box will link to database to show selectable items
        cboItemName = new JComboBox();
        cboItemName.setForeground(Color.white);
        cboItemName.setBackground(Color.DARK_GRAY);

        lblDescription = new JLabel("Description: ", SwingConstants.CENTER);
        lblDescription.setFont(ft2);
        // Descriptions of the various different items will change as an item is selected
        txtDescription = new JTextArea();
        txtDescription.setEditable(false);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setForeground(Color.white);
        txtDescription.setBackground(Color.DARK_GRAY);

        lblOwner = new JLabel("Owner's Contact: ", SwingConstants.CENTER);
        lblOwner.setFont(ft2);
        txtOwner = new JTextField(20);
        // Descriptions of the various different items will change as an item is selected
        txtOwner = new JTextField();
        txtOwner.setEditable(false);
        txtOwner.setForeground(Color.white);
        txtOwner.setBackground(Color.DARK_GRAY);

        lblAvailability = new JLabel("Availability: ");
        lblAvailability.setFont(ft2);
        panelAvailability = new JPanel();
        radAvailable = new JRadioButton("Available");
        radAvailable.setBackground(Color.LIGHT_GRAY);
        radUnavailable = new JRadioButton("Unavailable");
        radUnavailable.setBackground(Color.LIGHT_GRAY);
        AvailabilityButtonGroup = new ButtonGroup();
        AvailabilityButtonGroup.add(radAvailable);
        AvailabilityButtonGroup.add(radUnavailable);
        panelAvailability.setLayout(new GridLayout(1, 2));
        panelAvailability.add(radAvailable);
        panelAvailability.add(radUnavailable);


        btnNext = new JButton("Update");
        btnNext.setForeground(Color.white);
        btnNext.setBackground(Color.DARK_GRAY);
        btnNext.setFont(ft1);

        btnExit = new JButton("Exit");
        btnExit.setForeground(Color.white);
        btnExit.setBackground(Color.DARK_GRAY);
        btnExit.setFont(ft1);

    }

    public void updateItemName()
    {
        try {
            pst = con.prepareStatement("select * from resources");
            rs = pst.executeQuery();
            while(rs.next()){
                cboItemName.addItem(rs.getString("Item_Name"));
            }
        } catch (Exception e) {
        }
    }

    public void setGUI()
    {
        connect();
        updateItemName();

        panelCenter.setLayout(new GridLayout(4, 7));
        panelNorth.setLayout(new GridLayout(1, 1));

        panelNorth.add(lblHeading);

        panelCenter.add(lblItemName);
        panelCenter.add(cboItemName);

        panelCenter.add(lblDescription);
        panelCenter.add(txtDescription);

        panelCenter.add(lblOwner);
        panelCenter.add(txtOwner);

        panelCenter.add(lblImage);


        panelCenter.add(panelAvailability);

        panelSouth.add(btnNext);
        panelSouth.add(btnExit);

        btnNext.addActionListener(this);
        btnExit.addActionListener(this);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Update"))
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
//                    imageName = rs.getString("ImageID");



                    txtDescription.setText(Description);
                    txtOwner.setText(ownerContact);
//                    lblImage.setText(imageName);

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

        else if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }

    public void connect()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tutorapplication", "root","");
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

    public static void main(String[] args)
    {
        new ResourceGUI().setGUI();

    }

}