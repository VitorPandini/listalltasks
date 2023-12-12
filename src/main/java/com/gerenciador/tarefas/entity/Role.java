package com.gerenciador.tarefas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_role")

@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class Role implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true,length = 20)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

}
