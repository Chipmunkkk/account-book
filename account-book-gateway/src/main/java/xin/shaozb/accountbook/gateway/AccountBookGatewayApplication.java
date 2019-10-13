package xin.shaozb.accountbook.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 * Date: 2019/10/13 16:19
 *
 * @author 1033780702@qq.com
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AccountBookGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountBookGatewayApplication.class, args);
    }
}
