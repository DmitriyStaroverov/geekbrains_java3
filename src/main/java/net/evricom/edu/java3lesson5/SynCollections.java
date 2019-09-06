package net.evricom.edu.java3lesson5;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * created by dima on 05.09.2019 11:46
 */
public class SynCollections {

    /**
     * не синхронизированный лист
     */
    ArrayList<String> arrayList;

    /**
     * аналог листа, только синхронизированный
     */
    Vector<String> vector;

    /**
     * это очередь
     */
    ArrayBlockingQueue arrayBlockingQueue;

    /**
     * умная хеш-мепа
     * в ней синхронизированы только конкретные ячейки, в которые идет запись
     * чтение из них не синхронизировано
     * в остальном - обычная мепа
     */
    ConcurrentHashMap<String,String> stringConcurrentHashMap;


    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
        blockingQueue.add("1dsadf");
        blockingQueue.add("2dsadf");
        //если добавить еще, будет ошибка - очередь переполнена
        //blockingQueue.add("3dsadf"); //
        boolean rez;
        rez = blockingQueue.offer("str3");  // вернется TRUE, если удалось добавить, и наоборот
        System.out.println(rez);
        blockingQueue.offer("str3", 20L, TimeUnit.MILLISECONDS);  // + Вставляет указанный элемент в
                                                // конец этой очереди, ожидая до указанного времени ожидания,
                                                // когда место станет доступным, если очередь заполнена.
        //
        blockingQueue.put("Вставка"); //Вставляет указанный элемент в конец этой очереди,
                                        // ожидая, когда место станет доступным, если очередь заполнена.

        // умная хеш-мепа
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("key","value");


        // получение синхронизированного списка, который будет полностью синхронизирован
        // т.е.
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        // получение синхронизированной мепы
        Map<String,String> stringArrayList = Collections.synchronizedMap(new HashMap<>());




    }
}
