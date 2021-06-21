package com.example.demo.controller;

import com.example.demo.model.InitElement;
import com.example.demo.services.RestOperationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestParticularController {

    @Autowired
    private RestOperationServices restOperationServices;
 
    
    /* 
    Servicio Post para crear un nuevo post.
    */
   /*
    @PostMapping("/nuevoPost")
    public String nuevoPost(@RequestBody InitElement initElement) {
        
       // String mensaje = restOperationServices.nuevoPost(initElement.getPostImagen(), initElement.getPostNombre(), initElement.getPostEdad(), initElement.getPostPeso(), initElement.getPostHistoria()); 

        return mensaje;
    }

  
    */

}
