package net.evricom.edu.java3lesson3;

import java.io.*;

/**
 * created by dima on 18.08.2019 15:43
 * BufferedReader сначала делает длительный запрос, помещает все в ОЗУ
 * потом возможно быстро обработать
 */
public class BuffRead {

    //
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        File file = new File("123.txt");
        String currLine;

        long t = System.currentTimeMillis();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            //bufferedReader.

            while ((currLine = bufferedReader.readLine()) != null){
                System.out.println(currLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nВремя: " + (System.currentTimeMillis() - t));


    }
}
