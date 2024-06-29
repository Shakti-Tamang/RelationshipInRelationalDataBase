package com.nextstep.project.service;

import com.nextstep.project.Repositpry.UserRepo;
import com.nextstep.project.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveTeacher(UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
   userRepo.save(userModel);
    }

}
