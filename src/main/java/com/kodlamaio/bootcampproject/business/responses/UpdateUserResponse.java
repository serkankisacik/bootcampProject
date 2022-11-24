package com.kodlamaio.bootcampproject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String nationalId;
}
