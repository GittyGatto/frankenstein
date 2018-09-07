package com.henning.frankenstein.controllers.auth;


import com.henning.frankenstein.business.UserService;
import com.henning.frankenstein.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class LoginResource {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> login(
            @RequestBody() LoginRequest loginRequest, HttpServletRequest httpRequest) throws IOException {
        try {
            User user = userService.loadUserByUsername(loginRequest.userName);
            if (user.password.equals(loginRequest.password)) {
                ResponseEntity<User> ok = ResponseEntity.ok(user);
                return ok;
            } else
                return returnErrorResponse(httpRequest, null);
        } catch (Exception ex) {
            return returnErrorResponse(httpRequest, ex);
        }
    }

    private ResponseEntity<User> returnErrorResponse(HttpServletRequest httpRequest, Exception ex) {
        ResponseEntity<User> response = ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        return response;
    }
}
