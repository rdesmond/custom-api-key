package custom_key.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by ryandesmond on 4/6/18.
 */
public class ExceptionResponse {

    String status;
    HttpStatus responseCode;
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HttpStatus getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(HttpStatus responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
