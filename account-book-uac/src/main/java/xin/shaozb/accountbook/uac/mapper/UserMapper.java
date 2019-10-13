package xin.shaozb.accountbook.uac.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xin.shaozb.accountbook.common.entity.uac.User;

/**
 * Description:
 * Date: 2019/10/13 14:28
 *
 * @author 1033780702@qq.com
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE `name`= #{name} LIMIT 1")
    User findUserByName(String name);

}
