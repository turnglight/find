package find.cloud.gateway.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author turnglight
 * @description 认证TOKEN
 * @date 2021/12/27
 */
public class AuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String tenant;

    private String host;

    public AuthenticationToken(Object principal, Object credentials, String tenant, String host) {
        super(principal, credentials);
        this.tenant = tenant;
        this.host = host;
    }

    public AuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public AuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}

