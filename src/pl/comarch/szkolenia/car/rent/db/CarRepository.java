package pl.comarch.szkolenia.car.rent.db;

import pl.comarch.szkolenia.car.rent.exceptions.CarRentException;
import pl.comarch.szkolenia.car.rent.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public CarRepository() {
        this.cars.add(new Car("BMW", "3", 2020, false, "KR11"));
        this.cars.add(new Car("Audi", "A5", 2022, false, "KR22"));
        this.cars.add(new Car("Toyota", "Corolla", 2020, false, "KR33"));
        this.cars.add(new Car("Kia", "Ceed", 2021, false, "KR44"));
    }

    public void rent(final String plate) {
        this.cars.stream()
                .filter(c -> c.getPlate().equals(plate))
                .filter(c -> !c.isRent())
                .findFirst()
                .orElseThrow(CarRentException::new)
                .setRent(true);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
