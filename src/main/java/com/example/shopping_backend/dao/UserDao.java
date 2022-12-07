package com.example.shopping_backend.dao;
import com.example.shopping_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {
    @Query(value = "",nativeQuery = true)
    List<User> searchUser(@Param("username") String title);
}
