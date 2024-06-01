package com.example.demoinandoutstream;

import java.io.*;
import java.net.Socket;

/**
 * @className: Client
 * @author: Scarlet
 * @date: 2024/6/1
 **/
public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 12345)){
            //将字符流转换为字节流
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(osw);

            //将字节流转换为字符流
            InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);

            writer.write("Hello Server");
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Server response:" + response);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
