package net.evricom.edu.java3lesson3;

import java.io.*;
import java.nio.charset.Charset;

/**
 * created by dima on 17.08.2019 18:52
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("123.txt");
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String[] strings1 = file.list();
//        String[] strings = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                if (name.endsWith("txt")) {
//                    return true;
//                }
//                return false;
//            }
//        });
//        for (String s: strings1
//             ) {
//            System.out.println(s);
//        }
        long t = System.currentTimeMillis();
        try {
            byte[] arr = new byte[512];
            char[] arrChar = new char[512];
            InputStreamReader stream = new InputStreamReader(new FileInputStream(file));
            int x;
            System.out.println(stream.getEncoding());
            while ((x = stream.read(arrChar)) != -1){
            //while ((x = stream.read()) != -1){
            //while ((x = stream.read(arr)) != -1){
                //System.out.print(x + ":");
//                System.out.print((char)x);
                //System.out.print(new String(arr,0,x, "UTF-8"));
                System.out.print(new String(arrChar));
                //System.out.println();
                //System.out.print((char)x);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nВремя: " + (System.currentTimeMillis() - t));

    }
}
