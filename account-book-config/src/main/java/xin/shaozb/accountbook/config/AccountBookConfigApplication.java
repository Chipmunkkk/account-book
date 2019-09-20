package xin.shaozb.accountbook.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Description:
 * Date: 2019/9/18 21:55
 *
 * @author 1033780702@qq.com
 */
@EnableConfigServer
@SpringCloudApplication
public class AccountBookConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountBookConfigApplication.class, args);
    }
}
