package xin.shaozb.accountbook.uac.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xin.shaozb.accountbook.common.entity.uac.User;
import xin.shaozb.accountbook.uac.mapper.UserMapper;

/**
 * Description:
 * Date: 2019/10/13 14:27
 *
 * @author 1033780702@qq.com
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userMapper.findUserByAccount(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

    public User checkUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }

    public void register(User user) {
        user.setName(RandomStringUtils.randomAlphabetic(10));
        userMapper.insert(user);
    }
}
