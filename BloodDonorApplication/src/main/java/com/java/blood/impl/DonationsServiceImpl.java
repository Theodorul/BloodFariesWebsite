package com.java.blood.impl;

import com.java.blood.beans.HistoryAdderBean;
import com.java.blood.model.DonationRequestsEntity;
import com.java.blood.model.DonationsHistoryEntity;
import com.java.blood.repository.DonationsRepository;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.DonationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DonationsService")
public class DonationsServiceImpl implements DonationsService {
    @Autowired
    private DonationsRepository donationsRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addRequest(DonationRequestsEntity donationRequestsEntity) {
        donationsRepository.addRequest(donationRequestsEntity.getRh(), donationRequestsEntity.getBloodType(),
                donationRequestsEntity.getReasonToRequest(),
                donationRequestsEntity.getLocation(), donationRequestsEntity.getHospital());
    }

    @Override
    public void addDonation(HistoryAdderBean historyAdderBean) {
        donationsRepository.addDonationInHistory(usersRepository.getIdFromName(historyAdderBean.getEmail()),
                historyAdderBean.getDonation_date(),historyAdderBean.getDonation_result(),historyAdderBean.getComments(),
                historyAdderBean.getBeneficiary());
    }

    @Override
    public List<DonationsHistoryEntity> getDataFromHistory(Integer user_id) {
        return donationsRepository.getDataFromHistory(user_id);
    }
}
