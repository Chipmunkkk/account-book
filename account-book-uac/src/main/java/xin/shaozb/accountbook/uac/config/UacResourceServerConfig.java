package xin.shaozb.accountbook.uac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Description:
 * Date: 2019/9/21 21:33
 *
 * @author 1033780702@qq.com
 */
@Configuration
public class UacResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private UacAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private UacAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Value("${spring.application.name}")
    private String appName;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login", "/register", "/check-user").permitAll() // 除了首页和登录不做认证,其余的请求全部需要认证才能访问
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(appName).authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .tokenStore(redisTokenStore());
    }

    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
}
