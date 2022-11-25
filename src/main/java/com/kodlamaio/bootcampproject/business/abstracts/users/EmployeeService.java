package com.kodlamaio.bootcampproject.business.abstracts.users;

import com.kodlamaio.bootcampproject.business.requests.users.CreateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateEmployeeResponse;
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
