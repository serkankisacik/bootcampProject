package com.kodlamaio.bootcampproject.business.responses.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationResponse {
    private int id;
    private int state;
    private int applicantId;
    private int bootcampId;

}
