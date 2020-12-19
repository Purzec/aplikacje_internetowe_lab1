package com.example.aplikacje_internetowe_lab1.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stm_user")
public class Stm_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    @Column(columnDefinition = "boolean default false")
    private boolean status;
    private LocalDateTime registrationDateAndTime = LocalDateTime.now();;

    @OneToMany(mappedBy = "stmUser")
    @JsonIgnoreProperties({"stm_user"})
    private List<STM_Task> zadania;





}
