package games.linkin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import games.linkin.pojo.People;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleDao extends BaseMapper<People> {

}
