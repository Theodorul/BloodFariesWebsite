package com.java.blood.controller;


import com.java.blood.beans.HistoryAdderBean;
import com.java.blood.beans.HistoryResponseBean;
import com.java.blood.model.DonationRequestsEntity;
import com.java.blood.model.DonationsHistoryEntity;
import com.java.blood.model.UsersEntity;
import com.java.blood.repository.DonationsRepository;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.DonationsService;
import com.java.blood.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonationsController {

    @Autowired
    private DonationsRepository donationsRepository;

    @Autowired
    private DonationsService donationsService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/add/request", method = RequestMethod.PUT)
    public void addRequest(@RequestBody DonationRequestsEntity donationRequestsEntity) {
        donationsService.addRequest(donationRequestsEntity);
    }
    @RequestMapping(value = "/add/donation", method = RequestMethod.PUT)
    public void addRequest(@RequestBody HistoryAdderBean historyAdderBean) {
        donationsService.addDonation(historyAdderBean);
    }
    @RequestMapping(value = "/getHistory/{email}", method = RequestMethod.GET)
    public List<HistoryResponseBean> getDataByUserFromHistory(@PathVariable("email") String email) {
        return donationsService.getDataFromHistory(usersRepository.getIdFromName(email));
    }
    @RequestMapping(value = "/getAllRequests", method = RequestMethod.GET)
    public List<DonationRequestsEntity> getAllRequests() {
        return donationsService.getAllRequests();
    }
}

