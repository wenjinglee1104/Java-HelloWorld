package com.example.demoserializable.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: Wanger
 * @author: Scarlet
 * @date: 2024/5/22
 **/
@Data
public class Wanger implements Serializable {

    private static final long serialVersionUID = -2095916884810199532L;

    private String name;

    private Integer age;

    public static String pre = "沉默";

    transient String meizi = "王三";

    @Override
    public String toString(){
        return "Wanger(" + "name" + name + ",age=" + age + ",pre=" + pre + ",meizi=" + meizi + ")";
    }

}
