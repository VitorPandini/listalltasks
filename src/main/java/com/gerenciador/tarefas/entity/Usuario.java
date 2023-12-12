package com.gerenciador.tarefas.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true,length = 50)
    private String username;

    @Column(length = 50)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"),inverseJoinColumns = @JoinColumn(name = "role_id"),uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id","role_id"}))
    private List<Role>roles;
}
