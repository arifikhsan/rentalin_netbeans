package sh.now.arifikhsanudin.rentalin_netbeans.repository;

import sh.now.arifikhsanudin.rentalin_netbeans.model.Car;
import sh.now.arifikhsanudin.rentalin_netbeans.model.Rental;
import sh.now.arifikhsanudin.rentalin_netbeans.model.User;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class RentalRepositoryImpl implements RentalRepositoryInterface {
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public RentalRepositoryImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/netbeans_rentalin", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public ArrayList<Rental> getRentals() {
        ArrayList<Rental> list = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT " +
                    "sewa.id AS id, pengguna.nama AS nama_pengguna, " +
                    "mobil.nama AS nama_mobil, sewa.tanggal_sewa, sewa.tanggal_kembali " +
                    "FROM sewa " +
                    "INNER JOIN mobil ON sewa.mobil_id = mobil.id " +
                    "INNER JOIN pengguna ON sewa.pengguna_id = pengguna.id");
            while (resultSet.next()) {
                list.add(new Rental(resultSet.getInt("id"), resultSet.getString("nama_mobil"), resultSet.getString("nama_pengguna"), resultSet.getString("tanggal_sewa"), resultSet.getString("tanggal_kembali")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
}
