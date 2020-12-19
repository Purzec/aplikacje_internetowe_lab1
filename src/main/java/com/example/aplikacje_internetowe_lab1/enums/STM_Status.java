package com.example.aplikacje_internetowe_lab1.enums;

public enum STM_Status {

    NEW("NOWY"),
    IN_PROGRESS("W TRAKCIE"),
    DONE("SKONCZONE");


    private final String  statusName;

    STM_Status(String statusName) {
        this.statusName = statusName;
    }
}
