package net.evricom.edu.java3lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * created by dima on 18.08.2019 21:10
 * позволяет организовать произвольный доступ
 * т.е. не от начала к концу, а с любого места
 * как будто это просто массив
 */
public class RandAccFile {
    public static void main(String[] args) {
        File file = new File("3.txt");
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r" );
            randomAccessFile.seek(35);
            System.out.println((char) randomAccessFile.read());
            randomAccessFile.seek(4);
            System.out.println((char) randomAccessFile.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
