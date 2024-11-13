package com.jpa.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jpa.test.entities.User;  // Keep only this import

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
