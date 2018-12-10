package com.java.blood.controller;


import com.java.blood.beans.HistoryAdderBean;
import com.java.blood.model.DonationRequestsEntity;
import com.java.blood.repository.DonationsRepository;
import com.java.blood.repository.UsersRepository;
import com.java.blood.services.DonationsService;
import com.java.blood.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;


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
    public String addRequest(@RequestBody DonationRequestsEntity donationRequestsEntity) {
        return donationsService.addRequest(donationRequestsEntity);
    }
    @RequestMapping(value = "/add/donation", method = RequestMethod.PUT)
    public String addRequest(@RequestBody HistoryAdderBean historyAdderBean) {
        return donationsService.addDonation(historyAdderBean);
    }
    @RequestMapping(value = "/getHistory/{email}", method = RequestMethod.GET)
    public ResponseEntity getDataByUserFromHistory(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(donationsService.getDataFromHistory(usersRepository.getIdFromName(email)));
    }
    @RequestMapping(value = "/getAllRequests", method = RequestMethod.GET)
    public ResponseEntity getAllRequests() {
        return ResponseEntity.status(HttpStatus.OK).body(donationsService.getAllRequests());
    }
    @RequestMapping(value = "/getWholeHistory", method = RequestMethod.GET)
    public ResponseEntity getFullHistory() {
        return ResponseEntity.status(HttpStatus.OK).body(donationsService.getFullHistoryFromHistory());
    }

    @RequestMapping(value = "/getLastDonation/{email}", method = RequestMethod.GET)
    public ResponseEntity getFullHistory(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(donationsService.getLastDateHistory(
                usersRepository.getIdFromName(email)));
    }
    @RequestMapping(value = "/getLastDonationFull", method = RequestMethod.GET)
    public ResponseEntity getFullHistory2() {
        return ResponseEntity.status(HttpStatus.OK).body(new HashSet<>(donationsService.getFullHistoryFromHistoryLast()));
    }
}

