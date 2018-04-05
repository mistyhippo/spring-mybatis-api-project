package mybatis.mappers;

import mybatis.model.meme.MemeResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemeMapper {

    String INSERT_SUMMARY = "INSERT INTO `mybatis-test`.meme (display_name, text0, text1) " +
            "VALUES (#{displayName}, #{text0}, #{text1})";


    @Insert(INSERT_SUMMARY)
    public int insert(MemeResult object);
}
