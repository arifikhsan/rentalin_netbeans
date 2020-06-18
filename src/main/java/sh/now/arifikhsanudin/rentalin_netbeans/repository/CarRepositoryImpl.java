package sh.now.arifikhsanudin.rentalin_netbeans.repository;

import sh.now.arifikhsanudin.rentalin_netbeans.model.Car;
import sh.now.arifikhsanudin.rentalin_netbeans.repository.contract.CarRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CarRepositoryImpl implements CarRepository {
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public CarRepositoryImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/netbeans_rentalin", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public ArrayList<Car> getCars() {
        ArrayList<Car> list = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * from mobil");
            while (resultSet.next()) {
                list.add(new Car(resultSet.getInt("id"), resultSet.getString("nama"), resultSet.getString("nomor_polisi"), resultSet.getInt("harga_per_jam")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Car getOne(Integer id) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM mobil WHERE id = " + id);
            if (resultSet.next()) {
                return new Car(resultSet.getInt("id"), resultSet.getString("nama"), resultSet.getString("nomor_polisi"), resultSet.getInt("harga_per_jam"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void add(Car car) {
        try {
            String query = String.format("INSERT INTO mobil (`nama`, `nomor_polisi`, `harga_per_jam`) " +
                    "VALUES ('%s', '%s', %d)", car.getName(), car.getPoliceNumber(), car.getPricePerHour());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Car car) {
        try {
            String query = String.format("UPDATE `mobil` SET " +
                    "`nama` = '%s', `nomor_polisi` = '%s', `harga_per_jam` = '%d' " +
                    "WHERE id = %d", car.getName(), car.getPoliceNumber(), car.getPricePerHour(), car.getId());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String query = String.format("DELETE FROM mobil WHERE id = %d", id);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
