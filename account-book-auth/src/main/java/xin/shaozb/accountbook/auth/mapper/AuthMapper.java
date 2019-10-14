package xin.shaozb.accountbook.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import xin.shaozb.accountbook.auth.entity.AuthClient;

/**
 * Description:
 * Date: 2019/10/14 23:20
 *
 * @author 1033780702@qq.com
 */
@Mapper
public interface AuthMapper {

    @Results({
            @Result(column = "grant_type", property = "grantType")
    })
    @Select("SELECT * FROM t_auth_client WHERE client = #{client} LIMIT 1")
    AuthClient findClientByName(String client);
}
