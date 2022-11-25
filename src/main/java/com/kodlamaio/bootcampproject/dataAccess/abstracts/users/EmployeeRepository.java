package com.kodlamaio.bootcampproject.dataAccess.abstracts.users;

import com.kodlamaio.bootcampproject.entities.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByNationalId(String nationalId);
    Employee findById(int id);
}
