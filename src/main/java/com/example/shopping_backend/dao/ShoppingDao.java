package com.example.shopping_backend.dao;

import com.example.shopping_backend.model.Shopping;
import com.example.shopping_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingDao extends CrudRepository<Shopping,Integer>
{
    @Query(value = "SELECT `id`, `category`, `description`, `name`, `price` FROM `products` WHERE `name`=:name",nativeQuery = true)
    List<Shopping> searchProduct(@Param("name") String name);
}
