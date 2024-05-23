package com.example.demoserializable;

import com.example.demoserializable.domain.Wanger;

import java.io.*;

/**
 * @className: testWanger
 * @author: Scarlet
 * @date: 2024/5/22
 **/
public class testWanger {

    public static void main(String[] args) {
        //初始化
        Wanger wanger = new Wanger();
        wanger.setName("王二");
        wanger.setAge(19);
        System.out.println(wanger);

        //把对象写进文件中
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("chenmo"));){
            oos.writeObject(wanger);
        }catch (IOException e){
            e.printStackTrace();
        }

        Wanger.pre = "不沉默";

        //把文件中读出对象
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("chenmo")));){
            Wanger wanger1 = (Wanger) ois.readObject();
            System.out.println(wanger1);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
