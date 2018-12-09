package com.java.blood.impl;

import com.java.blood.beans.DoctorBean;
import com.java.blood.beans.LoginBean;
import com.java.blood.model.UsersEntity;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    public String addDonor(UsersEntity usersEntity) throws NoSuchAlgorithmException {
        usersRepository.addDonator(usersEntity.getName(), usersEntity.getEmail(),
                usersEntity.getLocation(), usersEntity.getAge(), usersEntity.getWeightInKg(),
                usersEntity.getPulse(),usersEntity.getTension(),usersEntity.getDiseases(),
                usersEntity.getGender(), hashPassword(usersEntity.getPass()), usersEntity.getBlood_type(),
                usersEntity.getHospital());
        usersRepository.addRoleOnDonator(usersRepository.getIdFromName(usersEntity.getEmail()), usersEntity.getRole());
        return "User added successfully";
    }

    @Override
    public void addDoctor(DoctorBean doctorBean) throws NoSuchAlgorithmException {
        usersRepository.addDoctor(doctorBean.getName(), doctorBean.getEmail(),
                doctorBean.getLocation(), hashPassword(doctorBean.getPass()));
        usersRepository.addRoleOnDonator(usersRepository.getIdFromName(doctorBean.getEmail()), 2);
    }

    @Override
    public String deleteUser(String email) {
        usersRepository.deleteUser(email);
        usersRepository.deleteRoleFromUsers();
        return "User deleted successfully";
    }

    @Override
    public String login(LoginBean loginBean) throws NoSuchAlgorithmException {
        List<String> allEmails = usersRepository.getAllEmails();
        String pass = usersRepository.getPassForUser(loginBean.getEmail());
        Integer role = usersRepository.getRoleForUserAsInt(loginBean.getEmail()).get(0);
        if(!allEmails.contains(loginBean.getEmail())){
            return "Not in database";
        }
        else{
            if(role != loginBean.getRole()){
                return "Wrong user";
            }
            else if(hashPassword(loginBean.getPass()).equals(pass)){
                return "Succesfully logged in";
            }
            else{
                return "Password does not match with the email";
            }
        }
    }

    @Override
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        String plaintext = password;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        return hashtext;
    }
}
