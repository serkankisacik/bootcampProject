package com.kodlamaio.bootcampproject.business.concretes.Users;

import com.kodlamaio.bootcampproject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.UpdateApplicantResponse;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.abstracts.users.ApplicantRepository;
import com.kodlamaio.bootcampproject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result delete(int id) {
        this.applicantRepository.deleteById(id);
        return new SuccessResult(Messages.ApplicantDeleted);
    }

    @Override
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
        Applicant applicant = this.modelMapperService.forRequest().map(createApplicantRequest, Applicant.class);
        this.applicantRepository.save(applicant);
        CreateApplicantResponse createApplicantResponse = this.modelMapperService.forResponse().map(applicant, CreateApplicantResponse.class);
        return new SuccessDataResult<CreateApplicantResponse>(createApplicantResponse, Messages.ApplicantCreated);
    }

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> applicants = this.applicantRepository.findAll();
        List<GetAllApplicantResponse> response = applicants.stream().map(applicant -> this.modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicantResponse>>(response);
    }

    @Override
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
        Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
        this.applicantRepository.save(applicant);
        UpdateApplicantResponse response = this.modelMapperService.forResponse().map(applicant, UpdateApplicantResponse.class);
        return new SuccessDataResult<>(response, Messages.ApplicantUpdated);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        Applicant applicant = this.applicantRepository.findById(id).get();
        GetApplicantResponse response = this.modelMapperService.forResponse().map(applicant, GetApplicantResponse.class);
        return new SuccessDataResult<GetApplicantResponse>(response);
    }
}
