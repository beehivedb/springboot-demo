/**
 * File : UserController.java
 * Copyright (C) 2008-2018 www.oneapm.com . all rights reserved.
 */
package com.xudcloud.demo.controller;

import com.xudcloud.demo.domain.User;
import com.xudcloud.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author : Ron
 * date :2019/11/29:16:09
 * TODO
 * version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    @GetMapping("/users/add")
    public User putUser(@RequestParam String name) {
        User u = new User();
        u.setName(name);
        return repository.save(u);
    }
}
