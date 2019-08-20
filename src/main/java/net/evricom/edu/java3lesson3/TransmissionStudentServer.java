package net.evricom.edu.java3lesson3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * created by dima on 20.08.2019 9:46
 */
public class TransmissionStudentServer {


    public TransmissionStudentServer() {

        try {
            ServerSocket serverSocket = new ServerSocket(18888);
            System.out.println("Ожидаем клиентов");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                Thread threadServ = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true) {
                                System.out.println("Ждем на сервере...");
                                Student student = (Student) inputStream.readObject();
                                System.out.println("получен студент на сервере: ");
                                student.info();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                inputStream.close();
                                outputStream.close();
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                threadServ.setDaemon(true);
                threadServ.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TransmissionStudentServer();
    }
}