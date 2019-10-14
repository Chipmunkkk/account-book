package xin.shaozb.accountbook.uac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.shaozb.accountbook.common.entity.common.Response;
import xin.shaozb.accountbook.uac.service.UserService;

/**
 * Description:
 * Date: 2019/10/13 16:08
 *
 * @author 1033780702@qq.com
 */
@RestController
public class UacController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Response loginByName(String name) {
        UserDetails user = userService.loadUserByUsername(name);
        return Response.result(Response.ResponseCode.SUCCESS, user);
    }

}
