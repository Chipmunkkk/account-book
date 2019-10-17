package xin.shaozb.accountbook.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Description: 自定义密码加密器
 * Date: 2019/9/21 15:31
 *
 * @author 1033780702@qq.com
 */
public class Md5PasswordEncoder implements PasswordEncoder {

    public static String encrypt(String text) {
        return new Md5PasswordEncoder().encode(text);
    }

    /**
     * 对传入的密码进行自定义加密
     */
    @Override
    public String encode(CharSequence charSequence) {
        if (StringUtils.isEmpty(charSequence)) {
            return null;
        }
        return DigestUtils.md5Hex(charSequence.toString()).toUpperCase();
    }

    /**
     * 将密码与存储的密码进行对比, 同时也进行secret的校验
     * 可以把secret也进行加密,这样就不同分开判断了
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equalsIgnoreCase(encode(rawPassword));
    }
}
