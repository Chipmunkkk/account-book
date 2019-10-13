package xin.shaozb.accountbook.gateway.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import xin.shaozb.accountbook.common.entity.common.Response;

/**
 * Description:
 * Date: 2019/10/13 16:16
 *
 * @author 1033780702@qq.com
 */
@FeignClient("account-book-user-service")
public interface UserServiceApi {

    @PostMapping(value = "/login")
    Response loginByName();
}
