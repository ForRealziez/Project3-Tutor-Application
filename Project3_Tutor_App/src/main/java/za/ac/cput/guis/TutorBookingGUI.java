package za.ac.cput.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TutorBookingGUI extends JPanel implements ActionListener {
    private JLabel lblHeader;
    private JLabel lblSubHeader;

    private JComboBox cmbCourse;
    private JLabel lblCourseError;
    private JLabel lblCourse;

    private JComboBox cmbTutor;
    private JLabel lblTutorError;
    private JLabel lblTutor;
    private JButton btnBook;
    public TutorBookingGUI(){
        String[] cmbCourseItems = {"Select","ADP", "CMD", "MUD"};
        String[] cmbTutorItems = {"Select","Lee", "Jody", "Chantel"};
        lblHeader = new JLabel ("Tutor Booking");
        lblSubHeader = new JLabel ("Fill in the required details");
        lblCourse = new JLabel ("Course");
        cmbCourse = new JComboBox (cmbCourseItems);
        lblCourseError = new JLabel ("*Required*");
        lblTutor = new JLabel("Tutor");
        cmbTutor = new JComboBox(cmbTutorItems);
        lblTutorError = new JLabel ("*Required*");
        btnBook = new JButton ("Book");

        //adjust size and set layout
        this.setPreferredSize (new Dimension (535, 335));
        this.setLayout (null);

        //add components
        add (lblHeader);
        add (lblSubHeader);
        add (lblCourse);
        add (cmbCourse);
        add (lblCourseError);
        add (lblTutor);
        add (cmbTutor);
        add (lblTutorError);
        add(btnBook);

        btnBook.addActionListener(this);

        //set component bounds
        lblHeader.setBounds (10, 10, 180, 25);
        lblSubHeader.setBounds (10, 55, 180, 25);
        lblCourse.setBounds (10, 85, 100, 25);
        cmbCourse.setBounds (10, 105, 100, 25);
        lblCourseError.setBounds (225, 105, 100, 25);
        lblTutor.setBounds (10, 135, 100, 25);
        cmbTutor.setBounds (10, 165, 100, 25);
        lblTutorError.setBounds (225, 165, 100, 25);
        btnBook.setBounds(100,240,100,25);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBook) {
            btnBook.setEnabled(true);
            String course = cmbCourse.getSelectedItem().toString();
            String tutor = cmbTutor.getSelectedItem().toString();
            Component frame = null;
            if(course == null || course.isEmpty() || course == "Select"){
                JOptionPane.showMessageDialog(frame, "Course name is required");
                return;
            }

            if (tutor == null || tutor.isEmpty() || tutor == "Select"){
                JOptionPane.showMessageDialog(frame, "Tutor name is required");
                return;
            }

            JOptionPane.showMessageDialog(frame, "Details saved");
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Booking Tutor");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new TutorBookingGUI());
        frame.pack();
        frame.setVisible (true);
    }
}
