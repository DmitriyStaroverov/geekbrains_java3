package net.evricom.edu.java3lesson1;

import java.util.ArrayList;
import java.util.Collections;


/**
 * created by dima on 09.08.2019 14:23
 */
public class FromArrayToArrList {

    static ArrayList convertArray(Object... objects){
        ArrayList arrayList = new ArrayList(objects.length);
        Collections.addAll(arrayList, objects);
        return arrayList;
    }


    public static void main(String[] args) {
        ArrayList strArrList = convertArray("1","2","3");
        System.out.println(strArrList);
        ArrayList intArrList = convertArray(1,2,3,4,5);
        System.out.println(intArrList);
    }
}
