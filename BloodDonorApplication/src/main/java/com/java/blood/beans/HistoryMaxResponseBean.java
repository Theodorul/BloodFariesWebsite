package com.java.blood.beans;

import java.sql.Date;

public class HistoryMaxResponseBean {

    private String name;

    private String email;

    private String blood_type;

    private String location;

    private Date donations_date;

    private String donation_results;

    private String comments;

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDonations_date() {
        return donations_date;
    }

    public void setDonations_date(Date donations_date) {
        this.donations_date = donations_date;
    }

    public String getDonation_results() {
        return donation_results;
    }

    public void setDonation_results(String donation_results) {
        this.donation_results = donation_results;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
