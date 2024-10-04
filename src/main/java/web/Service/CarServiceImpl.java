package web.Service;

import org.springframework.stereotype.Component;
import web.Model.Car;
import java.util.ArrayList;
import java.util.List;
@Component
public class CarServiceImpl implements CarService{
    private static int CAR_COUNT = 0;
    private List<Car> car;
    {
        car = new ArrayList<>();
        car.add(new Car(++CAR_COUNT,"AUDI",2010));
        car.add(new Car(++CAR_COUNT,"BMW",2020));
        car.add(new Car(++CAR_COUNT,"MERCEDES",2001));
        car.add(new Car(++CAR_COUNT,"LADA",1999));
        car.add(new Car(++CAR_COUNT,"TOYOTA",2000));
    }

    public List<Car> getCar(Integer count) {
        return count > 0 ? car.subList(0,Math.min(count, car.size())) : car;
    }

}

