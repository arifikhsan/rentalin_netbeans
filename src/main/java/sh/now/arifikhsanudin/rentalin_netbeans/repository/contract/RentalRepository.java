package sh.now.arifikhsanudin.rentalin_netbeans.repository.contract;

import sh.now.arifikhsanudin.rentalin_netbeans.model.Rental;

import java.util.ArrayList;

public interface RentalRepository {
    ArrayList<Rental> getRentals();

    Rental getOne(Integer id);

    void add(Rental rental);

    void update(Rental rental);

    void delete(Integer id);
}
