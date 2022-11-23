package com.kodlamaio.bootcampproject.webApi.controllers.users;

import com.kodlamaio.bootcampproject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampproject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampproject.business.requests.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.UpdateApplicantResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<CreateApplicantResponse> add(@RequestBody CreateApplicantRequest createApplicantRequest){
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
