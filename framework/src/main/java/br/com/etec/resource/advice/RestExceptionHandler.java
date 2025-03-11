package br.com.etec.resource.advice;

import br.com.etec.exception.InternalServerError;
import br.com.etec.exception.NotFound;
import br.com.etec.exception.RequestTimeout;
import br.com.etec.resource.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({InternalServerError.class, Exception.class})
    public ErrorResponse handleInternalServerError(
            final Exception exception,
            final HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(),
                exception.getMessage());
    }

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    public ErrorResponse handleNotFound(
            final NotFound exception,
            final HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
                exception.getMessage()
        );
    }

    @ResponseBody
    @ResponseStatus(REQUEST_TIMEOUT)
    @ExceptionHandler(RequestTimeout.class)
    public ErrorResponse handleTimeout(
            final RequestTimeout exception,
            final HttpServletRequest request) {
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                REQUEST_TIMEOUT.value(),
                REQUEST_TIMEOUT.getReasonPhrase(),
                exception.getMessage()
        );
    }


}
