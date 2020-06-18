package sh.now.arifikhsanudin.rentalin_netbeans.repository.contract;

import sh.now.arifikhsanudin.rentalin_netbeans.model.Car;

import java.util.ArrayList;

public interface CarRepository {
    ArrayList<Car> getCars();

    Car getOne(Integer id);

    void add(Car car);

    void update(Car car);

    void delete(Integer id);
}
