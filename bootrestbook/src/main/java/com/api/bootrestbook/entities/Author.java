package com.api.bootrestbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String FirstName;
    
    private String LastName;
    private String Language;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getLanguage() {
        return Language;
    }
    public void setLanguage(String language) {
        Language = language;
    }
    
    
}
