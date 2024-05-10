package dto;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record UsersDto(int UserId, String username, String password, String email, String FullName, LocalDate createdAt, LocalDate LastLogin) {
}
