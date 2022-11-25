package com.kodlamaio.bootcampproject.business.abstracts.users;

import com.kodlamaio.bootcampproject.business.requests.users.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateApplicantResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicantService {

    Result delete(int id);

    DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);

    DataResult<List<GetAllApplicantResponse>> getAll();

    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);

    DataResult<GetApplicantResponse> getById(int id);
}
