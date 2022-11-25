package com.kodlamaio.bootcampproject.business.requests.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {
    @NotBlank(message = "Ad boş olamaz")
    private String firstName;

    private String lastName;
    private String email;
    private String password;
    private String about;
    private LocalDate dateOfBirth;
    private String nationalId;
}
