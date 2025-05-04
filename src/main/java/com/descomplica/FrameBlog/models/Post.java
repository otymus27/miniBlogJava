package com.descomplica.FrameBlog.models;

import com.descomplica.FrameBlog.entities.Usuario.Usuario;
import com.descomplica.FrameBlog.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Post")


public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //gera o id automaticamente

    private Long postId;
    private String titulo;
    private String conteudo;
    private Date data;

    @ManyToOne
    private Usuario userId;

    public Post() {
    }

    public Post(final Long postId, final String titulo, final String conteudo, final Date data, final Usuario userId) {
        this.postId = postId;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
        this.userId = userId;
    }

    // Getters e setters

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUserId() {
        return userId;
    }

    public void setUserId(Usuario userId) {
        this.userId = userId;
    }
}
