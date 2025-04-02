package com.descomplica.FrameBlog.models;


import com.descomplica.FrameBlog.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name="User")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //gera o id automaticamente

    private Long userId;
    private String nome;
    private String email;
    private String senha;
    private RoleEnum role;

    //construtor padrão
    public User() {

    }

    //Construtor personalizado


    public User(final Long userId, final String nome, final String email, final String senha, final RoleEnum role) {
        this.userId = userId;
        this.nome = nome;
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

    public String getSenha() {
        return senha;
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
}
