package com.descomplica.FrameBlog.services.impl;

import com.descomplica.FrameBlog.models.User;
import com.descomplica.FrameBlog.repositories.UserRepository;
import com.descomplica.FrameBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user) {
        User existingUser = userRepository.findByUsername(user.getNome());
        if(Objects.nonNull(existingUser)){
            throw new RuntimeException("Usuário já existe!!!");
        }

        User entity = new User(user.getUserId(), user.getNome(), user.getEmail(),user.getSenha(), user.getRole());

        User newUser = userRepository.save(entity);
        return new User(newUser.getUserId(), newUser.getNome(), newUser.getEmail(),newUser.getSenha(), newUser.getRole());
    }

}
