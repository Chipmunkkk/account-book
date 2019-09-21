package xin.shaozb.accountbook.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xin.shaozb.accountbook.auth.mapper.UserMapper;

/**
 * Description:
 * Date: 2019/9/21 12:42
 *
 * @author 1033780702@qq.com
 */
@Slf4j
@Service
public class UserService implements UserDetailsService {

//    @Autowired
//    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        log.info("登录用户:{}", name);
        throw new UsernameNotFoundException("there's no user founded!");
    }
}
