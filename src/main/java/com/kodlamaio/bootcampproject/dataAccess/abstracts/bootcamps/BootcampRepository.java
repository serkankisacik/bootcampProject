package com.kodlamaio.bootcampproject.dataAccess.abstracts.bootcamps;

import com.kodlamaio.bootcampproject.entities.bootcamps.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {
    Bootcamp findById(int id);
}
