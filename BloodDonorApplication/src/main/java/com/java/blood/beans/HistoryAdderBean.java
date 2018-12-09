package com.java.blood.beans;

import java.sql.Date;

public class HistoryAdderBean {

    private String email;

    private Date donation_date;

    private String donation_result;

    private String comments;

    private String beneficiary;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDonation_date() {
        return donation_date;
    }

    public void setDonation_date(Date donation_date) {
        this.donation_date = donation_date;
    }

    public String getDonation_result() {
        return donation_result;
    }

    public void setDonation_result(String donation_result) {
        this.donation_result = donation_result;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }
}
