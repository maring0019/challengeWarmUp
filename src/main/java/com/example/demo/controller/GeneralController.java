/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;


import com.example.demo.model.Post;

import com.example.demo.services.OperationServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mariela
 */
@Controller

public class GeneralController {
    @Autowired
    private OperationServices operationServices;
   
    /* 
    Lista todos los posts existentes.
    */
 
    @GetMapping("/posts")
    public String listarTodosPosts(Model model) {
        try {
            
            List<Post> posts= operationServices.getPosts();
            model.addAttribute("posts", posts);
            
            return "listarPosts";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "No se pudo listar los posts.");
            
            return "error";
        }       
    }
    
     /* 
    Devuelve el detalle del post dado el id correspondiente.
    */
    
    @GetMapping("/posts/{id}")
    public String buscarPost(@PathVariable int id, Model model) {
        try {
            
            Post post = operationServices.getPost(id);

            model.addAttribute("post", post);

            return "post";
            
        } catch (Exception e) {

            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "El post no existe.");
            
            return "error";
        }
    }
   
    /* 
    Lista el post que tiene el nombre dado como parametro.
    */
    @GetMapping("/posts/{nombre}")
    public String listarPosts(@PathVariable String nombre, Model model) {
        try {

            
            List<Post> posts= operationServices.getBuscarPost(nombre);
      
    
            model.addAttribute("posts", posts);
            model.addAttribute("nombre", nombre);

            return "listarPostsNombre";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "No existen posts con ese nombre.");
            
            return "error";
        }       
    }
    
    /* 
    Lista el post que tiene el nombre dado como parametro.
    */
    @GetMapping("/posts/{categoria}")
    public String listarPostsCatagoria(@PathVariable String nombre, Model model) {
        try {

            
            List<Post> posts= operationServices.getBuscarPost(nombre);
      
    
            model.addAttribute("posts", posts);
            model.addAttribute("nombre", nombre);

            return "listarPostsNombre";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "No existen posts con ese nombre.");
            
            return "error";
        }       
    }
    
   /* 
     Elimina el post dado el id como parametro.
    */
    @GetMapping("/eliminar/posts")
    public String eliminarPost(@RequestParam(name = "id") int id, Model model) {
         try {
            
            model.addAttribute("mensaje", operationServices.eliminarPost(id));
            
            return "eliminarPost";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "El post no existe.");
            
            return "error";
        }       
    }
   
    /* 
     Modifica el nombre del post dado el id como parametro.
    */
    @GetMapping("/posts/modificar")
    public String modificarPost(@RequestParam(name = "id") int id,
                                @RequestParam(name = "nombre") String nombre, 
                                Model model) {
        try {
            
            model.addAttribute("mensaje", operationServices.modificarPost(nombre, id));
            model.addAttribute("post", operationServices.getPost(id));
            
            return "modificarPost";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "El post no existe.");
            
            return "error";
        }       
    }
    
}
