package com.kodlamaio.bootcampproject.business.requests.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String companyName;
    private LocalDate dateOfBirth;
    private String nationalId;
}
