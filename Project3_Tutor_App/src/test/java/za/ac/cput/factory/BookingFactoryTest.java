package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Booking;


import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void createBooking() {
        Booking booking = BookingFactory.createBooking("214258041LG","LEE","ITS","2022-03-17","2022-04-04");
        assertNotNull(booking);

    }
}