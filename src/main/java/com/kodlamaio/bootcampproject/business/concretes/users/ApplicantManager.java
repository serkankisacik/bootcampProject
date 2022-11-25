package com.kodlamaio.bootcampproject.business.concretes.users;

import com.kodlamaio.bootcampproject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.users.CreateApplicantRequest;
import com.kodlamaio.bootcampproject.business.requests.users.UpdateApplicantRequest;
import com.kodlamaio.bootcampproject.business.responses.users.CreateApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetAllApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.GetApplicantResponse;
import com.kodlamaio.bootcampproject.business.responses.users.UpdateApplicantResponse;
import com.kodlamaio.bootcampproject.core.exceptions.BusinessException;
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
        checkIfApplicantExistById(id);
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
        checkIfApplicantExistByNationalId(updateApplicantRequest.getNationalId());
        Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
        this.applicantRepository.save(applicant);
        UpdateApplicantResponse response = this.modelMapperService.forResponse().map(applicant, UpdateApplicantResponse.class);
        return new SuccessDataResult<>(response, Messages.ApplicantUpdated);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        checkIfApplicantExistById(id);
        Applicant applicant = this.applicantRepository.findById(id);
        GetApplicantResponse response = this.modelMapperService.forResponse().map(applicant, GetApplicantResponse.class);
        return new SuccessDataResult<GetApplicantResponse>(response);
    }

    private void checkIfApplicantExistByNationalId(String nationalId) {
        Applicant applicantCheck = this.applicantRepository.findApplicantByNationalId(nationalId);
        if (applicantCheck != null) {
            throw new BusinessException(Messages.ApplicantAlreadyExist);
        }
    }

    private void checkIfApplicantExistById(int id) {
        Applicant applicantCheck = this.applicantRepository.findById(id);
        if (applicantCheck == null) {
            throw new BusinessException(Messages.ApplicantNotFound);
        }
    }
}
