package com.api.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.bootrestbook.dao.BookRepositary;
import com.api.bootrestbook.entities.Book;

// import dao.BookRepositary;

@Component
public class BookService {
    @Autowired
    private BookRepositary bookrepo;

    // private static List<Book> list = new ArrayList<>();
    
    // static {
    //     list.add(new Book(1,"java dev","ABC"));
    //     list.add(new Book(2,"TS dev","MNQ"));
    //     list.add(new Book(3,"c dev","LMN"));
    // }

    // get all books
    public List<Book> getAllBooks()
    {
        List<Book> list = (List<Book>)this.bookrepo.findAll();
        return list;
    }

    // get single Book by id 
    public Book getBookById(int id) {
        
        Book book = null;
        try {
          //  book = list.stream().filter(e->e.getId() == id).findFirst().get();
           this.bookrepo.findById(id);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return book;
    }
    
    //adding the book
    public Book AddBook(Book b) {
        // list.add(b);
        Book result = bookrepo.save(b);
        return result;
    }

    // delete the book
    public void DeleteBook(int id) {
        //  list.stream().filter(book->book.getId()!=id 
        //  {
        //     if(book.getId() != id) {
        //         return true;
        //     } else {
        //         return false;
        //     }
        //  }
        //  ).collect(Collectors.toList());
            bookrepo.deleteById(id);
    }

    // update the book
    public void updateBook(Book book,int id) {
        // list = list.stream().map(b-> {
        //     if(b.getId() == id) {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
        
        book.setId(id);
        bookrepo.save(book);
    }

}
