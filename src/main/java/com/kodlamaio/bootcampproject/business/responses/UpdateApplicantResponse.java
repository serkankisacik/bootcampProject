package com.kodlamaio.bootcampproject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String about;
}
