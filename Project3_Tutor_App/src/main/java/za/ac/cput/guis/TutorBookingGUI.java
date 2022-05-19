package za.ac.cput.guis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TutorBookingGUI {
    private JButton bookNowButton;
    private JButton searchTutorButton;
    private JButton resourcesButton;
    private JButton studentDetailsButton;
    private JButton coursesButton;
    private JButton homeButton;
    private JButton loginButton;
    private JButton logoutButton;
    private JLabel imageMapLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        imageMapLabel = new JLabel();
        bookNowButton = new JButton();

        bookNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load a new form
            }
        });

        imageMapLabel.setIcon(new ImageIcon("map-icon-image.png"));

    }
}
