package com.java.blood.services;

import com.java.blood.beans.HistoryAdderBean;
import com.java.blood.beans.HistoryMaxResponseBean;
import com.java.blood.beans.HistoryResponseBean;
import com.java.blood.model.DonationRequestsEntity;

import java.util.List;

public interface DonationsService {

    String addRequest(DonationRequestsEntity donationRequestsEntity);

    String addDonation(HistoryAdderBean historyAdderBean);

    List<HistoryResponseBean> getDataFromHistory(Integer user_id);

    List<DonationRequestsEntity> getAllRequests();

    List<HistoryMaxResponseBean> getFullHistoryFromHistory();
}
