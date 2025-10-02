package com.avdhesh.gautam.carworldenterprise.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.avdhesh.gautam.carworldenterprise.models.Car;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.CarService;

@Service
public class NewCarServiceImpl implements CarService
{
    private List<Car> cars = new ArrayList<>();
    private Long carId = 1L;

    private Long getCarId() { return carId++; }

    @Override
    public String addCars(List<Car> allCars)
    {
        for (Car car : allCars)
        {
            car.setId(getCarId());
            cars.add(car);
        }

        return "New Cars added successfully!";
    }

    @Override
    public List<Car> getAllCars()
    {
        return cars;
    }

    @Override
    public Car getCarById(Long newCardId)
    {
        return cars.stream()
                .filter(car -> car.getId().equals(newCardId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found with the id " + newCardId));
    }

    @Override
    public String updateCarById(Car car, Long newCarId)
    {
        Car foundCar = getCarById(newCarId);

        // validations to check what to update
        foundCar.setName(car.getName());

        return "Car updated with the Id " + newCarId;
    }

    @Override
    public String deleteCarById(Long newCarId)
    {
        Car foundCar = getCarById(newCarId);

        cars.remove(foundCar);

        return "Car deleted successfully with the Id: " + newCarId;
    }

}
