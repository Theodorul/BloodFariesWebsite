package com.java.blood.services;

import com.java.blood.beans.DoctorBean;
import com.java.blood.beans.LoginBean;
import com.java.blood.model.UsersEntity;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UsersService {

    String addDonor(UsersEntity usersEntity) throws NoSuchAlgorithmException;

    void addDoctor(DoctorBean doctorBean) throws NoSuchAlgorithmException;

    String deleteUser(String email);

    String login(LoginBean loginBean) throws NoSuchAlgorithmException;

    String hashPassword(String password) throws NoSuchAlgorithmException;

    List<UsersEntity> getAllUsersByRole(Integer role);

    String check(String email);
}
