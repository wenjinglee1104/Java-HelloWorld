package com.example.demotransient.test;

import com.example.demotransient.domain.Student;
import com.example.demotransient.domain.User;

import java.io.*;

/**
 * @className: TransientTest02
 * @author: Scarlet
 * @date: 2024/5/25
 **/
public class TransientTest02 {
    public static void main(String[] args) {

        Student student = new Student();
        student.setUsername("斯琴高娃");
        student.setPasswd("12345678");



        System.out.println("read before Serializable02");
        System.out.println("username:" + student.getUsername());
        System.out.println("passwd:" + student.getPasswd());

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("student.txt"));
            os.writeObject(student); //把student对象写进文件
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            Student.username = "迪丽热巴";

            ObjectInputStream is = new ObjectInputStream(new FileInputStream("student.txt"));
            student = (Student) is.readObject(); //从流中读取student的数据
            is.close();

            System.out.println("\nread after Serializable02");
            System.out.println("username: " + student.getUsername());
            System.out.println("passwd: " + student.getPasswd());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
