package com.avdhesh.gautam.carworldenterprise.controller;

import com.avdhesh.gautam.carworldenterprise.models.Car;
import com.avdhesh.gautam.carworldenterprise.service.NewCarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NewCarController
{
    @Autowired
    private NewCarServiceImpl newCarService;

    @PostMapping("/admin/newCars")
    public ResponseEntity<String> addCars(@RequestBody List<Car> cars)
    {
        return new ResponseEntity<>(newCarService.addCars(cars), HttpStatus.CREATED);
    }

    @GetMapping("/public/newCars")
    public ResponseEntity<List<Car>> getAllCars()
    {
        return new ResponseEntity<>(newCarService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/public/newCars/{newCarId}")
    public ResponseEntity<String> getCarById(@PathVariable Long newCarId)
    {
        try
        {
            return new ResponseEntity<>(newCarService.getCarById(newCarId).toString(), HttpStatus.OK);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

    @PatchMapping("/admin/newCars/{newCarId}")
    public ResponseEntity<String> updateCar(@RequestBody Car car, @PathVariable Long newCarId)
    {
        try
        {
            return new ResponseEntity<>(newCarService.updateCar(car, newCarId), HttpStatus.OK);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

    @DeleteMapping("/admin/newCars/{newCarId}")
    public ResponseEntity<String> deleteCar(@PathVariable Long newCarId)
    {
        try
        {
            return new ResponseEntity<>(newCarService.deleteCar(newCarId), HttpStatus.NO_CONTENT);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

}
