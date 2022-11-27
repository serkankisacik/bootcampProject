package com.kodlamaio.bootcampproject.business.abstracts.applications;

import com.kodlamaio.bootcampproject.business.requests.applications.CreateApplicationRequest;
import com.kodlamaio.bootcampproject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampproject.business.responses.applications.CreateApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationService {

    Result delete(int id);

    DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);

    DataResult<List<GetAllApplicationResponse>> getAll();

    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest);

    DataResult<GetApplicationResponse> getById(int id);
}
