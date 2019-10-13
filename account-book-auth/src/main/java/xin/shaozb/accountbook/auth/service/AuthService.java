package xin.shaozb.accountbook.auth.service;

import org.springframework.stereotype.Service;
import xin.shaozb.accountbook.auth.entity.AuthPrincipal;

/**
 * Description:
 * Date: 2019/10/13 14:06
 *
 * @author 1033780702@qq.com
 */
@Service
public class AuthService {

    public AuthPrincipal getPrincipal(String client) {
        AuthPrincipal authPrincipal = new AuthPrincipal();
        authPrincipal.setName(client);
        return authPrincipal;
    }

}
