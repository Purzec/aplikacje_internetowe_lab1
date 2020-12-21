package com.example.aplikacje_internetowe_lab1.controller;


import com.example.aplikacje_internetowe_lab1.enums.STM_Status;
import com.example.aplikacje_internetowe_lab1.enums.STM_Type;
import com.example.aplikacje_internetowe_lab1.model.STM_Task;
import com.example.aplikacje_internetowe_lab1.model.Stm_User;
import com.example.aplikacje_internetowe_lab1.services.STM_Task_Services;
import com.example.aplikacje_internetowe_lab1.services.STM_User_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@EnableSwagger2
public class STM_Controller {

private STM_Task_Services stmTaskServices;
private STM_User_Services stmUserServices;



@Autowired
    public STM_Controller(STM_Task_Services stmTaskServices, STM_User_Services stmUserServices) {
        this.stmTaskServices = stmTaskServices;
        this.stmUserServices = stmUserServices;
    }



//metoda twrzenia nowego uzytkownia
    @PostMapping("/users/create")
    public Stm_User createUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password)
    {
        return stmUserServices.insertUser(new Stm_User(name,lastName,email,password,false));
    }

    //metoda zwracajaca wszystkich uzytkowników
    @GetMapping("/users")
    public List<Stm_User> getAllUsers(){
        return stmUserServices.selectUser();
    }

//metoda zwracająca uzytkownika na podstawie id
    @GetMapping("/users/{id}")
    public Optional<Stm_User> getById(@PathVariable int id)
    {
        return stmUserServices.getUserById(id);
    }
//metoda zmieniajaca status uzytkownika
    @PutMapping("/users/activate/id={usersId}")
    public boolean changeStatusUser(
            @PathVariable("userId") int userId
    ){
        return stmUserServices.changeStatus(userId);
    }

//metoda do tworzenia nowego zadani przez uzytkownika
    @PostMapping("/tasks/create")
    public STM_Task createTask(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("type") STM_Type type,
            @RequestParam("status") STM_Status status,
            @RequestParam("user_id") Stm_User userId
    ){
        return stmTaskServices.createTask(new STM_Task(title,description,LocalDateTime.now(),type,status,userId));
    }


//metoda pobierająca wszystkie zadania uporządkowane po dacie dodania
//malejąco
    @GetMapping("/task/date")
    public List<STM_Task> getAllTask(){
        return stmTaskServices.selectTask();
    }


    // metoda wyszukująca zadania po nazwie, statusie lub typie
    @GetMapping("tasks/TitleOrStatusOrType")
    public List<STM_Task> getByTitleOrStatusOrType(String title, STM_Type type, STM_Status status){
        return stmTaskServices.getTaskByTitleOrStatusOrType(title,type,status);
    }


    //metoda zmieniająca status zadania na inny dozwolony status
    @PutMapping("/task/status/id={taskId}")
    public STM_Task changeTaskStatus(
            @PathVariable("taskId") int taskId,
            @RequestParam("status") STM_Status status
    ) {
        return stmTaskServices.changeTaskStatus(taskId,status);
    }


    //metoda usuwająca zadanie, ale nie usuwająca użytkownika przypisanego do
    //zadania
    @DeleteMapping("/tasks/delete")
    public void deleteTaskById(
            @RequestParam("taskId") int taskId
    ){
        stmTaskServices.deleteTaskById(taskId);
    }


}
