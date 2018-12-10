package com.java.blood.repository;

import com.java.blood.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into " +
            "users(name, email, location, age, weight_in_kg," +
            "pulse,tension, diseases,gender,password, blood_type,hospital) " +
            "values (?1,?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9,?10,?11, ?12)" , nativeQuery = true)
    void addDonator(@Param("name") String name,@Param("email") String email,
                    @Param("location") String location,
                    @Param("age") Integer age, @Param("weight") Integer weight,
                    @Param("pulse") Integer pulse, @Param("tension") Integer tension,
                    @Param("diseases") Integer diseases, @Param("gender") String gender,
                    @Param("pass") String pass,@Param("bt") String bt,@Param("hospital") String hospital
                    );
    @Modifying
    @Transactional
    @Query(value = "insert into role_mapping(user_id, role_id) values(?1 , ?2) " +
            " " , nativeQuery = true)
    void addRoleOnDonator(@Param("user_id") Integer user_id,
                          @Param("role_id") Integer role_id);

    @Query(value = "select b.role_name from users a\n" +
            "inner join role_mapping c on a.user_id = c.user_id\n" +
            "inner join role b on b.role_id = c.role_id where a.email = ?1" , nativeQuery = true)
    List<String> getRoleForUser(@Param("name") String name);

    @Query(value = "select b.role_id from users a\n" +
            "inner join role_mapping c on a.user_id = c.user_id\n" +
            "inner join role b on b.role_id = c.role_id where a.email = ?1" , nativeQuery = true)
    List<Integer> getRoleForUserAsInt(@Param("name") String name);

    @Query("select u.userId from UsersEntity u where u.email = ?1")
    Integer getIdFromName(@Param("name") String name);


    @Query("select u.pass from UsersEntity u where u.email = ?1")
    String getPassForUser(@Param("name") String name);

    @Query("select u.name, u.email, rr.roleName, u.location, u.age, u.weightInKg, " +
            "u.pulse, u.tension, u.diseases, u.gender, u.underTreatment," +
            "u.blood_type, u.hospital from UsersEntity u " +
            "inner join RoleMappingEntity r on u.userId = r.userId " +
            "inner join RoleEntity rr on rr.roleId = r.roleId " +
            "where rr.roleId = ?1")
    List<UsersEntity> getAllUsersByRole(@Param("role") Integer role);



    @Modifying
    @Transactional
    @Query(value = "insert into users (name, email,location, age, weight_in_kg, password) values (?1 ,?2 , ?3, 0 ,0, ?4)" ,nativeQuery = true)
    void addDoctor(@Param("name") String name, @Param("email") String email,
                   @Param("location") String location, @Param("pass") String pass);

    @Modifying
    @Transactional
    @Query(value = "delete from users where email = ?1", nativeQuery = true)
    void deleteUser(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "delete from role_mapping where user_id not in (select user_id from users)", nativeQuery = true)
    void deleteRoleFromUsers();

    @Query("select u.email from UsersEntity u")
    List<String> getAllEmails();

    @Query("select u.userId from UsersEntity u")
    List<Integer> getAllIds();

}
