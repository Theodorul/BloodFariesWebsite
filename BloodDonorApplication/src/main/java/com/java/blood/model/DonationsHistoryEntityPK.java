package com.java.blood.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DonationsHistoryEntityPK implements Serializable {
    private int donationId;
    private int userId;

    @Column(name = "donation_id", nullable = false)
    @Id
    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonationsHistoryEntityPK that = (DonationsHistoryEntityPK) o;
        return donationId == that.donationId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(donationId, userId);
    }
}
