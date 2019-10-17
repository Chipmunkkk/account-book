package xin.shaozb.accountbook.auth.endpoint;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xin.shaozb.accountbook.auth.entity.AuthPrincipal;
import xin.shaozb.accountbook.auth.service.AuthService;
import xin.shaozb.accountbook.common.entity.common.Response;

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
    @Value("spring.application.name")
    private String appName;

    @PostMapping("/auth/token")
    public Response token(@RequestBody JSONObject params) throws HttpRequestMethodNotSupportedException {
        String appId = params.getString("appId");
        if (StringUtils.isEmpty(appId)) {
            return Response.result(Response.ResponseCode.BAD_REQUEST, "appId不能为空");
        }
        AuthPrincipal principal;
        try {
            principal = authService.getPrincipal(appId);
            params.put("username", params.getString("account"));
            ResponseEntity<OAuth2AccessToken> accessToken = tokenEndpoint.postAccessToken(principal, JSON.toJavaObject(params, Map.class));
            return Response.result(Response.ResponseCode.SUCCESS, accessToken.getBody());
        } catch (IllegalArgumentException e) {
            log.warn("[{}]服务出现异常{}", appName, e.getMessage(), e);
            return Response.result(Response.ResponseCode.FAILED, e.getMessage());
        } catch (InvalidGrantException | InternalAuthenticationServiceException e) { // 密码错误|账号不存在
            return Response.result(Response.ResponseCode.BAD_REQUEST, e.getMessage());
        }
    }

}
