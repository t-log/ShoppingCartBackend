package com.example.shopping_backend.dao;

import com.example.shopping_backend.model.Shopping;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingDao extends CrudRepository<Shopping,Integer>
{

}
