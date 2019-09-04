package net.evricom.edu.java3lesson3;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * created by dima on 20.08.2019 9:46
 */
public class TransmissionStudentServer extends Thread {
    private ServerSocket serverSocket;

    public TransmissionStudentServer() {
        try {
            serverSocket = new ServerSocket(18888);
            System.out.println("Ожидание клиентов");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            Socket socket = null;
            DataInputStream dataInputStream = null;
            try {
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                dataInputStream = new DataInputStream(socket.getInputStream());
                byte[] buffer = new byte[512];
                while (dataInputStream.read(buffer) != -1){
                    ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(buffer));
                    Student student = (Student) objectInputStream.readObject();
                    student.info();
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new TransmissionStudentServer().start();
    }
}