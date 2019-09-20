package xin.shaozb.accountbook.uac.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Date: 2019/9/18 22:59
 *
 * @author 1033780702@qq.com
 */
@RestController
public class ConfigClientController {

    @Value("${data}")
    private String data;

    @GetMapping("/getData")
    public String getData(){
        return this.data;
    }
}
