package com.example.aplikacje_internetowe_lab1.services;

import com.example.aplikacje_internetowe_lab1.model.STM_Task;
import com.example.aplikacje_internetowe_lab1.model.Stm_User;
import com.example.aplikacje_internetowe_lab1.repository.STM_Task_Repository;
import com.example.aplikacje_internetowe_lab1.repository.STM_User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class STM_User_Services {


    @Autowired
    STM_Task_Repository stmTaskRepository;
    @Autowired
    STM_User_Repository stmUserRepository;

    //podpunkt a
    public Stm_User insertUser(Stm_User user) {
        return stmUserRepository.save(user);
    }

    public List<Stm_User> selectUser() {
        return stmUserRepository.findAll();
    }

    public List<Stm_User> getUserByEmail(String email) {
        return stmUserRepository.findByEmail(email);
    }

    public Optional<Stm_User> getUserById(int smtUserId) {
        return stmUserRepository.findById(smtUserId);
    }

    public boolean changeStatus(int userId) {
        Optional<Stm_User> userOptional = getUserById(userId);
        if (userOptional.isPresent()) {
            Stm_User stmUserActivate = userOptional.get();
            if (stmUserActivate.isStatus()) {
                stmUserActivate.setStatus(false);
            } else {
                stmUserActivate.setStatus(true);
            }
            stmUserRepository.save(stmUserActivate);
        }
        return userOptional.get().isStatus();
    }

}
