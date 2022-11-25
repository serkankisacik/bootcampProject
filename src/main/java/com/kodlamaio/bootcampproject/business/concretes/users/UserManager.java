package com.kodlamaio.bootcampproject.business.concretes.users;

import com.kodlamaio.bootcampproject.business.abstracts.users.UserService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.users.CreateUserRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateUserRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateUserResponse;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.abstracts.users.UserRepository;
import com.kodlamaio.bootcampproject.entities.users.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result delete(int id) {
        this.userRepository.deleteById(id);
        return new SuccessResult(Messages.UserDeleted);
    }

    @Override
    public DataResult<CreateUserResponse> add(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest,User.class);
        this.userRepository.save(user);
        CreateUserResponse createUserResponse = this.modelMapperService.forResponse().map(user,CreateUserResponse.class);
        return new SuccessDataResult<CreateUserResponse>(createUserResponse, Messages.UserCreated);
    }

    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List<User> users = this.userRepository.findAll();
        List<GetAllUserResponse> response = users.stream().map(user -> this.modelMapperService.forResponse().map(user,GetAllUserResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllUserResponse>>(response);
    }

    @Override
    public DataResult<UpdateUserResponse> update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest,User.class);
        this.userRepository.save(user);
        UpdateUserResponse response = this.modelMapperService.forResponse().map(user,UpdateUserResponse.class);
        return new SuccessDataResult<UpdateUserResponse>(response,Messages.UserUpdated);
    }

    @Override
    public DataResult<GetUserResponse> getById(int id) {
        User user = this.userRepository.findById(id).get();
        GetUserResponse response = this.modelMapperService.forResponse().map(user, GetUserResponse.class);
        return new SuccessDataResult<>(response);
    }


}
