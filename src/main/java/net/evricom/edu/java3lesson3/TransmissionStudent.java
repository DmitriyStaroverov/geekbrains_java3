package net.evricom.edu.java3lesson3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;

/**
 * created by dima on 20.08.2019 9:06
 */
public class TransmissionStudent {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
    }
}

class Client{
    Socket socket;
    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;

    public Client() {
        try {
            if (socket == null || socket.isClosed()) {
                socket = new Socket("localhost", 18888);
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                inputStream = new ObjectInputStream(socket.getInputStream());
                //
                Student student0 = new Student(2, "Вася");
                Student student1 = new Student(5,"Иван");
                Student student2 = new Student(15,"Вася");
                outputStream.writeObject(student0);
                outputStream.writeObject(student1);
                outputStream.writeObject(student2);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



