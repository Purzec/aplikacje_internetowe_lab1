package com.example.aplikacje_internetowe_lab1.services;

import com.example.aplikacje_internetowe_lab1.enums.STM_Status;
import com.example.aplikacje_internetowe_lab1.enums.STM_Type;
import com.example.aplikacje_internetowe_lab1.model.STM_Task;
import com.example.aplikacje_internetowe_lab1.repository.STM_Task_Repository;
import com.example.aplikacje_internetowe_lab1.repository.STM_User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class STM_Task_Services {

    @Autowired
    STM_Task_Repository stmTaskRepository;
    @Autowired
    STM_User_Repository stmUserRepository;


    public List<STM_Task> selectTask() {
        return stmTaskRepository.findAll(Sort.by(Sort.Direction.DESC));
    }


    public List<STM_Task> getTaskByTitleOrStatusOrType(String title, STM_Type type, STM_Status status) {
        return stmTaskRepository.findByTitleOOrStmStatusOrStmType(title, type, status);
    }

    public STM_Task createTask(STM_Task task) {
        return stmTaskRepository.save(task);
    }

    public Optional<STM_Task> getTaskById(int taskId) {
        return stmTaskRepository.findById(taskId);
    }

    public void deleteTaskById(int taskId) {
        stmTaskRepository.deleteById(taskId);
    }

    public STM_Task changeTaskStatus(int taskId, STM_Status status) {
        STM_Task task = stmTaskRepository.findByTaskId(taskId);
        task.setStmStatus(status);

        return stmTaskRepository.save(task);
    }

}
