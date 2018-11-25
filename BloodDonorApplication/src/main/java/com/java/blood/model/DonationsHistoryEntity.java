package com.java.blood.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "donations_history", schema = "public", catalog = "dd")
@IdClass(DonationsHistoryEntityPK.class)
public class DonationsHistoryEntity {
    private int donationId;
    private int userId;
    private Date donationDate;
    private String donationResult;
    private String comments;
    private String beneficiary;

    @Id
    @Column(name = "donation_id", nullable = false)
    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
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
    @Column(name = "donation_date", nullable = true)
    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    @Basic
    @Column(name = "donation_result", nullable = true, length = 20)
    public String getDonationResult() {
        return donationResult;
    }

    public void setDonationResult(String donationResult) {
        this.donationResult = donationResult;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 20)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "beneficiary", nullable = true, length = 20)
    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonationsHistoryEntity that = (DonationsHistoryEntity) o;
        return donationId == that.donationId &&
                userId == that.userId &&
                Objects.equals(donationDate, that.donationDate) &&
                Objects.equals(donationResult, that.donationResult) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(beneficiary, that.beneficiary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donationId, userId, donationDate, donationResult, comments, beneficiary);
    }
}
