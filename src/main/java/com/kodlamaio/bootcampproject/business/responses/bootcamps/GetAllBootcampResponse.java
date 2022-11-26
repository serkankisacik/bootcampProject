package com.kodlamaio.bootcampproject.business.responses.bootcamps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBootcampResponse {
    private int id;
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int state;
    private int instructorId;
}
