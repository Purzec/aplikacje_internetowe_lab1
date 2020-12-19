package com.example.aplikacje_internetowe_lab1.enums;

public enum STM_Type {


    TASK("TASK"),
    BUG("BUG"),
    FEATURE("FEATURE");


    private final String typeName;

    STM_Type(String typeName) {
        this.typeName = typeName;
    }
}
