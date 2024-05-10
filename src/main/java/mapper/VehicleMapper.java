package mapper;

import dto.VehicleDto;
import model.Vehicle;

public class VehicleMapper {
    public static VehicleDto mapFromModel(Vehicle vehicle){
        return new VehicleDto(vehicle.getVehicleId(), vehicle.getTypeVehicle(), vehicle.getBrand(), vehicle.getModel(), vehicle.getPricePerDay(), vehicle.getStatus());
    }

    public static Vehicle mapFromDto(VehicleDto vehicle){
        return Vehicle.builder()
                .vehicleId(vehicle.vehicleId())
                .typeVehicle(vehicle.typeVehicle())
                .brand(vehicle.brand())
                .model(vehicle.model())
                .pricePerDay(vehicle.pricePerDay())
                .status(vehicle.status())
                .build();
    }


}
