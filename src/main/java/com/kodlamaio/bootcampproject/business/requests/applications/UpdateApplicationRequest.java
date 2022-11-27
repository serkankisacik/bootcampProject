package com.kodlamaio.bootcampproject.business.requests.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequest {
    private int id;
    private int state;
    private int applicantId;
    private int bootcampId;
}
