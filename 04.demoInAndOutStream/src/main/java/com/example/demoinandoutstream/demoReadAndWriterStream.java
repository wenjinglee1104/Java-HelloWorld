package com.example.demoinandoutstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @className: demoReadAndWriterStream
 * @author: Scarlet
 * @date: 2024/5/31
 **/
public class demoReadAndWriterStream {

    public static void main(String[] args) throws IOException {

        //创建输入流对象
        FileReader fr = new FileReader("aa.txt");
        //创建输出流对象
        FileWriter fw = new FileWriter("copyaa.txt");

        /*创建输出流做的工作
         *   1.调用系统资源创建了一个文件
         *   2. 创建输出流对象
         *   3.把输出流对象指向文件
         */
        //文本文件复制，一次读一个字符
        copyMethod1(fr, fw);
        //文本文件复制，一次读一个字符数组
        copyMethod2(fr, fw);


        fr.close();
        fw.close();
    }

    public static void copyMethod1(FileReader fr, FileWriter fw) throws IOException{
        int ch;
        while((ch = fr.read()) != -1){ //读数据
            fw.write(ch);
        }
        fw.flush();
    }

    public static void copyMethod2(FileReader fr, FileWriter fw) throws IOException{
        char chs[] = new char[1024];
        int len = 0;
        while((len = fr.read(chs)) != -1){ //读数据
            fw.write(chs, 0, len); //写数据
        }
        fw.flush();
    }




}


