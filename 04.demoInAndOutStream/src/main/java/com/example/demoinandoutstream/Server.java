package com.example.demoinandoutstream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @className: Server
 * @author: Scarlet
 * @date: 2024/6/1
 **/
public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(12345)){

            System.out.println("Server is listening on port 12345");
            Socket socket = serverSocket.accept();

            //将字节流转换为字符流
            InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
            //使用缓冲流
            BufferedReader reader = new BufferedReader(isr);

            //将字符流转换为字节流
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            BufferedWriter writer = new BufferedWriter(osw);

            String message = reader.readLine();
            System.out.println("Received:" + message);

            //处理信息后，发送响应
            writer.write("Message received:" + message);
            writer.newLine();
            writer.flush();

            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
