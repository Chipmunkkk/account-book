package xin.shaozb.accountbook.auth.mapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xin.shaozb.accountbook.common.entity.common.Response;

/**
 * Description:
 * Date: 2019/9/21 15:27
 *
 * @author 1033780702@qq.com
 */
@FeignClient(name = "account-book-uac")
public interface UserMapper {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Response findUserByName(@RequestParam String name);

}
