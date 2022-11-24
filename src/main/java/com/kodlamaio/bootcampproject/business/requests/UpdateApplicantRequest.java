package com.kodlamaio.bootcampproject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String about;
    private LocalDate dateOfBirth;
    private String nationalId;
}
