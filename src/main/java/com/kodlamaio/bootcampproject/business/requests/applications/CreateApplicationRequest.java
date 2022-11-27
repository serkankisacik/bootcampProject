package com.kodlamaio.bootcampproject.business.requests.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {
    private int state;
    private int applicantId;
    private int bootcampId;
}
