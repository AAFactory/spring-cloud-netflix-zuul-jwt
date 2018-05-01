package io.github.aafactory.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MultyUserDetailsService extends UserDetailsService {

    UserDetails loadUserByEmail(String var1) throws UsernameNotFoundException;

    UserDetails loadUserByPhone(String var1) throws UsernameNotFoundException;
}
