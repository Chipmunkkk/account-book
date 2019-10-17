package xin.shaozb.accountbook.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xin.shaozb.accountbook.auth.mapper.UserMapper;
import xin.shaozb.accountbook.common.entity.common.Response;
import xin.shaozb.accountbook.common.entity.uac.User;

/**
 * Description:
 * Date: 2019/9/21 12:42
 *
 * @author 1033780702@qq.com
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Response response = userMapper.checkUser(name);
        if (response.getCode() == Response.ResponseCode.SUCCESS.getCode()) {
            User user = response.getData(User.class);
            if (user == null) {
                throw new UsernameNotFoundException("用户不存在");
            }
            return user;
        } else {
            return null;
        }
    }
}
