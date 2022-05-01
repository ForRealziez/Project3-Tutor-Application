package za.ac.cput.guis;

/*
 * ResourceGui.java
 * author Mogamad Taariq Phillips : 220166153
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResourceGUI extends JFrame implements ActionListener
{
    JLabel lblImage, lblHeading, lblItemName, lblDescription, lblAvailability;
    JComboBox cboItemName;
    JTextField txtItemName;
    JPanel panelAvailability, panelCenter, panelNorth, panelSouth;
    JRadioButton radAvailable , radUnavailable;
    ButtonGroup AvailabilityButtonGroup;
    JButton btnNext, btnPrevious, btnExit;
    Font ft1, ft2, ft3;

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

        lblImage = new JLabel(new ImageIcon("Resource.PNG"));
        // Images will be of the selected item

        lblItemName = new JLabel("Item Name: ", SwingConstants.CENTER);
        lblItemName.setFont(ft2);
        String listOfItemName[] = {"item 1", "item 2", "item 3"};
        //combo box will link to database to show selectable items
        cboItemName = new JComboBox(listOfItemName);
        cboItemName.setForeground(Color.white);
        cboItemName.setBackground(Color.DARK_GRAY);

        lblDescription = new JLabel("Description: ", SwingConstants.CENTER);
        lblDescription.setFont(ft2);
        txtItemName = new JTextField(20);
        // Descriptions of the various different items will change as an item is selected
        txtItemName = new JTextField("Description about the item.");
        txtItemName.setEditable(false);
        txtItemName.setForeground(Color.white);
        txtItemName.setBackground(Color.DARK_GRAY);

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
        radAvailable.setSelected(true);
        panelAvailability.add(radAvailable);
        panelAvailability.add(radUnavailable);

        btnNext = new JButton("Next");
        btnNext.setForeground(Color.white);
        btnNext.setBackground(Color.DARK_GRAY);
        btnNext.setFont(ft1);

        btnPrevious = new JButton("Previous");
        btnPrevious.setForeground(Color.white);
        btnPrevious.setBackground(Color.DARK_GRAY);
        btnPrevious.setFont(ft1);

        btnExit = new JButton("Exit");
        btnExit.setForeground(Color.white);
        btnExit.setBackground(Color.DARK_GRAY);
        btnExit.setFont(ft1);

    }

    public void setGUI()
    {
        panelCenter.setLayout(new GridLayout(4, 7));
        panelNorth.setLayout(new GridLayout(1, 1));

        panelNorth.add(lblHeading);

        panelCenter.add(lblItemName);
        panelCenter.add(cboItemName);

        panelCenter.add(lblDescription);
        panelCenter.add(txtItemName);

        panelCenter.add(lblImage);


        panelCenter.add(panelAvailability);

        panelSouth.add(btnNext);
        panelSouth.add(btnPrevious);
        panelSouth.add(btnExit);

        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
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
        if (e.getActionCommand().equals("Next"))
        {
            System.exit(0);
        }

        if (e.getActionCommand().equals("Previous"))
        {
            System.exit(0);
        }

        else if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }
//    public static void main(String[] args)
//   {
 //       new ResourceGUI().setGUI();
 //   }

 }

