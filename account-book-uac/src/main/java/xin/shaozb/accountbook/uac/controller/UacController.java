package xin.shaozb.accountbook.uac.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xin.shaozb.accountbook.common.entity.common.Response;
import xin.shaozb.accountbook.common.entity.uac.User;
import xin.shaozb.accountbook.uac.service.AuthService;
import xin.shaozb.accountbook.uac.service.UserService;

/**
 * Description:
 * Date: 2019/10/13 16:08
 *
 * @author 1033780702@qq.com
 */
@Slf4j
@RestController
public class UacController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Response register(@RequestBody JSONObject params) {
        String account = params.getString("account");
        String password = params.getString("password");
        User user = userService.checkUserByAccount(account);
        if (user != null) {
            return Response.result(Response.ResponseCode.FAILED, "该账号已注册,请直接登录");
        }
        user = new User(account, password);
        userService.register(user);
        return Response.result(Response.ResponseCode.SUCCESS);
    }

    @PostMapping("/login")
    public Response login(String account, String password) {
        JSONObject result = authService.auth(account, password);
        if (result.getBooleanValue("auth")) {
            JSONObject tokenInfo = result.getJSONObject("tokenInfo");
            String accessToken = tokenInfo.getString("access_token");
            log.info("用户[{}]登录成功,获取到accessToken:{}", account, accessToken);
            return Response.result(Response.ResponseCode.SUCCESS, tokenInfo);
        } else {
            return Response.result(Response.ResponseCode.FAILED);
        }
    }

    /**
     * 提供给auth服务的查询接口
     *
     * @param name
     * @return
     */
    @GetMapping("/check-user")
    public Response loginByName(String name) {
        UserDetails user = userService.loadUserByUsername(name);
        return Response.result(Response.ResponseCode.SUCCESS, user);
    }

}
