package com.kodlamaio.bootcampproject.business.requests.users;

import com.kodlamaio.bootcampproject.business.constants.MessagesValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {
    @NotBlank(message = "Ad boş olamaz")
    @Min(value = 3, message = MessagesValidation.NameTooShort)
    private String firstName;

    private String lastName;

    @Email(regexp = ".+[@].+[\\.].+", message = "Email must be valid")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", message = MessagesValidation.PasswordMessage)
    private String password;

    private String about;
    private LocalDate dateOfBirth;

    @NotNull(message = MessagesValidation.NationalIdNotNull)
    @Max(value = 11, message = MessagesValidation.NationalIdTooLong)
    @Min(value = 11, message = MessagesValidation.NationalIdTooShort)
    private String nationalId;
}
