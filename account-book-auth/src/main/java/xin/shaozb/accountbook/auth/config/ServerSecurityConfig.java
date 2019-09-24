package xin.shaozb.accountbook.auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import xin.shaozb.accountbook.auth.handler.AuthFailHandler;
import xin.shaozb.accountbook.auth.handler.AuthSuccessHandler;
import xin.shaozb.accountbook.common.util.Md5PasswordEncoder;

/**
 * Description:
 * Date: 2019/9/21 11:37
 *
 * @author 1033780702@qq.com
 */
@Slf4j
@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthSuccessHandler successHandler;

    @Autowired
    private AuthFailHandler failHandler;

    /**
     * 配置密码加密器(可自定义)
     * todo 随后改为自定义的密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .successHandler(successHandler)
                .failureHandler(failHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/token", "/oauth/authorize").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("super").password("DE2F15D014D40B93578D255E6221FD60").roles("ADMIN").and()
                .withUser("super1").password("490EB03D394FD69C1EB0A116983CF3F4").roles("USER");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
