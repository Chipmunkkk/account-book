package xin.shaozb.accountbook.auth.endpoint;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.shaozb.accountbook.auth.entity.AuthPrincipal;
import xin.shaozb.accountbook.auth.service.AuthService;
import xin.shaozb.accountbook.common.entity.common.Response;

import java.security.Principal;
import java.util.Map;

/**
 * Description:
 * Date: 2019/9/26 23:53
 *
 * @author 1033780702@qq.com
 */
@Slf4j
@RestController
public class AuthTokenEndPoints {

    @Autowired
    private TokenEndpoint tokenEndpoint;
    @Autowired
    private AuthService authService;

    @PostMapping("/oauth/token")
    public Response getToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        ResponseEntity<OAuth2AccessToken> accessToken = tokenEndpoint.postAccessToken(principal, parameters);
        try {
            accessToken = tokenEndpoint.postAccessToken(principal, parameters);
        } catch (Exception e) {

        }
        log.info("获取到accessToken:{}", accessToken);
        JSONObject data = new JSONObject();
        data.put("token", accessToken.getBody().getValue());
        data.put("type", accessToken.getBody().getTokenType());
        return Response.result(Response.ResponseCode.SUCCESS, data);
    }

    @PostMapping("/auth/token")
    public Response token(@RequestParam Map<String, String> params) throws HttpRequestMethodNotSupportedException {
        AuthPrincipal principal = authService.getPrincipal(params.get("client"));
        ResponseEntity<OAuth2AccessToken> accessToken = tokenEndpoint.postAccessToken(principal, params);
        return Response.result(Response.ResponseCode.SUCCESS, accessToken.getBody());
    }

}
