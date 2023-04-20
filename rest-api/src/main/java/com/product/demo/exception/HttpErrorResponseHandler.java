package com.product.demo.exception;


import com.product.demo.pojo.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class HttpErrorResponseHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected APIResponse<?> handleResourceNotFound(final NotFoundException ex) {
        return new APIResponse<>(ex.getMessage(), false);
    }



    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected APIResponse<String> badRequestException(final HttpClientErrorException.BadRequest ex) {
        return new APIResponse<>(ex.getMessage(),false);
    }


}
