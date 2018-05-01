package io.github.aafactory.auth.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.aafactory.auth.service.MultyUserDetailsService;

/**
 * Created by liumapp on 2/2/18.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 * the username here can be email and also can be phone number
 * that dependent on user type
 */
@Service
public class JwtUserDetailsServiceImpl implements MultyUserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDetails loadUserByEmail(String var1)
            throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDetails loadUserByPhone(String var1)
            throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}
