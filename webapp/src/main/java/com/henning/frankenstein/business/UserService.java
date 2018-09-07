package com.henning.frankenstein.business;

import com.henning.frankenstein.domain.user.User;
import com.henning.frankenstein.domain.user.UserEntity;
import com.henning.frankenstein.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User loadUserByUsername(String name) throws UsernameNotFoundException {
        //UserEntity userEntity = userRepository.findByUserName(name).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s does not exist!", name)));
        List<UserEntity> userEntity = userRepository.findById(1);
        return new User(userEntity.get(0));
    }
}
