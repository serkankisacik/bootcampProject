package com.kodlamaio.bootcampproject.dataAccess.abstracts.users;

import com.kodlamaio.bootcampproject.entities.users.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    Instructor findInstructorByNationalId(String nationalId);
    Instructor findById(int id);
}
