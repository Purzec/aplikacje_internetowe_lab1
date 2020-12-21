package com.example.aplikacje_internetowe_lab1.repository;

import com.example.aplikacje_internetowe_lab1.model.Stm_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface STM_User_Repository extends JpaRepository<Stm_User,Integer> {

    @Query(value = " select * from stm_user  where email = ?1 ",nativeQuery = true)
    List<Stm_User> findByEmail(String email);

}
