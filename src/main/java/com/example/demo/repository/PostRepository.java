/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  mariela
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
     public List<Post> findByTitulo(String titulo);
     public List<Post> findByCategoria(String categoria);
}
