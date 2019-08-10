package net.evricom.edu.java3lesson1;

import java.util.Arrays;

/**
 * created by dima on 09.08.2019 8:20
 */
public class TwoArrayCells {

    static void changeCells(Object[] arr, int num1, int num2){
        Object tempObj = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = tempObj;
    }


    public static void main(String[] args) {
        String[] arrStr = {"1","2","3"};
        System.out.println(Arrays.toString(arrStr));
        changeCells(arrStr,2,1);
        System.out.println(Arrays.toString(arrStr));

        Integer[] arrInt = {1,2,3,4,5};
        System.out.println(Arrays.toString(arrInt));
        changeCells(arrInt, 1,4);
        System.out.println(Arrays.toString(arrInt));
    }
}
