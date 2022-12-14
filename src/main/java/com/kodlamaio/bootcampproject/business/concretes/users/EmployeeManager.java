package com.kodlamaio.bootcampproject.business.concretes.users;

import com.kodlamaio.bootcampproject.business.abstracts.users.EmployeeService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.users.CreateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateEmployeeRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetEmployeeResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateEmployeeResponse;
import com.kodlamaio.bootcampproject.core.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.abstracts.users.EmployeeRepository;
import com.kodlamaio.bootcampproject.entities.users.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result delete(int id) {
        checkIfEmployeeExistById(id);
        this.employeeRepository.deleteById(id);
        return new SuccessResult(Messages.EmployeeDeleted);
    }

    @Override
    public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
        checkIfEmployeeExistByNationalId(createEmployeeRequest.getNationalId());
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
        this.employeeRepository.save(employee);
        CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee, CreateEmployeeResponse.class);
        return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse, Messages.EmployeeCreated);
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employees = this.employeeRepository.findAll();
        List<GetAllEmployeeResponse> response = employees.stream().map(employee -> this.modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllEmployeeResponse>>(response);
    }

    @Override
    public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
        this.employeeRepository.save(employee);
        UpdateEmployeeResponse response = this.modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<UpdateEmployeeResponse>(response, Messages.EmployeeUpdated);
    }

    @Override
    public DataResult<GetEmployeeResponse> getById(int id) {
        Employee employee = this.employeeRepository.findById(id);
        GetEmployeeResponse response = this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);
        return new SuccessDataResult<GetEmployeeResponse>(response);
    }

    private void checkIfEmployeeExistByNationalId(String nationalId) {
        Employee employeeCheck = this.employeeRepository.findEmployeeByNationalId(nationalId);
        if (employeeCheck != null) {
            throw new BusinessException(Messages.EmployeeAlreadyExists);
        }
    }

    private void checkIfEmployeeExistById(int id) {
        Employee employeeCheck = this.employeeRepository.findById(id);
        if (employeeCheck == null){
            throw new BusinessException(Messages.EmployeeNotFound);
        }
    }
}
