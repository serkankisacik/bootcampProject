package com.kodlamaio.bootcampproject.business.abstracts.users;


import com.kodlamaio.bootcampproject.business.requests.CreateUserRequest;
import com.kodlamaio.bootcampproject.business.requests.UpdateUserRequest;
import com.kodlamaio.bootcampproject.business.responses.CreateUserResponse;
import com.kodlamaio.bootcampproject.business.responses.GetAllUserResponse;
import com.kodlamaio.bootcampproject.business.responses.GetUserResponse;
import com.kodlamaio.bootcampproject.business.responses.UpdateUserResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;

import javax.xml.crypto.Data;
import java.util.List;

public interface UserService {
    Result delete(int id);

    DataResult<CreateUserResponse> add(CreateUserRequest createUserRequest);

    DataResult<List<GetAllUserResponse>> getAll();

    DataResult<UpdateUserResponse> update(UpdateUserRequest updateUserRequest);

    DataResult<GetUserResponse> getById(int id);



}
