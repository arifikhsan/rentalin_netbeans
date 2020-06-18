package sh.now.arifikhsanudin.rentalin_netbeans.repository;

import sh.now.arifikhsanudin.rentalin_netbeans.model.Car;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CarRepositoryImpl implements CarRepositoryInterface {
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
}
