package com.smart.smartcontactmanager.dao;

// import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.smartcontactmanager.entities.user;

public interface userRepo extends JpaRepository<user, Integer>{
    @Query("select u from user u where u.email = :email")
    public user getUserByUserName(@Param("email") String email);
}
