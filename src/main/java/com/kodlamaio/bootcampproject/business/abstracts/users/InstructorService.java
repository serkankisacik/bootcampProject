package com.kodlamaio.bootcampproject.business.abstracts.users;

import com.kodlamaio.bootcampproject.business.requests.CreateInstructorRequest;
import com.kodlamaio.bootcampproject.business.requests.UpdateInstructorRequest;
import com.kodlamaio.bootcampproject.business.responses.CreateInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.GetAllInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.GetInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.UpdateInstructorResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface InstructorService {
    Result delete(int id);
    DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);
    DataResult<List<GetAllInstructorResponse>> getAll();
    DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
    DataResult<GetInstructorResponse> getById(int id);
}
