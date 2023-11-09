package angelomoreno.Es4_091123.exceptions;

import angelomoreno.Es4_091123.payloads.errori.ErrorResponseDTO;
import angelomoreno.Es4_091123.payloads.errori.ErrorsResponseWithListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsResponseWithListDTO handleBadPayload(BadRequestException exception){
        if(exception.getErrorList() != null) {
            List<String> errorList = exception.getErrorList().stream().map(objectError -> objectError.getDefaultMessage()).toList();
            return new ErrorsResponseWithListDTO(exception.getMessage(), new Date(), errorList);
        } else {
            return new ErrorsResponseWithListDTO(exception.getMessage(), new Date(),new ArrayList<>());
        }
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNotFound(NotFoundException exception)  {
        return new ErrorResponseDTO(exception.getMessage(), new Date());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleGenericEx(Exception exception) {
        exception.printStackTrace();
        return new ErrorResponseDTO("Errore del server... Cercheremo di aggiustare questo errore", new Date());
    }
}
