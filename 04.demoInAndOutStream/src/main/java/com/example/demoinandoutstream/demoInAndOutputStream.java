package com.example.demoinandoutstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @className: demoInAndOutputStream
 * @author: Scarlet
 * @date: 2024/5/31
 **/
public class demoInAndOutputStream {
    public static void main(String[] args) throws IOException {

        //创建一个FileInputStream 对象以读取原始图片文件
        FileInputStream fis = new FileInputStream("original.jpg");
        //创建一个FileOutputStream 对象以写入复制后的图片文件
        FileOutputStream fos = new FileOutputStream("copy.jpg");

        //创建一个缓冲区数组以存储读取的数据
        byte[] buffer = new byte[1024];
        int count;

        //读取原始图片文件并将数据写入复制后的图片文件
        while((count = fis.read(buffer)) != -1){
            fos.write(buffer, 0, count);
        }

        //关闭输入流和输出流
        fis.close();
        fos.close();

    }
}
