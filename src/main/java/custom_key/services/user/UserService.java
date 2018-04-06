package custom_key.services.user;

import custom_key.exceptions.GeneralException;
import custom_key.mappers.UserMapper;
import custom_key.models.User;
import custom_key.services.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by ryandesmond on 4/6/18.
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SecurityService securityService;

    public ArrayList<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public User getUserById(int id) throws GeneralException {
        User u = userMapper.getByID(id);
        if (u == null){
            throw new GeneralException("User not found");
        }

        return u;
    }

    public User createUser(User user) throws NoSuchAlgorithmException, GeneralException {
        String apiKey = securityService.generateApiKey(128);
        user.setApiKey(apiKey);
        int success = userMapper.insertUser(user);

        if (success == 1){
            User u = userMapper.getByName(user.getFirstName(), user.getLastName());
            return u;
        } else {
            throw new GeneralException("User Not Created.");
        }
    }

    public User updateUser(User user) throws GeneralException {
        int success = userMapper.updateUser(user);

        if (success == 1){
            User u = userMapper.getByName(user.getFirstName(), user.getLastName());
            return u;
        } else {
            throw new GeneralException("User Not Updated.");
        }
    }

    public User deleteUser(int id) throws GeneralException {

        int success = userMapper.deleteUser(id);

        if (success == 1){
            User u = userMapper.getByID(id);
            return u;
        } else {
            throw new GeneralException("User Not Updated.");
        }
    }
}
