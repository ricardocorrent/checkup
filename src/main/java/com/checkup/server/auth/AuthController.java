package com.checkup.server.auth;

import com.checkup.server.security.AccountCredentialsVO;
import com.checkup.server.security.jwt.JwtTokenProvider;
import com.checkup.user.User;
import com.checkup.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;

    private final UserRepository repository;

    public AuthController(final AuthenticationManager authenticationManager,
                          final JwtTokenProvider tokenProvider,
                          final UserRepository repository) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.repository = repository;
    }

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/signin", produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {
        try {
            final String username = data.getUserName();
            final String password = data.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            final User user = repository.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }

            final String token = tokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (final AuthenticationException error) {
            throw new BadCredentialsException("Invalid username/password supplied!", error);
        }
    }
}
