package net.evricom.edu.java3lesson3;

import java.io.*;
import java.util.Scanner;

/**
 * created by dima on 20.08.2019 2:02
 */
public class ReadBigTXT {

    private static final int LINES = 1800;

    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        File file = new File("Аристотель/Сборник5раз.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        // каждый символ в UTF8 - 2 байта
        byte[] arr = new byte[LINES * 2];
        System.out.println("Время загрузки файла: " + (System.currentTimeMillis() - t1) + " мсек.");
        Scanner in = new Scanner(System.in);
        int num = 1;
        while (true) {
            System.out.print("Введите номер страницы, или 0(ноль) для выхода  ");
            num = in.nextInt();
            System.out.printf("Вы ввели: %d \n", num);
            if (num == 0) break;
            System.out.println();
            long t2 = System.currentTimeMillis();
            randomAccessFile.seek((num - 1) * 2 * LINES);
            randomAccessFile.read(arr,0,arr.length);
            String s = new String(arr, "UTF-8");
            System.out.println(s);
            System.out.println();
            System.out.println("\nВремя чтения страницы: " + (System.currentTimeMillis() - t2) + " мсек.");
        }
        in.close();
        randomAccessFile.close();


    }

}
