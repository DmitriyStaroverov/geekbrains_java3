package net.evricom.edu.java3lesson3;

import javafx.print.Collation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * created by dima on 19.08.2019 22:39
 */
public class MergeOfFiles {
    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        File file = new File("Аристотель");
        ArrayList<FileInputStream> readers = new ArrayList<>();
        for (String s:
             file.list()) {
            readers.add(new FileInputStream("Аристотель/" + s));
        }
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(readers));
        File outFile = new File("Аристотель/Сборник.txt");
        FileOutputStream out = new FileOutputStream(outFile);
        byte[] arr = new byte[512];
        int x;
        while (in.read(arr) != -1){
            out.write(arr);
        }
        in.close();
        out.close();
        System.out.println("Время: " + (System.currentTimeMillis() - t1) + " мсек.");


    }



}
