package za.ac.cput.guis;
/* TutorBookingGUI.java
GUI for the TutorBooking
Author: 214258041_Lelihle Gazi
 */

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import za.ac.cput.database.BookingDatabase;
import za.ac.cput.database.TutorDatabase;
import za.ac.cput.entity.Booking;
import za.ac.cput.entity.Tutor;
import za.ac.cput.factory.BookingFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

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
    private JButton btnDetails;
    private TutorDatabase tutorDatabase;

    private BookingDatabase bookingDatabase;
    private Tutor[] arrtutors;
    private int startingId = 1;
    public TutorBookingGUI() throws SQLException, ClassNotFoundException {
        tutorDatabase = new TutorDatabase();
        bookingDatabase = new BookingDatabase();
        Set<Tutor> tutors = tutorDatabase.GetTutors("select * from tutors");
        String[] cmbCourseItems = {"Select","ADP", "CMD", "MUD"};
        String[] cmbTutorItems = new String[tutors.size()];

        //arrtutors = (Tutor[]) tutors.toArray();
        arrtutors = new Tutor[tutors.size()];

        int j = 0;
        for(Tutor tutor: tutors){
            arrtutors[j++] = tutor;
        }
        for (int i =0; i< arrtutors.length;i++
             ) {
            cmbTutorItems[i] = arrtutors[i].getFirstName() + " " + arrtutors[i].getLastName();
        }
        lblHeader = new JLabel ("Tutor Booking");
        lblHeader.setForeground(Color.white);
        lblHeader.setFont(new Font("Verdana", Font.BOLD, 30));
        lblSubHeader = new JLabel ("Fill in the required details");
        lblSubHeader.setFont(new Font("Verdana",Font.BOLD,27));
        lblSubHeader.setForeground(Color.white);
        lblCourse = new JLabel ("Course");
        lblCourse.setForeground(Color.white);
        cmbCourse = new JComboBox (cmbCourseItems);
        AutoCompleteDecorator.decorate(cmbCourse);
        AutoCompleteDecorator.decorate(cmbTutor);
        lblCourseError = new JLabel ("*Required*");
        lblCourseError.setForeground(Color.white);
        lblTutor = new JLabel("Tutor");
        lblTutor.setForeground(Color.white);
        cmbTutor = new JComboBox(cmbTutorItems);
        lblTutorError = new JLabel ("*Required*");
        lblTutorError.setForeground(Color.white);
        btnBook = new JButton ("Book");
        btnDetails = new JButton("Tutor details");

        btnBook.setBackground(Color.getColor("#3AAFA9"));
        btnBook.setForeground(Color.white);
        btnDetails.setBackground(Color.getColor("#FEFFFF"));
        btnDetails.setForeground(Color.white);

        //adjust size and set layout
        this.setPreferredSize (new Dimension (535, 335));
        this.setLayout (null);
        this.setBackground(Color.getColor("#17252A"));

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
        add(btnDetails);

        btnBook.addActionListener(this);
        btnDetails.addActionListener(this);

        //set component bounds
        lblHeader.setBounds (224, 10, 180, 30);
        lblSubHeader.setBounds (10, 55, 180, 25);
        lblCourse.setBounds (10, 85, 100, 25);
        cmbCourse.setBounds (10, 105, 100, 25);
        lblCourseError.setBounds (225, 105, 100, 25);
        lblTutor.setBounds (10, 135, 100, 25);
        cmbTutor.setBounds (10, 165, 100, 25);
        btnDetails.setBounds(10 , 215,130,25);
        lblTutorError.setBounds (225, 165, 100, 25);
        btnBook.setBounds(224,260,100,25);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int tutorIndex = cmbTutor.getSelectedIndex();
        Tutor tutor = arrtutors[tutorIndex];
        Component frame = null;
        if (e.getSource() == btnBook) {
            btnBook.setEnabled(true);
            String course = cmbCourse.getSelectedItem().toString();
            if(course == null || course.isEmpty() || course == "Select"){
                JOptionPane.showMessageDialog(frame, "Course name is required");
                return;
            }

            if (tutor == null){
                JOptionPane.showMessageDialog(frame, "Tutor name is required");
                return;
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Booking booking = BookingFactory.createBooking(String.valueOf(startingId),tutor.getId(),course,dtf.format(now),dtf.format(now));
            try {
                bookingDatabase.CreateBooking("insert into bookings values(?,?, ?,?, ?)",booking);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            JOptionPane.showMessageDialog(frame, "Details saved");
        }
        if (e.getSource() == btnDetails){
            JOptionPane.showMessageDialog(frame, "FirstName: " + tutor.getFirstName() + "\n"
                    + "LastName: " + tutor.getLastName() + "\n"
                    + "UserName: " + tutor.getUsername() + "\n"
                    + "Email: " + tutor.getEmail() + "\n"
                    + "Student Number: " + tutor.getStudentNumber() + "\n"
            );
            return;
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame ("Booking Tutor");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new TutorBookingGUI());
        frame.pack();
        frame.setVisible (true);
    }
}
