package com.kodlamaio.bootcampproject.dataAccess;

import com.kodlamaio.bootcampproject.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
