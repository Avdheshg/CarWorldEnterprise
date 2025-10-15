package com.avdhesh.gautam.carworldenterprise.repositories;

import com.avdhesh.gautam.carworldenterprise.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedCarRepository extends JpaRepository<Car, Long> {
}
