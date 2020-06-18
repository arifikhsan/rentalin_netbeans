package sh.now.arifikhsanudin.rentalin_netbeans.repository;

import sh.now.arifikhsanudin.rentalin_netbeans.model.Car;
import sh.now.arifikhsanudin.rentalin_netbeans.model.Rental;
import sh.now.arifikhsanudin.rentalin_netbeans.model.User;
import sh.now.arifikhsanudin.rentalin_netbeans.repository.contract.RentalRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class RentalRepositoryImpl implements RentalRepository {
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
                    "sewa.id AS id, pengguna.id AS id_pengguna, pengguna.nama AS nama_pengguna, " +
                    "mobil.id AS id_mobil, mobil.nama AS nama_mobil, sewa.tanggal_sewa, sewa.tanggal_kembali " +
                    "FROM sewa " +
                    "INNER JOIN mobil ON sewa.mobil_id = mobil.id " +
                    "INNER JOIN pengguna ON sewa.pengguna_id = pengguna.id");
            while (resultSet.next()) {
                list.add(new Rental(
                                resultSet.getInt("id"),
                                new Car(
                                        resultSet.getInt("id_mobil"),
                                        resultSet.getString("nama_mobil")
                                ),
                                new User(
                                        resultSet.getInt("id_pengguna"),
                                        resultSet.getString("nama_pengguna")
                                ),
                                resultSet.getString("tanggal_sewa"), resultSet.getString("tanggal_kembali")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Rental getOne(Integer id) {
        try {
            resultSet = statement.executeQuery("SELECT " +
                    "sewa.id AS id, pengguna.id AS id_pengguna, pengguna.nama AS nama_pengguna, " +
                    "mobil.id AS id_mobil, mobil.nama AS nama_mobil, sewa.tanggal_sewa, sewa.tanggal_kembali " +
                    "FROM sewa " +
                    "INNER JOIN mobil ON sewa.mobil_id = mobil.id " +
                    "INNER JOIN pengguna ON sewa.pengguna_id = pengguna.id " +
                    "WHERE sewa.id = " + id);
            if (resultSet.next()) {
                return new Rental(
                        resultSet.getInt("id"),
                        new Car(
                                resultSet.getInt("id_mobil"),
                                resultSet.getString("nama_mobil")
                        ),
                        new User(
                                resultSet.getInt("id_pengguna"),
                                resultSet.getString("nama_pengguna")
                        ),
                        resultSet.getString("tanggal_sewa"),
                        resultSet.getString("tanggal_kembali")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void add(Rental rental) {
        try {
            String query = String.format("INSERT INTO `sewa` (`pengguna_id`, `mobil_id`, `tanggal_sewa`, `tanggal_kembali`) " +
                    "VALUES (%d, %d, '%s', '%s')", rental.user.getId(), rental.car.getId(), rental.getDateBorrow(), rental.getDateReturn());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Rental rental) {
        try {
            String query = String.format("UPDATE sewa SET " +
                    "`pengguna_id` = %d, `mobil_id` = %d, `tanggal_sewa` = '%s', `tanggal_kembali` = '%s' " +
                    "WHERE id = %d", rental.user.getId(), rental.car.getId(), rental.getDateBorrow(), rental.getDateReturn(), rental.getId());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String query = String.format("DELETE FROM sewa WHERE id = %d", id);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
