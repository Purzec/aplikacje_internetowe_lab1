package com.example.aplikacje_internetowe_lab1.model;

import com.example.aplikacje_internetowe_lab1.enums.STM_Status;
import com.example.aplikacje_internetowe_lab1.enums.STM_Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stm_task")
public class STM_Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String title;
    private String description;

    private LocalDateTime dateAdded = LocalDateTime.now();;
    @Enumerated(value = EnumType.STRING)
    private STM_Type stmType;
    @Enumerated(value = EnumType.STRING)
    private STM_Status stmStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Stm_User stmUser;

}
