package race.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import race.view.ResultView;
import utils.number.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(int countOfCar) {
        cars = generateCar(countOfCar);
    }

    public static Cars createInstance(int countOfCar) {
        return new Cars(countOfCar);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getSize() {
        return cars.size();
    }

    public void moveCars(NumberGenerator generator) {
        for (Car car : cars) {
            car.move(generator.generate());
        }
    }

    private List<Car> generateCar(int countOfCar) {
        List<Car> cars = new ArrayList<>();

        while(countOfCar > 0) {
            cars.add(Car.createInstance());
            countOfCar--;
        }

        return cars;
    }
}
