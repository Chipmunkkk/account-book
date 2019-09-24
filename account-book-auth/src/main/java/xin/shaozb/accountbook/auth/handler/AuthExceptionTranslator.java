package xin.shaozb.accountbook.auth.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Date: 2019/9/24 23:49
 *
 * @author 1033780702@qq.com
 */
@Slf4j
@Component
public class AuthExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity translate(Exception e) throws Exception {
        log.info("AuthExceptionTranslator#translate:{}", e);
        return ResponseEntity.ok("{\"error\":\"bad credentials\"}");
    }
}
