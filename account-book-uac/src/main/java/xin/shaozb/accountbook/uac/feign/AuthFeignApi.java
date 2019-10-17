package xin.shaozb.accountbook.uac.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.shaozb.accountbook.common.entity.common.Response;

/**
 * Description:
 * Date: 2019/10/17 22:58
 *
 * @author 1033780702@qq.com
 */
@FeignClient(name = "account-book-auth")
public interface AuthFeignApi {

    @RequestMapping(value = "/auth/token", method = RequestMethod.POST)
    Response auth(@RequestBody JSONObject params);
}
