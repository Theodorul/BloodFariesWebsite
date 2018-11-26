package com.java.blood.impl;

import com.java.blood.beans.DoctorBean;
import com.java.blood.model.UsersEntity;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                usersEntity.getGender());
        usersRepository.addRoleOnDonator(usersRepository.getIdFromName(usersEntity.getName()), 1);
    }

    @Override
    public void addDoctor(DoctorBean doctorBean) {
        usersRepository.addDoctor(doctorBean.getName(), doctorBean.getEmail(),
                doctorBean.getLocation());
        usersRepository.addRoleOnDonator(usersRepository.getIdFromName(doctorBean.getName()), 2);
    }

    @Override
    public void deleteUser(String name) {
        usersRepository.deleteUser(name);
    }

}
