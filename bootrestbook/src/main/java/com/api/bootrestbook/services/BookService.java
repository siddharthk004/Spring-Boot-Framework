package com.api.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.bootrestbook.entities.Book;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();
    
    static {
        list.add(new Book(1,"java dev","ABC"));
        list.add(new Book(2,"TS dev","MNQ"));
        list.add(new Book(3,"c dev","LMN"));
    }

    // get all books
    public List<Book> getAllBooks()
    {
        return list;
    }

    // get single Book by id 
    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e->e.getId() == id).findFirst().get();
        return book;
    }
}
