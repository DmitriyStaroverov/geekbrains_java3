package net.evricom.edu.java3lesson3;

import java.io.*;
import java.util.Arrays;

/**
 * created by dima on 18.08.2019 15:43
 * BufferedReader сначала делает длительный запрос, помещает все в ОЗУ
 * потом возможно быстро обработать
 */
public class BuffRead {

    //
    public static void main(String[] args) throws IOException {
        File file = new File("123.txt");
        long t = System.currentTimeMillis();
        InputStream in = new FileInputStream(file);
        //BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
            //System.out.println(x);
        }
        byte[] b = out.toByteArray();
        System.out.println(Arrays.toString(b));

        in.close();
        out.close();
        System.out.println("\nВремя: " + (System.currentTimeMillis() - t));
    }
}
