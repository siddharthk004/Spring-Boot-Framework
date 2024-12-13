package com.smart.smartcontactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smart.smartcontactmanager.entities.user;

public interface userRepo extends JpaRepository<user, Integer>{

}
