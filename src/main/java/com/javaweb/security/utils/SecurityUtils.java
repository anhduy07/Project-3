package com.javaweb.security.utils;

import com.javaweb.model.dto.MyUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {

    public static MyUserDetail getPrincipal() {
        return (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static List<String> getAuthorities() {
        List<String> results = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities() != null) {
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                results.add(authority.getAuthority());
            }
        }
        return results;
    }
}
