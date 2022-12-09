package com.example.shopping_backend.controller;

import com.example.shopping_backend.dao.ShoppingDao;
import com.example.shopping_backend.dao.UserDao;
import com.example.shopping_backend.model.Shopping;
import com.example.shopping_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
    public String addProduct(@RequestBody Shopping sh){
        dao.save(sh);
        return "{\"status\":\"success\"}";}

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/view")
    public List<Shopping> viewProduct(){
        return (List<Shopping>) dao.findAll();}

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Shopping> searchProduct(@RequestBody Shopping s){
        return (List<Shopping>) dao.searchProduct(s.getName());
        }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/usersearch",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> userSearch(@RequestBody User u){
        System.out.println(u.getEmail());
        System.out.println(u.getPassword());
        List<User> checkData = (List<User>) udao.searchUser(u.getEmail(),u.getPassword());
        System.out.println(checkData);
        HashMap<String,String> hashmap= new HashMap<>();
        if(checkData.size()==0){
            hashmap.put("status","failed");
            hashmap.put("message","user does not exist");
        }
        else{
            int id=checkData.get(0).getId();
            hashmap.put("userid",String.valueOf(id));
            hashmap.put("status","success");
            hashmap.put("message","user exists");
        }
        return hashmap;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userbyid",consumes = "application/json",produces = "application/json")
    public List<User> userGetById(@RequestBody User u){
       return (List<User>) udao.getUser(u.getId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/user",consumes = "application/json",produces = "application/json")
    public String userCheck(@RequestBody User u){
        udao.save(u);
        return "{\"status\":\"success\"}";
    }
}
