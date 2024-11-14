package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jpa.test.entities.User;  // Keep only this import

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    
    public List<User> findByName(String name);
    
    public List<User> findByNameAndCity(String name,String city);
    
    @Query("select u FROM User u")
    public List<User> getAllUser();
    
    @Query("select u FROM User u WHERE u.name =:n")
    public List<User> getUserByName(@Param("n") String name);
    
    @Query(value="select * FROM user",nativeQuery = true)
    public List<User> getUsers();

}
