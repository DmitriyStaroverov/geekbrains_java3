package net.evricom.edu.java3lesson3;

import java.io.*;

import java.net.Socket;
import java.util.Arrays;

/**
 * created by dima on 20.08.2019 9:06
 */
public class TransmissionStudent {
    public static void main(String[] args) throws IOException {
        //
        Student student0 = new Student(2, "Вася");
        Student student1 = new Student(5, "Иван");
        Student student2 = new Student(15, "Вася");
        Client client = new Client("localhost", 18888);
        client.sendStudent(student0);
        client.close();

        client = new Client("localhost", 18888);
        client.sendStudent(student1);
        client.close();

        client = new Client("localhost", 18888);
        client.sendStudent(student2);
        client.close();
    }
}

class Client {

    Socket socket = null;
    DataOutputStream dataOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;
    private ObjectOutputStream objectOutputStream;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byteArrayOutputStream = new ByteArrayOutputStream();
        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    }

    byte[] getArrByte(Student student) throws IOException {
            objectOutputStream.writeObject(student);
            return byteArrayOutputStream.toByteArray();
    }

    public void sendStudent(Student student) throws IOException {
        byte[] arrByte = getArrByte(student);
        if (arrByte != null) {
            System.out.println(Arrays.toString(arrByte));
            dataOutputStream.write(getArrByte(student));
        }
    }

    public void close() throws IOException {
        byteArrayOutputStream.close();
        objectOutputStream.close();
        //
        dataOutputStream.close();
        socket.close();
    }
}



