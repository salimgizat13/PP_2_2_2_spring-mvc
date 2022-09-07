package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1, "USA", "Ford"));
        cars.add(new Car(2, "France", "Reno"));
        cars.add(new Car(3, "Germany", "Mercedes"));
        cars.add(new Car(4, "Japan", "Toyota"));
        cars.add(new Car(5, "Germany", "Opel"));
    }

    @Override
    public List<Car> getSomeCars (int count) {     // вот так???
        List<Car> carList = new ArrayList<>();
        if (count >= 5) {
            count = 5;
        }
        for (int i = 0; i < count; i++) {
            carList.add(cars.get(i));
        }
        return carList;
    }

}
