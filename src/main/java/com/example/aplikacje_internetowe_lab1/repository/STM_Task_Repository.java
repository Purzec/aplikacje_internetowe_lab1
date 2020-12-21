package com.example.aplikacje_internetowe_lab1.repository;

import com.example.aplikacje_internetowe_lab1.enums.STM_Status;
import com.example.aplikacje_internetowe_lab1.enums.STM_Type;
import com.example.aplikacje_internetowe_lab1.model.STM_Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface STM_Task_Repository extends JpaRepository<STM_Task,Integer> {


    @Query(value = " select * from stm_task  where title = ?1 or stm_type = :#{#type?.name()} or stm_status = :#{#status?.name()}  ",nativeQuery = true)
    List<STM_Task> findByTitleOOrStmStatusOrStmType(String title, STM_Type type, STM_Status status);

    @Query(value = " select * from stm_task where task_id = ?1",nativeQuery = true)
    STM_Task findByTaskId(int id);


}
