package dev.alex.valentey.dao;

import dev.alex.valentey.entity.Car;
import dev.alex.valentey.entity.Passport;

import java.util.List;

/**
 * This is CarDao interface for working with Car entities.
 */
public interface CarDao {
    List<Car> readAllCars();
    Car readCarById(long carId);
    void createNewCar(Car car);
    void updateCar(Car updatedCar);
    void deleteCAeById(long deletedId);
}
