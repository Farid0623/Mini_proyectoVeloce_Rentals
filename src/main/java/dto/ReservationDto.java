package dto;

import lombok.Builder;

import java.text.DecimalFormat;
import java.time.LocalDate;
@Builder
public record ReservationDto(int ReservationId, int UserId, int VehicleId, LocalDate StartDate, LocalDate EndDate, double totalCost) {
}
