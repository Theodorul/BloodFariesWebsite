package com.java.blood.repository;

import com.java.blood.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    @Query("Select u.email from UsersEntity u")
    List<String> getAllEmails();
}
