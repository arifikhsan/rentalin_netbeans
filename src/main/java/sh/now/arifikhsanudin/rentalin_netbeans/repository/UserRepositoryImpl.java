package sh.now.arifikhsanudin.rentalin_netbeans.repository;

import sh.now.arifikhsanudin.rentalin_netbeans.model.User;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepositoryInterface {
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
}
