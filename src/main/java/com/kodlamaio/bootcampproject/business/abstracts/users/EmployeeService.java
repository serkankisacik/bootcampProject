package com.kodlamaio.bootcampproject.business.abstracts.users;

import com.kodlamaio.bootcampproject.business.requests.CreateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.requests.UpdateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.responses.CreateEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.GetAllEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.GetEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.UpdateEmployeeResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface EmployeeService {

    Result delete(int id);
    DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);
    DataResult<List<GetAllEmployeeResponse>> getAll();
    DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
    DataResult<GetEmployeeResponse> getById(int id);
}
