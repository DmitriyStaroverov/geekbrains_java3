package net.evricom.edu.java3lesson3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * created by dima on 18.08.2019 16:00
 * работа с потоками IO , котлорые всегдав создаются парами
 * ввод + вывод
 */
public class DoubleStreams {
    public static void main(String[] args) {
        PipedInputStream pipedInputStream = null;
        PipedOutputStream pipedOutputStream = null;
        pipedInputStream = new PipedInputStream();
        pipedOutputStream = new PipedOutputStream();

        MyThread myThread = new MyThread();
        myThread.setOut(pipedOutputStream);
        myThread.start();
        System.out.println("Запись закончена");

        try {
            pipedOutputStream.connect(pipedInputStream);

            int x;
            while ((x = pipedInputStream.read()) != -1) {
                System.out.print(x + " ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class MyThread extends Thread {
    private PipedOutputStream out;

    public PipedOutputStream getOut() {
        return out;
    }

    public void setOut(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                out.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
