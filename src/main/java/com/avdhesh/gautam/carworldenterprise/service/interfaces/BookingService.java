package com.avdhesh.gautam.carworldenterprise.service.interfaces;

import com.avdhesh.gautam.carworldenterprise.models.Booking;

import java.util.List;

public interface BookingService
{
    String createBookings(List<Booking> bookings);
    List<Booking> getAllBookings();
    Booking getBookingById(Long bookingId);
    String updateBookingById(Booking newBooking, Long bookingId);
    String deleteBookingById(Long bookingId);
}
