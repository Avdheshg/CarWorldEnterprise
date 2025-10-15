package com.avdhesh.gautam.carworldenterprise.service;

import com.avdhesh.gautam.carworldenterprise.repositories.NewCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.avdhesh.gautam.carworldenterprise.models.Car;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.CarService;

@Service
public class NewCarServiceImpl implements CarService
{
    @Autowired
    private NewCarRepository newCarRepository;

    @Override
    public String addCars(List<Car> allCars)
    {
        newCarRepository.saveAll(allCars);

        return "New Cars added successfully!";
    }

    @Override
    public List<Car> getAllCars()
    {
        return newCarRepository.findAll();
    }

    @Override
    public Car getCarById(Long newCardId)
    {
        Optional<Car> foundCar = newCarRepository.findById(newCardId);

        return foundCar
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found with the id " + newCardId));

    }

    @Override
    public String updateCarById(Car car, Long newCarId)
    {
        Car foundCar = getCarById(newCarId);

        foundCar.setName(car.getName());
        newCarRepository.save(foundCar);

        return "Car updated with the Id " + newCarId;
    }

    @Override
    public String deleteCarById(Long newCarId)
    {
        newCarRepository.deleteById(newCarId);

        return "Car deleted successfully with the Id: " + newCarId;
    }

}
