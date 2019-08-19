package net.evricom.edu.java3lesson3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * created by dima on 18.08.2019 20:40
 * служет для обединения нескольких потоков в один
 *
 */
public class SequenceInput {
    public static void main(String[] args) {
        ArrayList<FileInputStream> streams = new ArrayList<>();
        try {
            streams.add(new FileInputStream("1.txt"));
            streams.add(new FileInputStream("123.txt"));
            streams.add(new FileInputStream("2.txt"));
            int x;
            SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(streams));
            while (-1 != (x = sequenceInputStream.read())){
                System.out.print((char)x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
