package mybatis.mappers;

import mybatis.model.User;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

@Mapper
public interface UserMapper {

    String GET_ALL__ACTIVE_USERS = "SELECT * FROM `mybatis-test`.users where isActive = 1";
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.users where id = #{id}";
    String INSERT_ = "INSERT INTO `mybatis-test`.users (first_name, last_name, isActive) " +
            "VALUES (#{first_name}, #{last_name}, #{isActive})";
    String UPDATE_ = "UPDATE `mybatis-test`.users SET first_name = #{first_name}, " +
            "last_name = #{last_name}, isActive = #{isActive} WHERE id = #{id}";
    String DELETE_ = "UPDATE `mybatis-test`.users set isActive = 0 WHERE id = #{id}";
    String GET_BY_NAME = "SELECT * FROM `mybatis-test`.users where first_name = #{first_name}";

    @Select(GET_BY_NAME)
    public User getByName(String name);

    @Select(GET_ALL__ACTIVE_USERS)
    public ArrayList<User> getAlls();

    @Select(GET_BY_ID)
    public User getByID(int id);

    @Insert(INSERT_)
    public int insert ( User u);

    @Update(UPDATE_)
    public int update (User u );

    @Delete(DELETE_)
    public int delete(int id);

}