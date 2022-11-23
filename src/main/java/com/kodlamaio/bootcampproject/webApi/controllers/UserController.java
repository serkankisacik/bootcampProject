package com.kodlamaio.bootcampproject.webApi.controllers;

import com.kodlamaio.bootcampproject.business.abstracts.UserService;
import com.kodlamaio.bootcampproject.business.requests.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateUserRequest createUserRequest) {
        System.out.println(createUserRequest);
        userService.add(createUserRequest);
    }
}
