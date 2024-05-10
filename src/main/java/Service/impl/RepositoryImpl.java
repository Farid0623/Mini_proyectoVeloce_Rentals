package Service.impl;

import Service.VehicleService;
import model.Status;
import model.TypeVehicle;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class RepositoryImpl implements VehicleService<Vehicle> {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public RepositoryImpl() {
        vehicles.add(new Vehicle(986, TypeVehicle.Van, "Mazda", 2023, 100000, Status.Available));
        vehicles.add(new Vehicle(871, TypeVehicle.Suv, "Kia", 2024, 50000, Status.Rented));
        vehicles.add(new Vehicle(442, TypeVehicle.Sedan, "Chevrolet", 2023, 70000, Status.Maintenance));
        vehicles.add(new Vehicle(21, TypeVehicle.Motorcycle, "Yamaha", 2024, 50000, Status.Rented));
        vehicles.add(new Vehicle(13, TypeVehicle.Motorcycle, "Yamaha", 2023, 47000, Status.Rented));
    }

    @Override
    public List<Vehicle> list() {
        return vehicles;
    }


    public Optional<Vehicle> byId(int id) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getVehicleId() == id)
                .findFirst();
    }
}
