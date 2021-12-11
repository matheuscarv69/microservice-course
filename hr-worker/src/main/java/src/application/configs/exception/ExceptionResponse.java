package src.application.configs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ExceptionResponse {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String field;
    private String message;
    private String path;

    public ExceptionResponse(Integer status,
                             String error,
                             String field,
                             String message,
                             String path) {

        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.field = field;
        this.message = message;
        this.path = path;
    }
}
