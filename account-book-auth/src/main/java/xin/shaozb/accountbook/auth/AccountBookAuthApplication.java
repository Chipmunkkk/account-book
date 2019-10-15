package xin.shaozb.accountbook.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Description:
 * Date: 2019/9/20 23:24
 *
 * @author 1033780702@qq.com
 */
@EnableAuthorizationServer
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class AccountBookAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountBookAuthApplication.class, args);
    }
}
