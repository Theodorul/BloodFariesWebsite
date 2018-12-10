package com.java.blood.controller;

import com.java.blood.beans.DoctorBean;
import com.java.blood.beans.LoginBean;
import com.java.blood.beans.MailBean;
import com.java.blood.configuration.Sender;
import com.java.blood.model.UsersEntity;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private Sender mailService;


    @RequestMapping(value = "/add/donor", method = RequestMethod.PUT)
    public String addDonor(@RequestBody UsersEntity usersEntity) throws NoSuchAlgorithmException {
        if(usersRepository.getAllEmails().contains(usersEntity.getEmail())){
            return "Email is already taken";
        }
        else{
            return usersService.addDonor(usersEntity);
        }
    }

    @RequestMapping(value = "/add/doctor", method = RequestMethod.PUT)
    public void addDoctor(@RequestBody DoctorBean doctorBean) throws NoSuchAlgorithmException {
        usersService.addDoctor(doctorBean);
    }

    @RequestMapping(value = "/delete/user/{email}", method = RequestMethod.DELETE)
    public String deleteDoctor(@PathVariable("email") String name){
        return usersService.deleteUser(name);
    }

    @RequestMapping(value = "/getRoleForUser/{email}", method = RequestMethod.GET)
    public List<String> getRoleForUser(@PathVariable("email") String name){
        return usersRepository.getRoleForUser(name);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLoginResponse(@RequestBody LoginBean loginBean) throws NoSuchAlgorithmException {
        return usersService.login(loginBean);
    }
    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String sendMail(@RequestBody MailBean mailBean) {
        mailService.send(mailBean.getTo(),mailBean.getSubject(),mailBean.getText());
        return "Mail successfully sent";
    }
    @RequestMapping(value = "/getAllUsersByRole/{role}", method = RequestMethod.GET)
    public List<UsersEntity> getLoginResponse(@PathVariable("role") Integer role) {
        return usersService.getAllUsersByRole(role);
    }
}
