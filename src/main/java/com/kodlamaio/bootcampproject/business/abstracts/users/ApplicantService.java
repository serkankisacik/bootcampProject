package com.kodlamaio.bootcampproject.business.abstracts.users;

import com.kodlamaio.bootcampproject.business.requests.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.UpdateApplicantResponse;
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
