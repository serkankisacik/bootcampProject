package com.kodlamaio.bootcampproject.dataAccess.abstracts.applications;

import com.kodlamaio.bootcampproject.entities.aplications.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Application findById(int id);
}
