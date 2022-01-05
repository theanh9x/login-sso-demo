package com.accesstrade.authz.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
public class AuthzApi {
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @RequestMapping("/sso/user")
    @SuppressWarnings("unchecked")
    public Map<String, Object> user(Principal principal) {
        Map<String, Object> attributes = null;
        if (principal != null) {
            Authentication authToken = SecurityContextHolder.getContext().getAuthentication();
            if (authToken instanceof OAuth2AuthenticationToken) {
                attributes = ((OAuth2AuthenticationToken) authToken).getPrincipal().getAttributes();
            } else if (authToken instanceof JwtAuthenticationToken) {
                attributes = ((JwtAuthenticationToken) authToken).getTokenAttributes();
            }
        }
        return attributes;
    }
}
