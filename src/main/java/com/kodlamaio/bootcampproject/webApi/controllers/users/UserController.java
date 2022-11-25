package com.kodlamaio.bootcampproject.webApi.controllers.users;

import com.kodlamaio.bootcampproject.business.abstracts.users.UserService;
import com.kodlamaio.bootcampproject.business.requests.users.CreateUserRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateUserRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetUserResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateUserResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public DataResult<GetUserResponse> getById(@PathVariable int id) {
        return this.userService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllUserResponse>> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public DataResult<CreateUserResponse> add(@RequestBody CreateUserRequest createUserRequest) {
        System.out.println(createUserRequest);
        return this.userService.add(createUserRequest);
    }

    @PutMapping
    public DataResult<UpdateUserResponse> update(@RequestBody UpdateUserRequest updateUserRequest) {
        return this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        return this.userService.delete(id);
    }
}
