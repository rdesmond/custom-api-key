package custom_key.mappers;

import custom_key.models.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * Created by ryandesmond on 4/6/18.
 */
@Mapper
public interface UserMapper {

    String GET_ALL__ACTIVE_USERS = "SELECT * FROM `custom_key`.users where isActive = 1";
    String GET_BY_ID = "SELECT * FROM `custom_key`.users where id = #{id}";
    String INSERT_USER = "INSERT INTO `custom_key`.users (firstName, lastName, email, isActive, apiKey) " +
            "VALUES (#{firstName}, #{lastName}, #{email}, #{isActive}, #{apiKey})";
    String UPDATE_USER = "UPDATE `custom_key`.users SET firstName = #{firstName}, " +
            "lastName = #{lastName}, email = #{email}, isActive = #{isActive} WHERE id = #{id}";
    String DELETE_USER = "UPDATE `custom_key`.users set isActive = 0 WHERE id = #{id}";
    String GET_BY_NAME = "SELECT * FROM `custom_key`.users where firstName = #{arg0} and lastName = #{arg1}";
    String AUTHENTICATE = "SELECT isActive from `custom_key`.users where apiKey = #{apiKey}";

    @Select(GET_ALL__ACTIVE_USERS)
    public ArrayList<User> getAllUsers();

    @Select(GET_BY_ID)
    public User getByID(int id);

    @Select(GET_BY_NAME)
    public User getByName(String firstName, String lastName);

    @Insert(INSERT_USER)
    public int insertUser (User user);

    @Update(UPDATE_USER)
    public int updateUser (User user);

    @Delete(DELETE_USER)
    public int deleteUser(int id);

    @Select(AUTHENTICATE)
    boolean authenticate(String apiKey);
}
