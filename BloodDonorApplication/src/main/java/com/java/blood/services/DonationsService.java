package com.java.blood.services;

import com.java.blood.beans.HistoryAdderBean;
import com.java.blood.beans.HistoryResponseBean;
import com.java.blood.model.DonationRequestsEntity;
import com.java.blood.model.DonationsHistoryEntity;

import java.util.List;

public interface DonationsService {

    public void addRequest(DonationRequestsEntity donationRequestsEntity);

    public void addDonation(HistoryAdderBean historyAdderBean);

    public List<HistoryResponseBean> getDataFromHistory(Integer user_id);

    List<DonationRequestsEntity> getAllRequests();
}
