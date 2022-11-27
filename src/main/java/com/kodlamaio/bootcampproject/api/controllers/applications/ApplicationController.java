package com.kodlamaio.bootcampproject.api.controllers.applications;

import com.kodlamaio.bootcampproject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampproject.business.requests.applications.CreateApplicationRequest;
import com.kodlamaio.bootcampproject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampproject.business.responses.applications.CreateApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController {
    private ApplicationService applicationService;

    @GetMapping("/{id}")
    public DataResult<GetApplicationResponse> getById(@PathVariable int id){
        return this.applicationService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllApplicationResponse>> getAll(){
        return this.applicationService.getAll();
    }

    @PostMapping("/add")
    public DataResult<CreateApplicationResponse> add(@RequestBody CreateApplicationRequest createApplicationRequest){
        return this.applicationService.add(createApplicationRequest);
    }

    @PutMapping
    public DataResult<UpdateApplicationResponse> update(@RequestBody UpdateApplicationRequest updateApplicationRequest){
        return this.applicationService.update(updateApplicationRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.applicationService.delete(id);
    }
}
