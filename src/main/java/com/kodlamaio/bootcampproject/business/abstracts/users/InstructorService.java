package com.kodlamaio.bootcampproject.business.abstracts.users;

import com.kodlamaio.bootcampproject.business.requests.users.CreateInstructorRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateInstructorRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetInstructorResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateInstructorResponse;
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
