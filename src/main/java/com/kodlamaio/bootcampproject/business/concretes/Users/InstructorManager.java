package com.kodlamaio.bootcampproject.business.concretes.Users;

import com.kodlamaio.bootcampproject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.CreateInstructorRequest;
import com.kodlamaio.bootcampproject.business.requests.UpdateInstructorRequest;
import com.kodlamaio.bootcampproject.business.responses.*;
import com.kodlamaio.bootcampproject.core.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.abstracts.users.InstructorRepository;
import com.kodlamaio.bootcampproject.entities.users.Instructor;
import com.kodlamaio.bootcampproject.entities.users.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result delete(int id) {
        checkIfInstructorExistById(id);
        this.instructorRepository.deleteById(id);
        return new SuccessResult(Messages.InstructorDeleted);
    }

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
        checkIfInstructorExistByNationalId(createInstructorRequest.getNationalId());
        Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
        instructor.setId(0);
        this.instructorRepository.save(instructor);
        CreateInstructorResponse createInstructorResponse = this.modelMapperService.forResponse().map(instructor, CreateInstructorResponse.class);
        return new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse, Messages.InstructorCreated);
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = this.instructorRepository.findAll();
        List<GetAllInstructorResponse> response = instructors.stream().map(instructor -> this.modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllInstructorResponse>>(response);
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
        checkIfInstructorExistById(updateInstructorRequest.getId());

        Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
        this.instructorRepository.save(instructor);
        UpdateInstructorResponse response = this.modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);
        return new SuccessDataResult<UpdateInstructorResponse>(response, Messages.InstructorUpdated);
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        Instructor instructor = this.instructorRepository.findById(id);
        GetInstructorResponse response = this.modelMapperService.forResponse().map(instructor, GetInstructorResponse.class);

        return new SuccessDataResult<GetInstructorResponse>(response);
    }

    private void checkIfInstructorExistByNationalId(String nationalId){
        Instructor instructorCheck = this.instructorRepository.findInstructorByNationalId(nationalId);
        if (instructorCheck != null){
            throw  new BusinessException(Messages.InstructorAlreadyExists);
        }
    }

    private void checkIfInstructorExistById(int id){
        Instructor instructorCheck = this.instructorRepository.findById(id);
        if (instructorCheck == null){
            throw new BusinessException(Messages.InstructorNotFound);
        }
    }
}
