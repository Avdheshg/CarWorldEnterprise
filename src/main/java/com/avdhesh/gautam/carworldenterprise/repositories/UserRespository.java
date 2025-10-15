package com.avdhesh.gautam.carworldenterprise.repositories;

import com.avdhesh.gautam.carworldenterprise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
}
