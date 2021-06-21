package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class InitElement {

   
    
    @JsonProperty("post.titulo")
    private String postTitulo;
    
    @JsonProperty("post.contenido")
    private String postContenido;
    
    @JsonProperty("post.imagen")
    private String postImagen;
     
    @JsonProperty("post.categoria")
    private String postCategoria;
    
    @JsonProperty("post.fechaCreacion")
    private String postFechaCreacion;
      
    @JsonProperty("post.idUsuarioCreador")
    private int idUsuarioCreador;
  
}
