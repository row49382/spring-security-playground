package com.row49382.config.security_playground;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

public class SecretHeaderFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String secretHeaderValue = request.getHeader("secret-header");

        if (secretHeaderValue != null) {
            if (Objects.equals(secretHeaderValue, "my-precious")) {
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                context.setAuthentication(new AuthenticatedToken());
                SecurityContextHolder.setContext(context);
            } else {
                System.out.println("Wrong secret...");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        }

        filterChain.doFilter(request, response);
    }
}
