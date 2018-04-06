package custom_key.exceptions;

/**
 * Created by ryandesmond on 4/6/18.
 */
public class GeneralException extends Exception {

    public GeneralException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "GeneralException{}";
    }
}
