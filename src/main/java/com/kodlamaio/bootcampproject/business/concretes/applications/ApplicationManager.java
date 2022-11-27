package com.kodlamaio.bootcampproject.business.concretes.applications;

import com.kodlamaio.bootcampproject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.applications.CreateApplicationRequest;
import com.kodlamaio.bootcampproject.business.requests.applications.UpdateApplicationRequest;
import com.kodlamaio.bootcampproject.business.responses.applications.CreateApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.GetAllApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.GetApplicationResponse;
import com.kodlamaio.bootcampproject.business.responses.applications.UpdateApplicationResponse;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.abstracts.applications.ApplicationRepository;
import com.kodlamaio.bootcampproject.entities.aplications.Application;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result delete(int id) {
        this.applicationRepository.deleteById(id);
        return new SuccessResult(Messages.ApplicationDeleted);
    }

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
        Application application = this.modelMapperService.forRequest().map(createApplicationRequest, Application.class);
        this.applicationRepository.save(application);
        CreateApplicationResponse createApplicationResponse = this.modelMapperService.forResponse().map(application, CreateApplicationResponse.class);
        return new  SuccessDataResult<CreateApplicationResponse>(createApplicationResponse,Messages.ApplicationCreated);
    }

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAll() {
        List<Application> applications = this.applicationRepository.findAll();
        List<GetAllApplicationResponse> responses = applications.stream().map(application -> this.modelMapperService.forResponse().map(application, GetAllApplicationResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationResponse>>(responses);
    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
        Application application = this.modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
        this.applicationRepository.save(application);
        UpdateApplicationResponse response = this.modelMapperService.forResponse().map(application,UpdateApplicationResponse.class);
        return new SuccessDataResult<UpdateApplicationResponse>(response, Messages.ApplicationUpdated);
    }

    @Override
    public DataResult<GetApplicationResponse> getById(int id) {
        Application application = this.applicationRepository.findById(id);
        GetApplicationResponse response = this.modelMapperService.forResponse().map(application, GetApplicationResponse.class);
        return new SuccessDataResult<GetApplicationResponse>(response);
    }
}
