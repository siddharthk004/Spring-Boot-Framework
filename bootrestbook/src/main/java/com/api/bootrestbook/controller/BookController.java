package com.api.bootrestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.bootrestbook.entities.Book;
import com.api.bootrestbook.services.BookService;

@RestController
// @Controller
public class BookController {

    @Autowired
    private BookService bookservice;

    // @RequestMapping(value="/books",method = RequestMethod.GET) 
    // @ResponseBody
    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookservice.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookservice.getBookById(id);
    }

}
