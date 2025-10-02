package com.avdhesh.gautam.carworldenterprise.service;

import com.avdhesh.gautam.carworldenterprise.models.Booking;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService
{
    private List<Booking> bookings = new ArrayList<>();
    private Long bookingId = 1L;

    @Override
    public String createBookings(List<Booking> allBookings)
    {
        for (Booking booking : allBookings)
        {
            booking.setId(getNextBookingId());
            bookings.add(booking);
        }

        return "Booking(s) added successfully!";
    }

    @Override
    public List<Booking> getAllBookings()
    {
        return this.bookings;
    }

    @Override
    public Booking getBookingById(Long bookingId)
    {
        return bookings.stream()
                .filter(booking -> booking.getId().equals(bookingId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No booking found with the given Id: " + bookingId));
    }

    @Override
    public String updateBookingById(Booking newBooking, Long bookingId)
    {
        Booking foundBooking = getBookingById(bookingId);
        if (newBooking.getPaymentStatus() != null)
        {
            foundBooking.setPaymentStatus(newBooking.getPaymentStatus());
            return "Booking updated with the Id: " + bookingId;
        }

        return "Cannot update Booking with the Id: " + bookingId;
    }

    @Override
    public String deleteBookingById(Long bookingId)
    {
        Booking foundBooking = getBookingById(bookingId);

        bookings.remove(foundBooking);
        return "Booking deleted with the Id: " + bookingId;
    }

    public List<Booking> getAllBookingsByUserId(Long userId)
    {
        List<Booking> bookingsByUser = bookings.stream()
                .filter(booking -> booking.getUserId().equals(userId))
                .toList();

        if (bookingsByUser.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No bookings done by this user with Id: " + userId);
        }

        return bookingsByUser;
    }

    private Long getNextBookingId() { return bookingId++; }
}
