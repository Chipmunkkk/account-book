package xin.shaozb.accountbook.common.entity.uac;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xin.shaozb.accountbook.common.util.Md5PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Description:
 * Date: 2019/10/13 14:43
 *
 * @author 1033780702@qq.com
 */
@Data
public class User implements UserDetails {

    private static final long serialVersionUID = 8118548262764970946L;
    private String id;
    private String name = "";
    private String account = "";
    private String password = "";
    private short active = 0;
    private short lock = 0;
    private LocalDateTime createTime = LocalDateTime.now();

    public User() {

    }

    public User(String account, String password) {
        this.account = account;
        this.password = Md5PasswordEncoder.encrypt(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
