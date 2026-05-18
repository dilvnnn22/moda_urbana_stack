package cl.duoc.pedidos_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    public Map<String, String> manejarError(Exception ex) {

        Map<String, String> error = new HashMap<>();

        error.put("mensaje", ex.getMessage());

        return error;
    }
}
