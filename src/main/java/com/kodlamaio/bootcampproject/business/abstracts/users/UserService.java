package com.kodlamaio.bootcampproject.business.abstracts.users;


import com.kodlamaio.bootcampproject.business.requests.users.CreateUserRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateUserRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateUserResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface UserService {
    Result delete(int id);

    DataResult<CreateUserResponse> add(CreateUserRequest createUserRequest);

    DataResult<List<GetAllUserResponse>> getAll();

    DataResult<UpdateUserResponse> update(UpdateUserRequest updateUserRequest);

    DataResult<GetUserResponse> getById(int id);



}
