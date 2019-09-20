package xin.shaozb.accountbook.uac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 * Date: 2019/9/18 22:49
 *
 * @author 1033780702@qq.com
 */
@EnableEurekaClient
@SpringBootApplication
public class AccountBookUacApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountBookUacApplication.class,args);
    }
}
