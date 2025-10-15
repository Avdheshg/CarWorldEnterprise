package com.avdhesh.gautam.carworldenterprise.service;

import com.avdhesh.gautam.carworldenterprise.models.Booking;
import com.avdhesh.gautam.carworldenterprise.repositories.BookingRepository;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService
{
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public String createBookings(List<Booking> allBookings)
    {
        bookingRepository.saveAll(allBookings);

        return "Booking(s) added successfully!";
    }

    @Override
    public List<Booking> getAllBookings()
    {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long bookingId)
    {
        Optional<Booking> foundBooking = bookingRepository.findById(bookingId);

        return foundBooking
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No booking found with the given Id: " + bookingId));
    }

    @Override
    public String updateBookingById(Booking newBooking, Long bookingId)
    {
        Booking foundBooking = getBookingById(bookingId);

        if (newBooking.getPaymentStatus() != null)
        {
            foundBooking.setPaymentStatus(newBooking.getPaymentStatus());
            bookingRepository.save(foundBooking);
            return "Booking updated with the Id: " + bookingId;
        }

        return "Cannot update Booking with the Id: " + bookingId;
    }

    @Override
    public String deleteBookingById(Long bookingId)
    {
        bookingRepository.deleteById(bookingId);
        return "Booking deleted with the Id: " + bookingId;
    }

//    public List<Booking> getAllBookingsByUserId(Long userId)
//    {
//        bookingRespository
//        List<Booking> bookingsByUser = bookings.stream()
//                .filter(booking -> booking.getUserId().equals(userId))
//                .toList();
//
//        if (bookingsByUser.isEmpty())
//        {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No bookings done by this user with Id: " + userId);
//        }
//
//        return bookingsByUser;
//    }
    // https://medium.com/@hk09/spring-boot-one-to-many-relationship-e617183b7861

}
