package com.api.bootrestbook.entities;

import jakarta.persistence.Column;
// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    @OneToOne
    private Author author;
    private String title;
    
    public Book(int id, Author author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", author=" + author + ", title=" + title + "]";
    }

    public Book() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
}
