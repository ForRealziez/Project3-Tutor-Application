package za.ac.cput.guis;

import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.repository.BookingRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingGUIForm {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton createButton;

    public BookingGUIForm() throws SQLException, ClassNotFoundException {
        BookingRepository repository = BookingRepository.getRepository();

        String [] tutors = {"Lelihle","Siphiwe", "Anthony", "John"};
        this.comboBox1 = new JComboBox<>(tutors);

        String[] courses = { "ADP","ITS","PRT","ADT", "PM"};

        this.comboBox2 = new JComboBox(courses);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
                LocalDate localDate = LocalDate.now();
                LocalDate enddate = LocalDate.now().plusDays(1);
                Booking booking = BookingFactory.createBooking("214567889",comboBox1.getSelectedItem().toString(),
                        comboBox2.getSelectedItem().toString(),dtf.format(localDate),dtf.format(enddate));

                try {
                    repository.create(booking);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
