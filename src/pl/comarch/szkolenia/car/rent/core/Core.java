package pl.comarch.szkolenia.car.rent.core;

import pl.comarch.szkolenia.car.rent.db.CarRepository;
import pl.comarch.szkolenia.car.rent.exceptions.CarRentException;
import pl.comarch.szkolenia.car.rent.gui.GUI;

public class Core {
    private final GUI gui = new GUI();
    private final CarRepository carRepository = new CarRepository();
    public void start() {
        boolean run = true;
        while(run) {
            switch(gui.showMenu()) {
                case "1":
                    gui.listCars(this.carRepository.getCars());
                    break;
                case "2":
                    try {
                        this.carRepository.rent(gui.getPlate());
                        gui.showSuccess();
                    } catch (CarRentException e) {
                        gui.showError();
                    }
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    gui.showWrongChoose();
                    break;
            }
        }
    }
}
