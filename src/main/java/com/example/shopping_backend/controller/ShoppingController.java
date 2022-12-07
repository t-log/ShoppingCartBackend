package com.example.shopping_backend.controller;

import com.example.shopping_backend.dao.ShoppingDao;
import com.example.shopping_backend.dao.UserDao;
import com.example.shopping_backend.model.Shopping;
import com.example.shopping_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingController {
    @Autowired
    private ShoppingDao dao;
    @Autowired
    private UserDao udao;


    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String homePage(){return "Welcome to shopping home page";}

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String addProduct(@RequestBody Shopping sh){return "sample";}

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/view",consumes = "application/json",produces = "application/json")
    public String viewProduct(@RequestBody Shopping sh){return "sample";}

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public String searchProduct(@RequestBody Shopping sh){return "sample";}

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/user",consumes = "application/json",produces = "application/json")
    public String userCheck(@RequestBody User u){
        udao.save(u);
//        return "{\"status\":\"success\"}";
    }
}
