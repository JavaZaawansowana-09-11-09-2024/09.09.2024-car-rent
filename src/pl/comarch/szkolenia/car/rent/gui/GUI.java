package pl.comarch.szkolenia.car.rent.gui;

import pl.comarch.szkolenia.car.rent.model.Car;

import java.util.List;
import java.util.Scanner;

public class GUI {
    private final Scanner scanner = new Scanner(System.in);

    public String showMenu() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Exit");
        return this.scanner.nextLine();
    }

    public void listCars(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car);
        }
    }

    public void showWrongChoose() {
        System.out.println("Wrong choose !!");
    }

    public String getPlate() {
        System.out.println("Enter plate:");
        return this.scanner.nextLine();
    }

    public void showError() {
        System.out.println("Error !!");
    }

    public void showSuccess() {
        System.out.println("Success !!");
    }
}
