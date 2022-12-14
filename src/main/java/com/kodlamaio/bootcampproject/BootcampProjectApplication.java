package com.kodlamaio.bootcampproject;

import com.kodlamaio.bootcampproject.core.exceptions.BusinessException;
import com.kodlamaio.bootcampproject.core.utilities.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class BootcampProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcampProjectApplication.class, args);
    }

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<>(validationErrors, "VALIDATION EXCEPTION");
        return errorDataResult;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleBussinessException(BusinessException businessException){
        return new ErrorDataResult<>(businessException.getMessage(),"BUSSINESS EXCEPTION");
    }
}
