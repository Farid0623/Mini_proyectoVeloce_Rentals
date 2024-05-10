package Service.impl;

import model.Status;
import model.TypeVehicle;
import model.Vehicle;
import repository.VehicleRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleJDBCImpl implements VehicleRepository<Vehicle> {
    private Connection conn;

    public VehicleJDBCImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Vehicle")) {
            while (resultSet.next()) {
                Vehicle vehicle = createVehicle(resultSet);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los vehicles", e);
        }
        return vehicles;
    }

    @Override
    public Vehicle byId(int id) {
        return null;
    }

    @Override
    public void save(Vehicle vehicle) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Vehicle vehicle) {

    }

    private Vehicle createVehicle(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(resultSet.getInt("plate"));
        vehicle.setTypeVehicle(TypeVehicle.valueOf(resultSet.getString("Type")));
        vehicle.setBrand(resultSet.getString("Brand"));
        vehicle.setModel(resultSet.getInt("Model"));
        vehicle.setPricePerDay(resultSet.getInt("Price"));
        vehicle.setStatus(Status.valueOf(resultSet.getString("Status")));

        return vehicle;
    }

}
