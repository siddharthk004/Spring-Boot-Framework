package com.api.bootrestbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.bootrestbook.entities.Book;

@Repository
public interface BookRepositary extends JpaRepository<Book,Integer>{
    public Book findById(int id);    
    
}
