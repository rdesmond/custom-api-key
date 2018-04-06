package custom_key.exceptions;

/**
 * Created by ryandesmond on 4/6/18.
 */
public class AuthenticationException extends Exception{

    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "AuthenticationException{}";
    }
}
