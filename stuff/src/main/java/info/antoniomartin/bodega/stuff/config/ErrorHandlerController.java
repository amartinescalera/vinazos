package info.antoniomartin.bodega.stuff.config;

import info.antoniomartin.bodega.stuff.wine.application.exception.WineMandatoryException;
import info.antoniomartin.bodega.stuff.wine.application.exception.WineNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorHandlerController {


    @ExceptionHandler(WineMandatoryException.class)
    public ResponseEntity<String> handleMandatoryException(final UnsupportedOperationException e) {
        log.error(e.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(WineNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(final UnsupportedOperationException e) {
        log.error(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.notFound().build();
    }

}
