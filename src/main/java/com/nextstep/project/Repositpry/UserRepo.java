package com.nextstep.project.Repositpry;

import com.nextstep.project.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {
    public UserModel findByUsername(String username);
    public UserModel findByEmail(String email);


}
