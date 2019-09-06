package net.evricom.edu.java3lesson5;

import java.io.Closeable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by dima on 06.09.2019 0:30
 */
public class MFUqueue implements Closeable {

    private ExecutorService servicePrint;
    private ExecutorService serviceScan;


    MFUqueue() {
        servicePrint = Executors.newSingleThreadExecutor();
        serviceScan = Executors.newSingleThreadExecutor();
    }

    void print(DocumentQ doc) {
        servicePrint.execute(() -> {
            try {
                System.out.println("Начало печати: " + doc);
                for (int i = 1; i < doc.getNum() + 1; i++) {
                    System.out.println(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Конец печати: " + doc);
        });
    }

    void scan(DocumentQ doc) {
        serviceScan.execute(() -> {
            try {
                System.out.println("\t\t\t\t\tНачало сканирования: " + doc);
                for (int i = 1; i < doc.getNum() + 1; i++) {
                    System.out.println("\t\t\t\t\t" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\t\t\t\t\tКонец сканирования: " + doc);
        });
    }

    @Override
    public void close() {
        servicePrint.shutdown();
        serviceScan.shutdown();
    }
}

class TestMFUq {
    public static void main(String[] args) {
        try (MFUqueue mfu = new MFUqueue()) {
            mfu.print(new DocumentQ("doc1", 7));
            mfu.scan(new DocumentQ("doc1", 3));
            mfu.scan(new DocumentQ("doc2", 3));
            mfu.scan(new DocumentQ("doc3", 3));
            mfu.print(new DocumentQ("doc2", 6));
            mfu.print(new DocumentQ("doc3", 7));
        }
    }
}

class DocumentQ {

    /**
     * имя документа
     */
    private String name;
    /**
     * число страниц документа
     */
    private int num;

    /**
     * получить число страниц
     *
     * @return страниц док-та
     */
    int getNum() {
        return num;
    }

    DocumentQ(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Документ " + name + " на " + num + "стр.";
    }
}
