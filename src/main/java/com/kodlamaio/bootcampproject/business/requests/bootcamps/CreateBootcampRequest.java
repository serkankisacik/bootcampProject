package com.kodlamaio.bootcampproject.business.requests.bootcamps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int state;
    private int instructorId;
}
