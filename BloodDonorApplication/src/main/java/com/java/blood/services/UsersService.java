package com.java.blood.services;

import com.java.blood.beans.DoctorBean;
import com.java.blood.beans.LoginBean;
import com.java.blood.model.UsersEntity;

import java.security.NoSuchAlgorithmException;

public interface UsersService {

    void addDonor(UsersEntity usersEntity) throws NoSuchAlgorithmException;

    void addDoctor(DoctorBean doctorBean) throws NoSuchAlgorithmException;

    void deleteUser(String email);

    String login(LoginBean loginBean) throws NoSuchAlgorithmException;

    String hashPassword(String password) throws NoSuchAlgorithmException;
}
