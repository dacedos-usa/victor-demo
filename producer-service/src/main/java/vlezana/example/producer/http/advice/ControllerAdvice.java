package vlezana.example.producer.http.advice;

import vlezana.example.producer.domain.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({ResourceNotFoundException.class})
    ResponseEntity<Object> handle(ResourceNotFoundException exception) {
        log.error(exception.getLocalizedMessage(), exception);
        return ResponseEntity.notFound().build();
    }
}
