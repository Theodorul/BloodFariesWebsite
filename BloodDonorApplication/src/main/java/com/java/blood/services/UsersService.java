package com.java.blood.services;

import com.java.blood.beans.DoctorBean;
import com.java.blood.model.UsersEntity;

public interface UsersService {

    void addDonor(UsersEntity usersEntity);

    void addDoctor(DoctorBean doctorBean);

    void deleteUser(String name);
}
