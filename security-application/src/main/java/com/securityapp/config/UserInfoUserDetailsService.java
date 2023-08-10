package com.securityapp.config;

import com.securityapp.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1000);
        userInfo.setName(username);
        userInfo.setEmail(username + "@example.com");
        userInfo.setRoles("ROLE_ADMIN");
        Optional<UserInfo> userInfoOptional = Optional.of(userInfo);
        return userInfoOptional.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
}
