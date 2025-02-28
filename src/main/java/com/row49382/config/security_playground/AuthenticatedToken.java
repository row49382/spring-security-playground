package com.row49382.config.security_playground;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticatedToken extends AbstractAuthenticationToken {
    public AuthenticatedToken() {
        super(AuthorityUtils.NO_AUTHORITIES);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        throw new RuntimeException("Can't change this after being set");
    }
}
