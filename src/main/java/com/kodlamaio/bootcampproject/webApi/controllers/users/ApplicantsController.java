package com.kodlamaio.bootcampproject.webApi.controllers.users;

import com.kodlamaio.bootcampproject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampproject.business.requests.users.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateApplicantResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantsController {
    private ApplicantService applicantService;

    @GetMapping("/{id}")
    public DataResult<GetApplicantResponse> getById(@PathVariable int id){
        return this.applicantService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllApplicantResponse>> getAll(){
        return this.applicantService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public DataResult<CreateApplicantResponse> add(@Valid @RequestBody CreateApplicantRequest createApplicantRequest){
        return this.applicantService.add(createApplicantRequest);
    }
    @PutMapping
    public DataResult<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest updateApplicantRequest){
        return this.applicantService.update(updateApplicantRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.applicantService.delete(id);
    }
}
