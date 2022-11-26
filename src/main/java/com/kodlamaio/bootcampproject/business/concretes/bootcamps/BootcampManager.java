package com.kodlamaio.bootcampproject.business.concretes.bootcamps;

import com.kodlamaio.bootcampproject.business.abstracts.bootcamps.BootcampService;
import com.kodlamaio.bootcampproject.business.constants.Messages;
import com.kodlamaio.bootcampproject.business.requests.bootcamps.CreateBootcampRequest;
import com.kodlamaio.bootcampproject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlamaio.bootcampproject.business.responses.bootcamps.CreateBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlamaio.bootcampproject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlamaio.bootcampproject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampproject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.Result;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampproject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampproject.dataAccess.abstracts.bootcamps.BootcampRepository;
import com.kodlamaio.bootcampproject.entities.bootcamps.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private BootcampRepository bootcampRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result delete(int id) {
        this.bootcampRepository.deleteById(id);
        return new SuccessResult(Messages.BootcampDeleted);
    }

    @Override
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
        Bootcamp bootcamp = this.modelMapperService.forRequest().map(createBootcampRequest, Bootcamp.class);
        this.bootcampRepository.save(bootcamp);
        CreateBootcampResponse createBootcampResponse = this.modelMapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);
        return new SuccessDataResult<CreateBootcampResponse>(createBootcampResponse, Messages.BootcampCreated);
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootcamps = this.bootcampRepository.findAll();
        List<GetAllBootcampResponse> responses = bootcamps.stream().map(bootcamp -> this.modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBootcampResponse>>(responses);
    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
        Bootcamp bootcamp = this.modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
        this.bootcampRepository.save(bootcamp);
        UpdateBootcampResponse response = this.modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);
        return new SuccessDataResult<UpdateBootcampResponse>(response, Messages.BootcampUpdated);
    }

    @Override
    public DataResult<GetBootcampResponse> getById(int id) {
        Bootcamp bootcamp = this.bootcampRepository.findById(id);
        GetBootcampResponse response = this.modelMapperService.forResponse().map(bootcamp, GetBootcampResponse.class);
        return new SuccessDataResult<GetBootcampResponse>(response);
    }
}
