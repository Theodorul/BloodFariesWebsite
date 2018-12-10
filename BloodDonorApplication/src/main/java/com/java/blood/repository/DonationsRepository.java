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
    @Query(value = "delete from donation_requests where " +
            "rh = ?1 and blood_type = ?2 and reason_to_request = ?3 and location = ?4 and hospital = ?5" , nativeQuery = true)
    void deleteRequest(@Param("rh") String rh, @Param("blood_type") String blood_type,
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

    @Query(value = "select date (donation_date + interval '1 month' * 6), donation_result, comments, beneficiary from donations_history " +
            " where user_id = ?1 order by donation_date desc" , nativeQuery = true)
    List<Object[]> getDataFromHistoryLast(@Param("user_id") Integer user_id);

    @Query(value = "select distinct date (a.donation_date + interval '1 month' * 6), " +
            " a.donation_result, a.comments, a.beneficiary, b.name, b.email," +
            " b.blood_type, a.donation_date from donations_history a " +
            " inner join users b on a.user_id = b.user_id " +
            " order by a.donation_date desc" , nativeQuery = true)
    List<Object[]> getDataFromHistoryLast2();

    @Query(value = "select u.requestId, u.bloodType, u.location, u.hospital from DonationRequestsEntity u")
    List<DonationRequestsEntity> getAllRequests();


    @Query(value = "select request_id from donation_requests", nativeQuery = true)
    List<Integer> getAllRequestsAsInt();


    @Query(value = "select a.name , a.email , a.location, b.donation_date, b.donation_result, b.comments, a.blood_type\n" +
            "from users a inner join donations_history b on a.user_id = b.user_id", nativeQuery = true)
    List<Object[]> getFullHistory();
}

