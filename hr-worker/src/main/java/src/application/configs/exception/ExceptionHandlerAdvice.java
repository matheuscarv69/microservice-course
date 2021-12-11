package src.application.configs.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import src.domain.exception.WorkerNotFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @Autowired
    private MessageSource messageSource;

    /**
     * Handle for Worker Not Found
     * return HttpStatus 404 - NOT FOUND
     */
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(WorkerNotFoundException.class)
    public ExceptionResponse handleWorkerNotFoundException(
            WorkerNotFoundException exception,
            HttpServletRequest request
    ) {
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                "",
                exception.getMessage(),
                request.getServletPath()
        );

    }

    /**
     * Handle for Internal Server Error
     * return HttpStatus 500 - INTERNAL SERVER ERROR
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleException(
            Exception exception,
            HttpServletRequest request
    ) {
        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                "",
                exception.getMessage(),
                request.getServletPath()
        );

    }

}
