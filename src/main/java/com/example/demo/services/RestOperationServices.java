package com.example.demo.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Post;

import com.example.demo.repository.PostRepository;


@Service
public class RestOperationServices {
    

    @Autowired
    private PostRepository postRepository;
    
    
    public String nuevoPost(String titulo, String contenido, String imagen, String categoria, String fecha_creacion, int id_usuario_creador){
        try {

            
            Post post = new Post(titulo, contenido, imagen, categoria, fecha_creacion, id_usuario_creador);
            postRepository.save(post);
            
            return "Exito, post creado -> id: " + post.getId();
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            
            return "Error - El post no pudo ser creado.";
        
        }
    }

   
    
    
}
