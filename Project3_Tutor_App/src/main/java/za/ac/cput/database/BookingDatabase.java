package za.ac.cput.database;

import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;


import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class BookingDatabase extends BaseConnection
{
    public BookingDatabase() throws SQLException, ClassNotFoundException {
        super();
    }

    public Booking GetBooking(String bookinQuery) throws SQLException {
        ResultSet resultSet = Execute(bookinQuery);

        Booking booking = null;

        while (resultSet.next()){
            booking = BookingFactory.createBooking(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4), resultSet.getString(5));
            break;
        }

        Close();

        return booking;
    }

    public Set<Booking> GetBookings(String bookinQuery) throws SQLException {
        ResultSet resultSet = Execute(bookinQuery);

        Set<Booking> bookings = new HashSet<>();


        while (resultSet.next()){
            Booking booking = BookingFactory.createBooking(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4), resultSet.getString(5));
            bookings.add(booking);
        }

        Close();

        return bookings;
    }

    public boolean CreateBooking(String query,Booking booking) throws SQLException, ClassNotFoundException {

        PreparedStatement statement = _connection.prepareStatement(query);

        statement.setString(1,booking.getId());
        statement.setString(2, booking.getTutorId());
        statement.setString(3, booking.getCourseId());
        statement.setString(4, booking.getStartDate());
        statement.setString(5, booking.getEndDate());

        boolean result = statement.execute();
        Close();

        return result;
    }

    public boolean UpdateBooking(String query,Booking booking) throws SQLException {
        PreparedStatement statement = _connection.prepareStatement(query);

        statement.setString(1,booking.getTutorId());
        statement.setString(2,booking.getCourseId());
        statement.setString(3,booking.getStartDate());
        statement.setString(4,booking.getEndDate());
        statement.setString(5,booking.getId());

        boolean result = statement.execute();
        Close();

        return result;
    }
    public boolean DeleteBooking(String query, String id) throws SQLException {

        PreparedStatement statement = _connection.prepareStatement(query);

        statement.setString(1,id);

        boolean result = statement.execute();

        Close();

        return result;
    }


}