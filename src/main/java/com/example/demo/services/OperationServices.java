/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;


import com.example.demo.model.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PostRepository;

/**
 *
 * @author  mariela
 */
@Service
public class OperationServices {
    @Autowired
    private PostRepository postRepository;
    
    /* 
    Devuelve la lista de todos los posts. REORDENAR
    Deberá mostrar un listado de posts, ordenados por fecha de creación, en forma
    descendente. Este listado deberá mostrar solamente los campos ID, título, imagen,
    categoría y fecha de creación.
    */
    public List<Post> getPosts(){
    
        return postRepository.findAll();
    
    }
    /* 
    Devuelve el post buscado con el id recibido. REORDENAR
    Deberá buscar un post cuyo id sea el especificado en el parámetro :id. Si existe, devolver
    sus detalles, caso contrario devolver un mensaje de error
    */
    public Post getPost(int id){

        Optional<Post> post= postRepository.findById(id);
    
        return post.get();   
          
    }

    /* 
    Devuelve los posts que coinciden con el nombre recibido.
    */
    public List<Post> getBuscarPost(String titulo){
  
        List<Post> post = postRepository.findByTitulo(titulo);
        return post;     
    }
    
    /* 
    Devuelve los posts que coinciden con la categoria recibida.
    */
    public List<Post> getBuscarPostCategoria(String categoria){ 
  
        List<Post> post = postRepository.findByCategoria(categoria);
        return post;     
    }
    
    /* 
    Elimina el post que conincide con el id recibido.
    */
    
    public String eliminarPost(int id) {
        try {

            Optional<Post> post = postRepository.findById(id);
            postRepository.delete(post.get());

            return "Exito";
            
        } catch (Exception e) {
            
            return "Error"; 
        
        }
    }
    
    /* 
    Modifica el nombre del categoria que coincide con el id recibido.
    */
    
    public String modificarPost(String nombre, int id) {
        try {

            Optional<Post> post = postRepository.findById(id);
            post.get().setTitulo(nombre);
            postRepository.save(post.get());

            return "Exito";
            
        } catch (Exception e) {
        
            return "Error";
        
        }
    }
    
    
    
    
        
    
    
}
