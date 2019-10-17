package xin.shaozb.accountbook.uac.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;
import xin.shaozb.accountbook.common.entity.common.Response;

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
        log.warn("UacAuthenticationEntryPoint#commence:{}, {}, {}", httpServletRequest, httpServletResponse, e.getMessage(), e);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        if (!(httpServletRequest instanceof SecurityContextHolderAwareRequestWrapper)) {
            Response response;
            Throwable cause = e.getCause();
            if (cause instanceof InvalidTokenException) {
                response = Response.result(Response.ResponseCode.INVALID_TOKEN, "token已失效,请重新登录");
            } else if (cause instanceof OAuth2AccessDeniedException) {
                response = Response.result(Response.ResponseCode.INVALID_TOKEN, "该token无效,请重新获取");
            } else {
                response = Response.result(Response.ResponseCode.UNAUTHORIZED);
            }
            httpServletResponse.getWriter().print(response);
        } else {
            httpServletResponse.getWriter().print(Response.result(Response.ResponseCode.UNAUTHORIZED));
        }

    }
}
