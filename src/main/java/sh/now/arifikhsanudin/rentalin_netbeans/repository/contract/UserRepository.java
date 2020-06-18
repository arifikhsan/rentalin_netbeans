package sh.now.arifikhsanudin.rentalin_netbeans.repository.contract;

import sh.now.arifikhsanudin.rentalin_netbeans.model.User;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> getUsers();

    User getOne(Integer id);

    void add(User user);

    void update(User user);

    void delete(Integer id);
}
