package mybatis.mappers;

import mybatis.model.Movie;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface MovieMapper {

    String GET_ALL_MOVIES = "SELECT * FROM `mybatis-test`.movie where isActive = 1";
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.movie where id = #{id}";
    String INSERT_ = "INSERT INTO `mybatis-test`.movie (name, isActive) " +
            "VALUES (#{name},#{isActive})";
    String UPDATE_ = "UPDATE `mybatis-test`.movie SET name = #{name}, " +
            "isActive = #{isActive} WHERE id = #{id}";
    String DELETE_ = "UPDATE `mybatis-test`.movie set isActive = 0 WHERE id = #{id}";
    String GET_BY_NAME = "SELECT * FROM `mybatis-test`.movie where name = #{name}";

    @Select(GET_BY_NAME)
    public Movie getByName(String name);

    @Select(GET_ALL_MOVIES)
    public ArrayList<Movie> getAlls();

    @Select(GET_BY_ID)
    public Movie getByID(int id);

    @Insert(INSERT_)
    public int insert (Movie m);

    @Update(UPDATE_)
    public int update (Movie m );

    @Delete(DELETE_)
    public int delete(int id);

}
