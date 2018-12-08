package com.java.blood.impl;

import com.java.blood.beans.DoctorBean;
import com.java.blood.beans.LoginBean;
import com.java.blood.model.UsersEntity;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UsersService")
public class UsersServiceImpl implements UsersService {

    //1-Donator
    //2-Doctor
    //3-Operator Transfuzii
    //4-Administrator

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addDonor(UsersEntity usersEntity) {
        usersRepository.addDonator(usersEntity.getName(), usersEntity.getEmail(),
                usersEntity.getLocation(), usersEntity.getAge(), usersEntity.getWeightInKg(),
                usersEntity.getPulse(),usersEntity.getTension(),usersEntity.getDiseases(),
                usersEntity.getGender(), usersEntity.getPass());
        usersRepository.addRoleOnDonator(usersRepository.getIdFromName(usersEntity.getEmail()), 1);
    }

    @Override
    public void addDoctor(DoctorBean doctorBean) {
        usersRepository.addDoctor(doctorBean.getName(), doctorBean.getEmail(),
                doctorBean.getLocation(), doctorBean.getPass());
        usersRepository.addRoleOnDonator(usersRepository.getIdFromName(doctorBean.getEmail()), 2);
    }

    @Override
    public void deleteUser(String email) {
        usersRepository.deleteUser(email);
        usersRepository.deleteRoleFromUsers();
    }

    @Override
    public String login(LoginBean loginBean) {
        List<String> allEmails = usersRepository.getAllEmails();
        String pass = usersRepository.getPassForUser(loginBean.getEmail());
        if(!allEmails.contains(loginBean.getEmail())){
            return "Not in database";
        }
        else{
            if(loginBean.getPass().equals(pass)){
                return "Succesfully logged in";
            }
            else{
                return "Password does not match with the email";
            }
        }
    }
}
