package sh.now.arifikhsanudin.rentalin_netbeans.repository;

import sh.now.arifikhsanudin.rentalin_netbeans.model.User;
import sh.now.arifikhsanudin.rentalin_netbeans.repository.contract.UserRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public UserRepositoryImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/netbeans_rentalin", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> list = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * from pengguna");
            while (resultSet.next()) {
                list.add(new User(resultSet.getInt("id"), resultSet.getString("nama"), resultSet.getString("alamat"), resultSet.getString("nomor_hp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public User getOne(Integer id) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM pengguna WHERE id = " + id);
            if (resultSet.next()) {
                System.out.println(resultSet.getString("nama"));
                return new User(resultSet.getInt("id"), resultSet.getString("nama"), resultSet.getString("alamat"), resultSet.getString("nomor_hp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void add(User user) {
        try {
            String query = String.format("INSERT INTO pengguna (`nama`, `alamat`, `nomor_hp`) " +
                    "VALUES ('%s', '%s', '%s')", user.getName(), user.getAddress(), user.getPhoneNumber());
            int a = statement.executeUpdate(query);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {
        try {
            String query = String.format("DELETE FROM pengguna WHERE id = %d", id);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
