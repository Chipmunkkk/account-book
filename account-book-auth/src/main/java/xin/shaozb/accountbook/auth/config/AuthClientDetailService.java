package xin.shaozb.accountbook.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;
import xin.shaozb.accountbook.auth.entity.AuthClient;
import xin.shaozb.accountbook.auth.service.AuthService;

/**
 * Description:
 * Date: 2019/10/14 23:17
 *
 * @author 1033780702@qq.com
 */
@Component
public class AuthClientDetailService implements ClientDetailsService {

    @Autowired
    private AuthService authService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        AuthClient client = authService.findClientByName(clientId);
        if (client == null) {
            throw new ClientRegistrationException("应用" + clientId + "不存在");
        }
        return client;
    }
}
