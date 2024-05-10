package mapper;

import dto.ReservationDto;
import dto.UsersDto;
import dto.VehicleDto;
import model.Reservation;
import model.Users;
import model.Vehicle;

import java.time.LocalDate;

public class UsersMapper {
    public static UsersDto mapFrom(Users Users) {
        return new UsersDto(Users.getUserId(), Users.getUsername(), Users.getPassword(), Users.getEmail(), Users.getFullname(), Users.getCreatedAt(), Users.getLastlogin());
    }

    public static Users mapFromDto(UsersDto Users) {
        return model.Users.builder()
                .UserId(Users.UserId())
                .username(Users.username())
                .password(Users.password())
                .email(Users.email())
                .Fullname(Users.FullName())
                .CreatedAt(Users.createdAt())
                .Lastlogin(Users.LastLogin())
                .build();
    }
}