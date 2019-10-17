package xin.shaozb.accountbook.common.entity.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Description:
 * Date: 2019/9/25 21:37
 *
 * @author 1033780702@qq.com
 */
public class Response extends JSONObject {

    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String DATA = "data";
    private static final long serialVersionUID = -3676543896466883331L;

    public Response() {
        put(CODE, 0);
        put(MSG, "");
        put(DATA, null);
    }

    private Response(ResponseCode code) {
        setCode(code);
    }

    private Response(ResponseCode code, String msg) {
        setCode(code);
        setMsg(msg);
    }

    private Response(ResponseCode code, Object data) {
        setCode(code);
        setData(data);
    }

    private Response(ResponseCode code, String msg, Object data) {
        setCode(code);
        setMsg(msg);
        setData(data);
    }

    public static Response result(ResponseCode code) {
        return new Response(code);
    }

    public static Response result(ResponseCode code, String msg) {
        return new Response(code, msg);
    }

    public static Response result(ResponseCode code, Object data) {
        return new Response(code, data);
    }

    public static Response result(ResponseCode code, String msg, Object data) {
        return new Response(code, msg, data);
    }

    public int getCode() {
        return getIntValue(CODE);
    }

    public void setCode(ResponseCode code) {
        put(CODE, code.getCode());
        put(MSG, code.getMsg());
    }

    public String getMsg() {
        return getString(MSG);
    }

    public void setMsg(String msg) {
        put(MSG, msg);
    }

    public Object getData() {
        return get(DATA);
    }

    public void setData(Object data) {
        put(DATA, data);
    }

    public <T> T getData(Class<T> clazz) {
        return JSON.toJavaObject(JSONObject.parseObject(JSON.toJSONString(get(DATA))), clazz);
    }

    public enum ResponseCode {
        SUCCESS(200, "操作成功"),
        BAD_REQUEST(400, "请求参数错误"),
        AUTH_ERROR(4001, "token获取失败"),
        UNAUTHORIZED(401, "对不起,请先登录再进行操作"),
        FORBIDDEN(403, "没有该操作所需权限"),
        METHOD_NOT_ALLOWED(405, "请求方法不支持"),
        FAILED(500, "操作失败"),
        ERROR(502, "系统异常");

        private int code;
        private String msg;

        ResponseCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

}
