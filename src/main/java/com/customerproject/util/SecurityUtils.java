package com.customerproject.util;

import java.util.ArrayList;
import java.util.List;

import com.customerproject.security.CustomUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
	public static CustomUser getPrincipal() {
        return (CustomUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities(){
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		for (GrantedAuthority authority : authorities) {
			results.add(authority.getAuthority());
		}
		return results;
	}
}
