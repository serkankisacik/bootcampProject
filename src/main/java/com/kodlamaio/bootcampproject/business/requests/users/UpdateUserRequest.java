package com.kodlamaio.bootcampproject.business.requests.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String nationalId;
}
