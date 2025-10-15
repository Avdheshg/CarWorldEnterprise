package com.avdhesh.gautam.carworldenterprise.repositories;

import com.avdhesh.gautam.carworldenterprise.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
