package com.avdhesh.gautam.carworldenterprise.models;

import com.avdhesh.gautam.carworldenterprise.models.types.BookingStatus;
import com.avdhesh.gautam.carworldenterprise.models.types.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Booking
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long carId;
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

    public Long getCar() {
        return carId;
    }

    public void setCar(Car car) {
        this.carId = carId;
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
                ", carId=" + carId +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                ", paymentStatus=" + paymentStatus +
                ", bookingStatus=" + bookingStatus +
                '}';
    }
}
