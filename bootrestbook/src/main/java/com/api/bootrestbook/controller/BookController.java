package com.api.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> list = this.bookservice.getAllBooks();
        if(list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book book = bookservice.getBookById(id);
        if(book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> AddBook(@RequestBody Book book) {
        
        try {
            Book b = this.bookservice.AddBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }  

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> DeleteBook(@PathVariable("id") int id) {
        try {
            this.bookservice.DeleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // update book handler
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id) {
        try {
            this.bookservice.updateBook(book,id);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } 
}
