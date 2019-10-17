package xin.shaozb.accountbook.uac.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xin.shaozb.accountbook.common.entity.common.Response;
import xin.shaozb.accountbook.common.entity.uac.User;
import xin.shaozb.accountbook.uac.feign.AuthFeignApi;
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

    @Autowired
    private AuthFeignApi authFeignApi;

    @Value("${spring.application.name}")
    private String client;

    @Value("${application.appId}")
    private String appId;

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

    public JSONObject auth(String account, String password) {
        JSONObject params = new JSONObject();
        params.put("account", account);
        params.put("password", password);
        params.put("appId", appId);
        params.put("grant_type", "password");
        Response response = authFeignApi.auth(params);
        JSONObject result = new JSONObject();
        boolean isAuth = response.getCode() == Response.ResponseCode.SUCCESS.getCode();
        result.put("auth", isAuth);
        if (isAuth) {
            result.put("tokenInfo", response.getData(JSONObject.class));
        }
        return result;
    }
}
