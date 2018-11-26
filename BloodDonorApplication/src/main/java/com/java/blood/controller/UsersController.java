package com.java.blood.controller;

import com.java.blood.beans.DoctorBean;
import com.java.blood.model.UsersEntity;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/add/donor", method = RequestMethod.PUT)
    public void addDonor(@RequestBody UsersEntity usersEntity){
        usersService.addDonor(usersEntity);
    }

    @RequestMapping(value = "/add/doctor", method = RequestMethod.PUT)
    public void addDoctor(@RequestBody DoctorBean doctorBean){
        usersService.addDoctor(doctorBean);
    }
    @RequestMapping(value = "/delete/user/{name}", method = RequestMethod.DELETE)
    public void addDoctor(@PathVariable("name") String name){
        usersService.deleteUser(name);
    }
}
