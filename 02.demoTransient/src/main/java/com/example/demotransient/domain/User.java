package com.example.demotransient.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: User
 * @author: Scarlet
 * @date: 2024/5/24
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8294180014912103005L;

    private String username;

    private transient String passwd;


}
