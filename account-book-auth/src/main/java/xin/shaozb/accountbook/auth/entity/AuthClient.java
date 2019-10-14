package xin.shaozb.accountbook.auth.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * Date: 2019/10/14 23:21
 *
 * @author 1033780702@qq.com
 */
@Data
public class AuthClient implements ClientDetails {

    private static final long serialVersionUID = 4675852801686079611L;
    private String id;
    private String client;
    private String secret;
    private String scope;
    private String grantType;

    @Override
    public String getClientId() {
        return this.client;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return this.secret;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        Set<String> scopes = new HashSet<>();
        scopes.add(scope);
        return scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        Set<String> types = new HashSet<>();
        types.add(grantType);
        return types;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 50000;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 50000;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
