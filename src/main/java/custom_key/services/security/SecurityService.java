package custom_key.services.security;

import custom_key.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by ryandesmond on 4/6/18.
 */

@Service
public class SecurityService {

    @Autowired
    UserMapper userMapper;

    public static String generateApiKey(int length) throws NoSuchAlgorithmException {

        SecureRandom random = new SecureRandom();
        byte [] bytes = new byte[length/8];
        random.nextBytes(bytes);

        return DatatypeConverter.printHexBinary(bytes).toLowerCase();
    }

    public boolean authenticateApiKey(String apiKey){



        try {
            boolean isActive = userMapper.authenticate(apiKey);
            if (isActive)
                return true;
        } catch(Exception e) {
            return false;
        }
        return false;
    }
}
