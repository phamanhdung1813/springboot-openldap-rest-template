package com.anhdungpham.security_app.service;

import com.anhdungpham.security_app.entity.AuthorizationEntity;
import com.anhdungpham.security_app.entity.UserEntity;
import com.anhdungpham.security_app.repository.AuthorizationRepository;
import com.anhdungpham.security_app.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthorizationRepository authorizationRepository;

    public CustomUserDetailsService(UserRepository userRepository, AuthorizationRepository authorizationRepository) {
        super();
        this.userRepository = userRepository;
        this.authorizationRepository = authorizationRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (null == userEntity) {
            throw new UsernameNotFoundException("Cannot find username: " + username);
        }
        List<AuthorizationEntity> roles = authorizationRepository.findByUsername(username);
        return new UserPrincipal(userEntity, roles);
    }
}
