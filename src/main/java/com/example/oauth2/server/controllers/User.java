package com.example.oauth2.server.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
public class User {

    @GetMapping(value="/user")
    public Map<String, Object> user(@AuthenticationPrincipal Principal principal) {
        if (principal != null) {
            return Map.of("id", principal.getName(), "authorities", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        }
        return Map.of("id", "john", "authorities", List.of("read"));
    }
}
