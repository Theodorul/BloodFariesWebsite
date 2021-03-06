package com.java.blood.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "dd")
public class UsersEntity {
    private int userId;
    private String name;
    private String email;
    private String location;
    private int age;
    private int weightInKg;
    private Integer pulse;
    private Integer tension;
    private Integer diseases;
    private String gender;
    private Integer underTreatment;
    private String pass;
    private String blood_type;
    private Integer role;
    private String hospital;

    @Basic
    @Column(name = "hospital" , length = 20)
    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Column(name = "role_dummy" , length = 20)
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "blood_type" , length = 20)
    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    @Basic
    @Column(name = "password" , length = 50)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 30)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "weight_in_kg", nullable = false)
    public int getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(int weightInKg) {
        this.weightInKg = weightInKg;
    }

    @Basic
    @Column(name = "pulse", nullable = true)
    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    @Basic
    @Column(name = "tension", nullable = true)
    public Integer getTension() {
        return tension;
    }

    public void setTension(Integer tension) {
        this.tension = tension;
    }

    @Basic
    @Column(name = "diseases", nullable = true)
    public Integer getDiseases() {
        return diseases;
    }

    public void setDiseases(Integer diseases) {
        this.diseases = diseases;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 10)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "under_treatment", nullable = true)
    public Integer getUnderTreatment() {
        return underTreatment;
    }

    public void setUnderTreatment(Integer underTreatment) {
        this.underTreatment = underTreatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return userId == that.userId &&
                age == that.age &&
                weightInKg == that.weightInKg &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(location, that.location) &&
                Objects.equals(pulse, that.pulse) &&
                Objects.equals(tension, that.tension) &&
                Objects.equals(diseases, that.diseases) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(underTreatment, that.underTreatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, location, age, weightInKg, pulse, tension, diseases, gender, underTreatment);
    }
}
