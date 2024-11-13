package com.jpa.test.entities;

// import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// @SpringBootApplication(scanBasePackages = "com.jpa.test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private String status;

    public User() {
        super();
        // ToDo
    }
    
    public User(int id,String name,String city,String status) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.status = status;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "User [id = "+id+",name = "+name+",city = "+city+",status = "+status+" ]";
    }
}
