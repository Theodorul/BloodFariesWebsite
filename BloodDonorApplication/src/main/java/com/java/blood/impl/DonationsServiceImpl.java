package com.java.blood.impl;

import com.java.blood.beans.HistoryAdderBean;
import com.java.blood.beans.HistoryMaxResponseBean;
import com.java.blood.beans.HistoryResponseBean;
import com.java.blood.model.DonationRequestsEntity;
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
    public String addRequest(DonationRequestsEntity donationRequestsEntity) {
        donationsRepository.addRequest(donationRequestsEntity.getRh(), donationRequestsEntity.getBloodType(),
                donationRequestsEntity.getReasonToRequest(),
                donationRequestsEntity.getLocation(), donationRequestsEntity.getHospital());
        return "Donation request registered successfully";
    }

    @Override
    public String addDonation(HistoryAdderBean historyAdderBean) {
        donationsRepository.addDonationInHistory(usersRepository.getIdFromName(historyAdderBean.getEmail()),
                historyAdderBean.getDonation_date(),historyAdderBean.getDonation_result(),historyAdderBean.getComments(),
                historyAdderBean.getBeneficiary());
        return "Donation registered successfully";
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
    public HistoryResponseBean getLastDateHistory(Integer user_id) {
        List<Object[]> data = donationsRepository.getDataFromHistoryLast(user_id);
        HistoryResponseBean bean = new HistoryResponseBean();
        for(Object[] obj : data){
            bean.setBeneficiary((String) obj[3]);
            bean.setComments((String) obj[2]);
            bean.setDonation_date((Date) obj[0]);
            bean.setDonation_result((String) obj[1]);
            break;
        }
        return bean;
    }

    @Override
    public List<HistoryMaxResponseBean> getFullHistoryFromHistory() {
        List<Object[]> data = donationsRepository.getFullHistory();
        List<HistoryMaxResponseBean> result = new ArrayList<>();
        for(Object[] obj : data){
            HistoryMaxResponseBean bean = new HistoryMaxResponseBean();
            bean.setName((String) obj[0]);
            bean.setEmail((String) obj[1]);
            bean.setLocation((String) obj[2]);
            bean.setDonations_date((Date) obj[3]);
            bean.setDonation_results((String) obj[4]);
            bean.setComments((String) obj[5]);
            bean.setBlood_type((String) obj[6]);
            result.add(bean);
        }
        return result;
    }

    @Override
    public List<DonationRequestsEntity> getAllRequests() {
        return donationsRepository.getAllRequests();
    }
}
