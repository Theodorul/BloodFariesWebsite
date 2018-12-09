package com.java.blood.impl;

import com.java.blood.beans.HistoryAdderBean;
import com.java.blood.beans.HistoryResponseBean;
import com.java.blood.model.DonationRequestsEntity;
import com.java.blood.model.DonationsHistoryEntity;
import com.java.blood.repository.DonationsRepository;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.DonationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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
    public List<HistoryResponseBean> getDataFromHistory(Integer user_id) {
        List<Object[]> data = donationsRepository.getDataFromHistory(user_id);
        List<HistoryResponseBean> result = new ArrayList<>();
        for(Object[] obj : data){
            HistoryResponseBean bean = new HistoryResponseBean();
            bean.setBeneficiary((String) obj[3]);
            bean.setComments((String) obj[2]);
            bean.setDonation_date((Date) obj[0]);
            bean.setDonation_result((String) obj[1]);
            result.add(bean);
        }
        return result;
    }

    @Override
    public List<DonationRequestsEntity> getAllRequests() {
        return donationsRepository.getAllRequests();
    }
}
