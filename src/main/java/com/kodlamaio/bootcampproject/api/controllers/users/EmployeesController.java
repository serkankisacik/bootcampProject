package com.kodlamaio.bootcampproject.api.controllers.users;

import com.kodlamaio.bootcampproject.business.abstracts.users.EmployeeService;
import com.kodlamaio.bootcampproject.business.requests.users.CreateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateEmployeeResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public DataResult<GetEmployeeResponse> getById(@PathVariable int id){
        return this.employeeService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllEmployeeResponse>> getAll(){
        return this.employeeService.getAll();
    }

    @PostMapping("/add")
    public DataResult<CreateEmployeeResponse> add(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        return this.employeeService.add(createEmployeeRequest);
    }
    @PutMapping
    public DataResult<UpdateEmployeeResponse> update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        return this.employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.employeeService.delete(id);
    }
}
