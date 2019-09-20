package xin.shaozb.accountbook.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description:
 * Date: 2019/9/18 21:14
 *
 * @author 1033780702@qq.com
 */
@EnableEurekaServer
@SpringCloudApplication
public class AccountBookEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountBookEurekaApplication.class, args);
    }
}
