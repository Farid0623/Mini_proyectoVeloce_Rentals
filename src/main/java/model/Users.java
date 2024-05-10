package model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Users {
    private int UserId ;
    private String username;
    private String password;;
    private String email;
    private String Fullname;
    private LocalDate CreatedAt;
    private  LocalDate Lastlogin;

}