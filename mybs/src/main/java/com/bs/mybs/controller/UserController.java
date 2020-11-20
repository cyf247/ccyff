package com.bs.mybs.controller;

import com.bs.mybs.model.User;
import com.bs.mybs.service.UserService;
import com.bs.mybs.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;
    @RequestMapping("/findAll.do")
    public List<User> findAll(){
        List<User> all = userservice.findAll();
        return all;
    }
    @PostMapping("/login.do")
    public Result login(@RequestBody(required = false) String username, String password){
        Result result = new Result();
        if (username.equals("admin")||password.equals("111111")){
            result.setCode(2000);
            return result;
        }else {
            result.setCode(4000);
            return result;
        }
    }
}
