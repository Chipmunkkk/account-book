package xin.shaozb.accountbook.uac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Date: 2019/9/18 22:59
 *
 * @author 1033780702@qq.com
 */
@Slf4j
@RestController
public class ConfigClientController {

    @Value("${data}")
    private String data;

    @GetMapping("/getData")
    public String getData() {
        log.info("getData========>{}", data);
        return this.data;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "This is the login page";
    }
}
