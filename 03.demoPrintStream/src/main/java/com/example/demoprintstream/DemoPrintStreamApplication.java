package com.example.demoprintstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class DemoPrintStreamApplication {

    public static void main(String[] args) throws IOException {

        //01.printStream的测试
        PrintStream ps = System.out;
        ps.println("沉默王二");
        ps.print("沉");
        ps.print("\n默");
        ps.print("王");
        ps.println();

        ps.printf("姓名: %s, 年龄: %d, 成绩：%f", "沉默王二", 18, 99.9);

        //02.printf的测试

        int num = 123;
        System.out.printf("%5d\n", num);//输出"123  "
        System.out.printf("%-5d\n", num);//输出"  123"
        System.out.printf("%05d\n", num);//输出"00123"

        double pi = Math.PI;
        System.out.printf("%10.2f\n", pi);//输出"      3.14"
        System.out.printf("%-10.4f\n", pi);//输出"3.1416   "

        String name = "沉默王二";
        System.out.printf("%10s\n", name);//输出"       沉默王二"
        System.out.printf("%-10s\n", name);//输出"沉默王二      "

        //03.PrintWriter的测试
        //文件内容为"沉默王二
        //他的年纪为 18."
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.println("沉默王二");
        writer.printf("他的年纪为 %d.\n", 18);
        writer.close();


        SpringApplication.run(DemoPrintStreamApplication.class, args);
    }

}
