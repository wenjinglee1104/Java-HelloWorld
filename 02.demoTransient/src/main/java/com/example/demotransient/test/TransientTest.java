package com.example.demotransient.test;

import com.example.demotransient.domain.*;

import javax.imageio.IIOException;
import java.io.*;

/**
 * @className: TransientTest
 * @author: Scarlet
 * @date: 2024/5/24
 **/
public class TransientTest {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("沉默王二");
        user.setPasswd("123456");

        System.out.println("read before Serializable");
        System.out.println("username:" + user.getUsername());
        System.out.println("passwd:" + user.getPasswd());

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.txt"));
            os.writeObject(user); //把User对象写进文件
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.txt"));
            user = (User) is.readObject(); //从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable");
            System.out.println("username: " + user.getUsername());
            System.out.println("passwd: " + user.getPasswd());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
