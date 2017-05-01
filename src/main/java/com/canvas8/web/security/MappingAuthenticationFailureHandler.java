package com.canvas8.web.security;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MappingAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private String defaultFailureUrl;
    private static final Map<Class, String> execptionMap;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    static {
        execptionMap = new HashMap<>();
        execptionMap.put(AccountExpiredException.class, "account.expired");
        execptionMap.put(AuthenticationCredentialsNotFoundException.class, "authentication.credentials.notfound");
        execptionMap.put(AuthenticationServiceException.class, "authentication.service");
        execptionMap.put(BadCredentialsException.class, "badcredentials");
        execptionMap.put(CredentialsExpiredException.class, "credentials.expired");
        execptionMap.put(DisabledException.class, "disabled");
        execptionMap.put(InsufficientAuthenticationException.class, "insufficient.authentication");
        execptionMap.put(InternalAuthenticationServiceException.class, "internal.authentication.service");
        execptionMap.put(LockedException.class, "locked");
        execptionMap.put(ProviderNotFoundException.class, "provider.notfound");
        execptionMap.put(Exception.class, "error");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String value = execptionMap.get(exception.getClass());

        if (value == null) {
            value = execptionMap.get(Exception.class);
        }

        String redirectUrl = this.defaultFailureUrl + value;
        redirectStrategy.sendRedirect(request, response, redirectUrl);
    }

    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }
}
