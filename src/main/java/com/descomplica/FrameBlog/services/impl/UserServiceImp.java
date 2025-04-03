package com.descomplica.FrameBlog.services.impl;

import com.descomplica.FrameBlog.models.User;
import com.descomplica.FrameBlog.repositories.UserRepository;
import com.descomplica.FrameBlog.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(final User user) {
        User existingUser = userRepository.findByLogin(user.getLogin());
        if(Objects.nonNull(existingUser)){
            throw new RuntimeException("Usuário já existe!!!");
        }

        //TODO adicionar autenticação aqui fazemos a encriptação da senha usando hash
        String passwordHash = passwordEncoder.encode(user.getPassword());

        User entity = new User(user.getUserId(), user.getNome(), user.getLogin(), user.getEmail(),user.getSenha(), user.getRole());

        User newUser = userRepository.save(entity);
        return new User(newUser.getUserId(), newUser.getNome(), newUser.getLogin(), newUser.getEmail(),newUser.getSenha(), newUser.getRole());
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado")
        );
    }

    @Override
    public User update(Long id, User user) {
        User userUpdate = userRepository.findById(id).orElse(null);
        if(Objects.nonNull(userUpdate)){
            //TODO adicionar autenticação aqui fazemos a encriptação da senha usando hash
            String passwordHash = passwordEncoder.encode(user.getPassword());
            userUpdate.setNome(user.getNome());
            userUpdate.setLogin(user.getLogin());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setRole(user.getRole());
            userUpdate.setSenha(passwordHash);
            return userRepository.save(userUpdate);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
