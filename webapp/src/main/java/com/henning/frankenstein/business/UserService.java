package com.henning.frankenstein.business;

import com.henning.frankenstein.controllers.auth.LoginRequest;
import com.henning.frankenstein.domain.user.Role;
import com.henning.frankenstein.domain.user.User;
import com.henning.frankenstein.domain.user.UserEntity;
import com.henning.frankenstein.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User loadUserByUsername(String name) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(name).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s does not exist!", name)));
        return new User(userEntity);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User registerNewUserAccount(LoginRequest accountDto) {
        UserEntity user = new UserEntity();
        user.setUserName(accountDto.userName);
        user.setPassword(passwordEncoder.encode(accountDto.password));
        user.setRole(Role.ADMIN);
        UserEntity userEntity = userRepository.save(user);
        return new User(userEntity);
    }
}
