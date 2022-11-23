package com.kodlamaio.bootcampproject.business.concretes;

import com.kodlamaio.bootcampproject.business.abstracts.UserService;
import com.kodlamaio.bootcampproject.business.requests.CreateUserRequest;
import com.kodlamaio.bootcampproject.business.responses.CreateUserResponse;
import com.kodlamaio.bootcampproject.business.responses.GetAllUserResponse;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.dataAccess.UserRepository;
import com.kodlamaio.bootcampproject.entities.users.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<GetAllUserResponse> responses = new ArrayList<GetAllUserResponse>();
        List<User> users = this.userRepository.findAll();
        for (User user : users) {
            GetAllUserResponse getAllUserResponse = new GetAllUserResponse();
            getAllUserResponse.setId(user.getId());
            getAllUserResponse.setEmail(user.getEmail());
            getAllUserResponse.setFirstName(user.getFirstName());
            getAllUserResponse.setLastName(user.getLastName());
            getAllUserResponse.setPassword(user.getPassword().substring(0,2)+ "xxx" +user.getPassword().substring(3));
            responses.add(getAllUserResponse);
        }
        return responses;
    }

    @Override
    public CreateUserResponse add(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
        return this.modelMapperService.forResponse().map(user, CreateUserResponse.class);
    }
}
