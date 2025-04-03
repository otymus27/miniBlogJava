package com.descomplica.FrameBlog.models;


import com.descomplica.FrameBlog.enums.RoleEnum;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;
import com.descomplica.FrameBlog.deserializers.CustomAuthorityDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name="User")

public class User implements UserDetails {

    //TODO adicionar o UserDetails
    //implements UserDetails

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //gera o id automaticamente

    private Long userId;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private RoleEnum role;

    //construtor padrão
    public User() {

    }

    //Construtor personalizado


    public User(final Long userId, final String nome, final String login, final String email, final String senha, final RoleEnum role) {
        this.userId = userId;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    // Getters e setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == RoleEnum.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        return List.of(
                new SimpleGrantedAuthority("ROLE_USER")
        );
    }

    public String getSenha() {
        return this.senha;
    }

    public String getLogin() {
        return this.login;
    }

    @Override
    public String getUsername() {
        return this.login; // Retorna o login do usuário
    }

    @Override
    public String getPassword() {
        return senha; // Retorna a senha do usuário
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
