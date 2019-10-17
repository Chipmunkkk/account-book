package xin.shaozb.accountbook.uac.mapper;

import org.apache.ibatis.annotations.*;
import xin.shaozb.accountbook.common.entity.uac.User;

/**
 * Description:
 * Date: 2019/10/13 14:28
 *
 * @author 1033780702@qq.com
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE `account`= #{account} LIMIT 1")
    @Results({
            @Result(column = "create_time", property = "createTime")
    })
    User findUserByAccount(String name);

    @Insert("INSERT INTO t_user (name,account,password,create_time) VALUES (#{name},#{account},#{password},NOW())")
    void insert(User user);
}
