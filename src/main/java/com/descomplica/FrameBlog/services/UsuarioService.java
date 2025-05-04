package com.descomplica.FrameBlog.services;

import com.descomplica.FrameBlog.entities.Usuario.Usuario;
import com.descomplica.FrameBlog.exceptions.DadosInvalidosException;
import com.descomplica.FrameBlog.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario) {
        // Adicione validações de negócio aqui, se necessário
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new DadosInvalidosException("O nome do login não pode ser vazio.");
        }
        return usuarioRepository.save(usuario);
    }

}
