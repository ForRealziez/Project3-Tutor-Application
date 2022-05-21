package za.ac.cput.database;

import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class BookingDatabase extends BaseConnection
{
    private Connection _connection;
    public BookingDatabase() throws SQLException, ClassNotFoundException {
        super();
    }


    public Booking GetBooking(String bookinQuery) throws SQLException {
        ResultSet resultSet = Execute(bookinQuery);

        Booking booking = null;

        while (resultSet.next()){
            booking = BookingFactory.createBooking(resultSet.getString(0), resultSet.getString(1),
                    resultSet.getString(2),resultSet.getString(3), resultSet.getString(4));
        }

        Close();

        return booking;
    }

    public Set<Booking> GetBookings(String bookinQuery) throws SQLException {
        ResultSet resultSet = Execute(bookinQuery);

        Set<Booking> bookings = new HashSet<>();


        while (resultSet.next()){
            Booking booking = BookingFactory.createBooking(resultSet.getString(0), resultSet.getString(1),
                    resultSet.getString(2),resultSet.getString(3), resultSet.getString(4));
            bookings.add(booking);
        }

        Close();

        return bookings;
    }

    public boolean CreateBooking(String query) throws SQLException {
        ResultSet resultSet = Execute(query);

        boolean result = resultSet.rowInserted();

        Close();

        return result;
    }


}