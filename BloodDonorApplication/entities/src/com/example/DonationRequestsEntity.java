package com.example;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "donation_requests", schema = "public", catalog = "dd")
public class DonationRequestsEntity {
    private int requestId;
    private String rh;
    private String bloodType;
    private String reasonToRequest;
    private String location;
    private String hospital;

    @Id
    @Column(name = "request_id", nullable = false)
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "rh", nullable = true, length = 10)
    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    @Basic
    @Column(name = "blood_type", nullable = true, length = 10)
    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Basic
    @Column(name = "reason_to_request", nullable = true, length = 20)
    public String getReasonToRequest() {
        return reasonToRequest;
    }

    public void setReasonToRequest(String reasonToRequest) {
        this.reasonToRequest = reasonToRequest;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 20)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "hospital", nullable = true, length = 30)
    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonationRequestsEntity that = (DonationRequestsEntity) o;
        return requestId == that.requestId &&
                Objects.equals(rh, that.rh) &&
                Objects.equals(bloodType, that.bloodType) &&
                Objects.equals(reasonToRequest, that.reasonToRequest) &&
                Objects.equals(location, that.location) &&
                Objects.equals(hospital, that.hospital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, rh, bloodType, reasonToRequest, location, hospital);
    }
}
