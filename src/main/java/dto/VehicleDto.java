package dto;

import lombok.*;
import model.Status;
import model.TypeVehicle;

@Builder

public record VehicleDto(int vehicleId, TypeVehicle typeVehicle, String brand, int model, int pricePerDay, Status status){
}
