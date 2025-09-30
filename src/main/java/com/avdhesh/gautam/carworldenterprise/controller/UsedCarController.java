package com.avdhesh.gautam.carworldenterprise.controller;

import com.avdhesh.gautam.carworldenterprise.models.Car;
import com.avdhesh.gautam.carworldenterprise.service.UsedCarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsedCarController
{
    @Autowired
    private UsedCarServiceImpl usedCarService;

    @PostMapping("/admin/usedCars")
    public ResponseEntity<String> addCars(@RequestBody List<Car> cars)
    {
        return new ResponseEntity<>(usedCarService.addCars(cars), HttpStatus.CREATED);
    }

    @GetMapping("/public/usedCars")
    public ResponseEntity<List<Car>> getAllCars()
    {
        return new ResponseEntity<>(usedCarService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/public/usedCars/{usedCarId}")
    public ResponseEntity<String> getCarById(@PathVariable Long usedCarId)
    {
        try
        {
            return new ResponseEntity<>(usedCarService.getCarById(usedCarId).toString(), HttpStatus.OK);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

    @PatchMapping("/admin/usedCars/{usedCarId}")
    public ResponseEntity<String> updateCar(@RequestBody Car car, @PathVariable Long usedCarId)
    {
        try
        {
            return new ResponseEntity<>(usedCarService.updateCar(car, usedCarId), HttpStatus.OK);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

    @DeleteMapping("/admin/usedCars/{usedCarId}")
    public ResponseEntity<String> deleteCar(@PathVariable Long usedCarId)
    {
        try
        {
            return new ResponseEntity<>(usedCarService.deleteCar(usedCarId), HttpStatus.NO_CONTENT);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }
}
