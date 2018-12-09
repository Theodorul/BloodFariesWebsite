package com.java.blood.repository;

import com.java.blood.model.DonationRequestsEntity;
import com.java.blood.model.DonationsHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface DonationsRepository extends JpaRepository<DonationRequestsEntity, Long> {


    @Modifying
    @Transactional
    @Query(value = "insert into " +
            "donation_requests(rh, blood_type, reason_to_request, location, hospital) " +
            "values (?1,?2, ?3, ?4, ?5)" , nativeQuery = true)
    void addRequest(@Param("rh") String rh, @Param("blood_type") String blood_type,
                    @Param("reason_to_request") String reason_to_request,
                    @Param("location") String location, @Param("hospital") String hospital
    );


    @Modifying
    @Transactional
    @Query(value = "insert into " +
            "donations_history(user_id, donation_date, donation_result, comments, beneficiary) " +
            "values (?1,?2, ?3, ?4, ?5)" , nativeQuery = true)
    void addDonationInHistory(@Param("user_id") Integer user_id, @Param("donation_date") Date donation_date,
                    @Param("donation_result") String donation_result,
                    @Param("comments") String comments, @Param("beneficiary") String beneficiary
    );

    @Query(value = "select donation_date, donation_result, comments, beneficiary from donations_history " +
            " where user_id = ?1" , nativeQuery = true)
    List<Object[]> getDataFromHistory(@Param("user_id") Integer user_id);

    @Query(value = "select u.requestId, u.bloodType, u.location, u.hospital from DonationRequestsEntity u")
    List<DonationRequestsEntity> getAllRequests();
}
