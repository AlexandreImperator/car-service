package com.example.devsecops;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarService {
    private final List<Car> cars = List.of(
        new Car("ABC123", "Toyota", 100),
        new Car("DEF456", "Ford", 150),
        new Car("GHI789", "Chevrolet", 200)
    );

    // GET
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return cars;
    }

    // GET
    @GetMapping(value = "/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) {
        return cars.stream()
                   .filter(car -> car.getPlateNumber().equals(plateNumber))
                   .findFirst()
                   .orElseThrow();     
    }

    // PUT
    @PutMapping(value = "/car/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrGetBack(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent", required = true) boolean rent) {
        Car car = aCar(plateNumber);
        if (rent) {
            car.setRented(true);
        } else {
            car.setRented(false);
            car.setDates(null);
        }
    }

    // PUT
    @PutMapping(value = "/cars/{plateNumber}")
    public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent", required = true) boolean rent, @RequestBody Dates dates) {
        Car car = aCar(plateNumber);
        if (rent) {
            car.setRented(true);
            car.setDates(dates);
        } else {
            car.setRented(false);
            car.setDates(null);
        }
    }
}
