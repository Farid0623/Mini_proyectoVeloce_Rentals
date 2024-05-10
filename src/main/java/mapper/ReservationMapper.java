package mapper;

import dto.ReservationDto;
import dto.VehicleDto;
import model.Reservation;
import model.Vehicle;

public class ReservationMapper {
    public static ReservationDto mapFrom(Reservation reservation){
        return new ReservationDto(reservation.getReservationId(),reservation.getUserId(),reservation.getVehicleId(),reservation.getStartDate(),reservation.getEndDate(),reservation.getTotalCost());
    }
    public static Reservation mapFromDto(ReservationDto reservation){
        return Reservation.builder()
                .ReservationId(reservation.ReservationId())
                .UserId(reservation.UserId())
                .VehicleId(reservation.VehicleId())
                .StartDate(reservation.StartDate())
                .EndDate(reservation.EndDate())
                .totalCost(reservation.totalCost())
                .build();
    }
}
