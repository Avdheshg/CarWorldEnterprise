package com.avdhesh.gautam.carworldenterprise.service;

import com.avdhesh.gautam.carworldenterprise.models.Car;
import com.avdhesh.gautam.carworldenterprise.repositories.UsedCarRepository;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsedCarServiceImpl implements CarService
{
    @Autowired
    private UsedCarRepository usedCarRepository;

    @Override
    public String addCars(List<Car> allCars)
    {
        usedCarRepository.saveAll(allCars);

        return "Used Cars added successfully!";
    }

    @Override
    public List<Car> getAllCars()
    {
        return usedCarRepository.findAll();
    }

    @Override
    public Car getCarById(Long usedCarId)
    {
        Optional<Car> foundCar = usedCarRepository.findById(usedCarId);

        return foundCar
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found with the id " + usedCarId));
    }

    @Override
    public String updateCarById(Car car, Long usedCarId)
    {
        Car foundCar = getCarById(usedCarId);

        foundCar.setName(car.getName());
        usedCarRepository.save(foundCar);

        return "Car updated with the Id " + usedCarId;
    }

    @Override
    public String deleteCarById(Long usedCarId)
    {
        usedCarRepository.deleteById(usedCarId);

        return "Car deleted successfully with the Id: " + usedCarId;
    }
}
