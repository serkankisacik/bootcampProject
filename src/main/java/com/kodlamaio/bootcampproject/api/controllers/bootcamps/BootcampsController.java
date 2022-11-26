package com.kodlamaio.bootcampproject.api.controllers.bootcamps;

import com.kodlamaio.bootcampproject.business.abstracts.bootcamps.BootcampService;
import com.kodlamaio.bootcampproject.business.requests.bootcamps.CreateBootcampRequest;
import com.kodlamaio.bootcampproject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampproject.business.responses.bootcamps.CreateBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetInstructorResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampsController {
    private BootcampService bootcampService;
    @GetMapping("/{id}")
    public DataResult<GetBootcampResponse> getById(@PathVariable int id){
        return this.bootcampService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllBootcampResponse>> getAll(){
        return this.bootcampService.getAll();
    }

    @PostMapping("/add")
    public DataResult<CreateBootcampResponse> add(@RequestBody CreateBootcampRequest createBootcampRequest){
        return this.bootcampService.add(createBootcampRequest);
    }
    @PutMapping
    public DataResult<UpdateBootcampResponse> update(@RequestBody UpdateBootcampRequest updateBootcampRequest){
        return this.bootcampService.update(updateBootcampRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        return this.bootcampService.delete(id);
    }
}
