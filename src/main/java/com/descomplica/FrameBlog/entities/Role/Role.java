package com.descomplica.FrameBlog.entities.Role;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name ="tb_roles")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum Values {

        ADMIN(1L),
        BASIC(2L);

        long id;

        Values(long Id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }
    }

}
