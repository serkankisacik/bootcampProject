package com.kodlamaio.bootcampproject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String companyName;
    private LocalDate dateOfBirth;
    private String nationalId;
}
