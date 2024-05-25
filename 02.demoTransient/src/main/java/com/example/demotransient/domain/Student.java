package com.example.demotransient.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: Student
 * @author: Scarlet
 * @date: 2024/5/25
 **/
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 8294180014912103005L;

    public static String  username;

    private transient String passwd;

    public void setUsername(String username) {
        this.username = username;
    }

    public  String getUsername() {
        return username;
    }
}
