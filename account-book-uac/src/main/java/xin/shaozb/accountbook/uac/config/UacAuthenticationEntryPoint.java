package xin.shaozb.accountbook.uac.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Date: 2019/9/21 22:20
 *
 * @author 1033780702@qq.com
 */
@Slf4j
@Component
public class UacAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.info("UacAuthenticationEntryPoint#commence:{}, {}, {}", httpServletRequest, httpServletResponse, e.getMessage());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        if(!(httpServletRequest instanceof SecurityContextHolderAwareRequestWrapper)){
            httpServletResponse.getWriter().print("{\"error\":\"没有权限\"}");
        }else{
            httpServletResponse.getWriter().print("{\"error\":\"没有权限!!!!!\"}");
        }

    }
}
