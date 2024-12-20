package com.smart.smartcontactmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.smartcontactmanager.entities.contact;

public interface contactRepo extends JpaRepository<contact, Integer> {
    // pegination ...

    @Query("from contact as d where c.user.id =:userId")
    public List<contact> findContactByUser(@Param("userId")int userId);
}
