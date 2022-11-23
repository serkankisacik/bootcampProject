package com.kodlamaio.bootcampproject.business.abstracts;


import com.kodlamaio.bootcampproject.business.requests.CreateUserRequest;
import com.kodlamaio.bootcampproject.business.responses.CreateUserResponse;
import com.kodlamaio.bootcampproject.business.responses.GetAllUserResponse;

import java.util.List;

public interface UserService {
    List<GetAllUserResponse> getAll();

    CreateUserResponse add(CreateUserRequest createUserRequest);
}
