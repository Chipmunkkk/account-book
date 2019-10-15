package xin.shaozb.accountbook.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.shaozb.accountbook.auth.entity.AuthClientInfo;
import xin.shaozb.accountbook.auth.entity.AuthPrincipal;
import xin.shaozb.accountbook.auth.mapper.AuthMapper;

/**
 * Description:
 * Date: 2019/10/13 14:06
 *
 * @author 1033780702@qq.com
 */
@Service
public class AuthService {

    @Autowired
    private AuthMapper authMapper;

    public AuthPrincipal getPrincipal(String client) {
        AuthPrincipal authPrincipal = new AuthPrincipal();
        authPrincipal.setName(client);
        return authPrincipal;
    }

    public AuthClientInfo findClientByName(String client) {
        return authMapper.findClientByName(client);
    }

}
