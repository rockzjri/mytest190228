package cn.itrock.security.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        List<GrantedAuthority> authorityList = new ArrayList<>();

        if ("user".equals(s)) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

            User user = new User("user", "123456", authorityList);

            return user;
        }

        if ("admin".equals(s)) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            User user = new User("admin", "{noop}123456", authorityList);

            return user;
        }

        return null;

    }
}
