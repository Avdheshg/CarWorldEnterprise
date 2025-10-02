package com.avdhesh.gautam.carworldenterprise.models;

import com.avdhesh.gautam.carworldenterprise.models.types.BookingStatus;
import com.avdhesh.gautam.carworldenterprise.models.types.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Booking
{
    private Long id;
    private Long userId;
    private Car car;
    private LocalDateTime createdAt;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;
    private BookingStatus bookingStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + userId +
                ", car=" + car +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                ", paymentStatus=" + paymentStatus +
                ", bookingStatus=" + bookingStatus +
                '}';
    }
}
