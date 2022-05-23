package games.linkin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import games.linkin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from user where username = #{username} and password = #{password}")
    public User selectByUsernameAndPasswordUser(User user);
}
