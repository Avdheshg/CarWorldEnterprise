package com.avdhesh.gautam.carworldenterprise.service.interfaces;

import com.avdhesh.gautam.carworldenterprise.models.Car;

import java.util.List;

public interface CarService
{
    String addCars(List<Car> cars);
    List<Car> getAllCars();
    Car getCarById(Long newCarId);
    String updateCarById(Car car, Long newCarId);
    String deleteCarById(Long newCarId);
}
