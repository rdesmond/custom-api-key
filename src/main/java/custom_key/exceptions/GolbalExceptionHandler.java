package custom_key.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by ryandesmond on 4/6/18.
 */

@ControllerAdvice
public class GolbalExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public @ResponseBody ExceptionResponse handle404(GeneralException ge) {
        ExceptionResponse error = new ExceptionResponse();
        error.setMessage(ge.getMessage());
        error.setStatus("error");
        error.setResponseCode(HttpStatus.I_AM_A_TEAPOT);
        return error;
    }

    @ExceptionHandler(NoSuchAlgorithmException.class)
    public @ResponseBody ExceptionResponse handleBadAlgo(NoSuchAlgorithmException nsa) {
        ExceptionResponse error = new ExceptionResponse();
        error.setMessage(nsa.getMessage());
        error.setStatus("error");
        error.setResponseCode(HttpStatus.I_AM_A_TEAPOT);
        return error;
    }


    @ExceptionHandler( AuthenticationException.class)
    public @ResponseBody ExceptionResponse handleBadApiKey(AuthenticationException nsa) {
        ExceptionResponse error = new ExceptionResponse();
        error.setMessage(nsa.getMessage());
        error.setStatus("invalid");
        error.setResponseCode(HttpStatus.UNAUTHORIZED);
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoHandlerFoundException.class})
    public @ResponseBody ExceptionResponse handle404() {
        ExceptionResponse error = new ExceptionResponse();
        error.setMessage("Resource not found.");
        error.setStatus("404");
        error.setResponseCode(HttpStatus.UNAUTHORIZED);
        return error;
    }

}


