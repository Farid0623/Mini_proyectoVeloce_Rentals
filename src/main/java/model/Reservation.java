package model;

import lombok.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Reservation {
    private int ReservationId;
    private int UserId;
    private int VehicleId;
    private LocalDate StartDate;
    private LocalDate EndDate;
    private double totalCost;
}
