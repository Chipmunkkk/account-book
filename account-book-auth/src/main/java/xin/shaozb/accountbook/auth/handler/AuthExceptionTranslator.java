package xin.shaozb.accountbook.auth.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;
import xin.shaozb.accountbook.auth.config.AuthorizationServerConfig;
import xin.shaozb.accountbook.common.entity.common.Response;

/**
 * Description: 实现该接口,并在 AuthorizationServerConfig 中进行配置,实现自定义
 * Date: 2019/9/24 23:49
 *
 * @author 1033780702@qq.com
 * @see AuthorizationServerConfig
 */
@Slf4j
@Component
public class AuthExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity translate(Exception e) {
        return ResponseEntity.ok(Response.result(Response.ResponseCode.INVALID_TOKEN));
    }
}
