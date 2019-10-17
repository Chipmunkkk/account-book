package xin.shaozb.accountbook.auth.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 * Date: 2019/10/14 23:21
 *
 * @author 1033780702@qq.com
 */
@Data
public class AuthClientInfo implements ClientDetails {

    private static final long serialVersionUID = 4675852801686079611L;
    private String id = "";
    private String client = "";
    private String secret = "";
    private String scope = "";
    private String grantType = "";
    private String resources = "";
    private String redirectUrl = "";
    private Integer accessTokenValiditySeconds = 60 * 15;
    private Integer refreshTokenValiditySeconds = 60 * 30;

    @Override
    public String getClientId() {
        return this.client;
    }

    @Override
    public Set<String> getResourceIds() {
        return Stream.of(resources.split("[|]")).collect(Collectors.toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return StringUtils.isNotEmpty(this.secret);
    }

    @Override
    public String getClientSecret() {
        return this.secret;
    }

    @Override
    public boolean isScoped() {
        return StringUtils.isNotEmpty(this.scope);
    }

    @Override
    public Set<String> getScope() {
        return Stream.of(scope.split("[|]")).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return Stream.of(grantType.split("[|]")).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return Stream.of(redirectUrl.split("[|]")).collect(Collectors.toSet());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
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
