package model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Vehicle{
    private int vehicleId;
    private TypeVehicle typeVehicle;
    private String brand;
    private int model;
    private int pricePerDay;
    private Status status;

}
