package com.java.blood.controller;

import com.java.blood.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/allEmails", method = RequestMethod.GET)
    public List<String> getFoosBySimplePath() {
        return usersRepository.getAllEmails();
    }

}
