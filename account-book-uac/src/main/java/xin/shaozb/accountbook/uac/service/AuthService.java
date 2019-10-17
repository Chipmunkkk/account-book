package xin.shaozb.accountbook.uac.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.shaozb.accountbook.common.entity.common.Response;
import xin.shaozb.accountbook.uac.mapper.AuthMapper;

/**
 * Description:
 * Date: 2019/10/16 23:59
 *
 * @author 1033780702@qq.com
 */
@Service
public class AuthService {

    @Autowired
    private AuthMapper authMapper;

    public JSONObject auth(String account, String password) {
        JSONObject params = new JSONObject();
        params.put("username", account); // todo
        params.put("password", password);
        params.put("client", password);
        params.put("grant_type", password);
        Response response = authMapper.auth(params);
        JSONObject result = new JSONObject();
        boolean isAuth = response.getCode() == Response.ResponseCode.SUCCESS.getCode();
        result.put("auth", isAuth);
        if (isAuth) {
            result.put("tokenInfo", response.getData(JSONObject.class));
        }
        return result;
    }
}
