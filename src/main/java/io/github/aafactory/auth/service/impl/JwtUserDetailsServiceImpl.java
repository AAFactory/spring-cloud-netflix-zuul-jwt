package io.github.aafactory.auth.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.aafactory.auth.service.MultyUserDetailsService;
import io.github.aafactory.auth.user.JwtUserFactory;
import io.github.aafactory.domain.User;
import io.github.aafactory.domain.UserExample;
import io.github.aafactory.mapper.UserMapper;

@Service
public class JwtUserDetailsServiceImpl implements MultyUserDetailsService {

	@Autowired
    private  UserMapper userMapper;
	
    /**
     * @param username
     * @return UserDetail
     * @throws UsernameNotFoundException not found user
     */
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            userDetails = this.loadUserByEmail(username);
        } catch (UsernameNotFoundException e1) {
            try {
                userDetails = this.loadUserByPhone(username);
            } catch (UsernameNotFoundException e2) {
                throw e2;
            }
        }

        return userDetails;
    }
    
    @Override
    public UserDetails loadUserByEmail(String var1) throws UsernameNotFoundException {
    	throw new UsernameNotFoundException("test thrown...");
    }

    @Override
    public UserDetails loadUserByPhone (String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andPhoneEqualTo(phone);

        List<User> tmp = userMapper.selectByExample(userExample);
        LinkedList<User> users = new LinkedList<User>(tmp);

        User user = null;
        try {
            user = users.pop();
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException("not found user by phone " + phone);
        }

        return JwtUserFactory.create(user);
    }
}
