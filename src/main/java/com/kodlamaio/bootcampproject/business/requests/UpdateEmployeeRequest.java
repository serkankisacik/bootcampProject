package com.kodlamaio.bootcampproject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String position;
    private LocalDate dateOfBirth;
    private String nationalId;
}
