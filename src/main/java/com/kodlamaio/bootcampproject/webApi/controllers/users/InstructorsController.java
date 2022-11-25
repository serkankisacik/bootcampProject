package com.kodlamaio.bootcampproject.webApi.controllers.users;

import com.kodlamaio.bootcampproject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootcampproject.business.requests.users.CreateInstructorRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateInstructorRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateInstructorResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor

public class InstructorsController {

    private InstructorService instructorService;

    @GetMapping("/{id}")
    public DataResult<GetInstructorResponse> getById(@PathVariable int id){
        return this.instructorService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllInstructorResponse>> getAll(){
        return this.instructorService.getAll();
    }

    @PostMapping("/add")
    public DataResult<CreateInstructorResponse> add(@RequestBody CreateInstructorRequest createInstructorRequest){
        return this.instructorService.add(createInstructorRequest);
    }
    @PutMapping
    public DataResult<UpdateInstructorResponse> update(@RequestBody UpdateInstructorRequest updateInstructorRequest){
        return this.instructorService.update(updateInstructorRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.instructorService.delete(id);
    }

}
