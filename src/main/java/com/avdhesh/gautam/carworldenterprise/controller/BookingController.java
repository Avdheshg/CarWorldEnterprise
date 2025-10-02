package com.avdhesh.gautam.carworldenterprise.controller;

import com.avdhesh.gautam.carworldenterprise.models.Booking;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BookingController
{
    @Autowired
    private BookingService bookingService;

    @PostMapping("/public/bookings")
    public ResponseEntity<String> createBookings(@RequestBody List<Booking> bookings)
    {
        return new ResponseEntity<>(bookingService.createBookings(bookings), HttpStatus.CREATED);
    }

    @GetMapping("/admin/bookings")
    public ResponseEntity<List<Booking>> getAllBookings()
    {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("/public/bookings/{bookingId}")
    public ResponseEntity<String> getBookingById(@PathVariable Long bookingId)
    {
        try
        {
            return new ResponseEntity<>(bookingService.getBookingById(bookingId).toString(), HttpStatus.OK);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

    @PatchMapping("/public/bookings/{bookingId}")
    public ResponseEntity<String> updateBookingById(@RequestBody Booking booking, @PathVariable Long bookingId)
    {
        try
        {
            return new ResponseEntity<>(bookingService.updateBookingById(booking, bookingId), HttpStatus.OK);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

    @DeleteMapping("/admin/bookings/{bookingId}")
    public ResponseEntity<String> deleteBookingById(@PathVariable Long bookingId)
    {
        try
        {
            return new ResponseEntity<>(bookingService.deleteBookingById(bookingId), HttpStatus.NO_CONTENT);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }
}
