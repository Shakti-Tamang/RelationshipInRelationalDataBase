package com.nextstep.project.service;

import com.nextstep.project.Repositpry.UserRepo;
import com.nextstep.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        this is same procees for log in by user
        UserModel user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return new UserDetailInfo(user);
    }

    public String findUsernameByEmail(String email) throws UsernameNotFoundException {
//        it helps to find user according to email
        UserModel user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

//        if user is found it helps to send username according to email
        return user.getUsername();
    }
}
