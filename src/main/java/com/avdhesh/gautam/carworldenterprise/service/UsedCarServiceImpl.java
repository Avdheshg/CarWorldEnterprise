package com.avdhesh.gautam.carworldenterprise.service;

import com.avdhesh.gautam.carworldenterprise.models.Car;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsedCarServiceImpl implements CarService
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

        return "Used Cars added successfully!";
    }

    @Override
    public List<Car> getAllCars()
    {
        return cars;
    }

    @Override
    public Car getCarById(Long usedCarId)
    {
        return cars.stream()
                .filter(car -> car.getId().equals(usedCarId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found with the id " + usedCarId));
    }

    @Override
    public String updateCarById(Car car, Long usedCarId)
    {
        Car foundCar = getCarById(usedCarId);

        // validations to check what to update
        foundCar.setName(car.getName());

        return "Car updated with the Id " + usedCarId;
    }

    @Override
    public String deleteCarById(Long usedCarId)
    {
        Car foundCar = getCarById(usedCarId);

        cars.remove(foundCar);

        return "Car deleted successfully with the Id: " + usedCarId;
    }
}
