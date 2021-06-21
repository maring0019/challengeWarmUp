/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author  mariela
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String titulo;
    private String contenido;
    private String imagen;
    private String categoria;
    private String fecha_creacion;
    private int id_usuario_creador;
    
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    public Post(String titulo, String contenido, String imagen, String categoria, String fecha_creacion, int id_usuario_creador) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagen = imagen;
        this.categoria = categoria;
        this.fecha_creacion = fecha_creacion;
        this.id_usuario_creador = id_usuario_creador;
    }

    public int getId() {
        return id;
    }

}
