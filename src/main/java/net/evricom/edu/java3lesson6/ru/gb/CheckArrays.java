package net.evricom.edu.java3lesson6.ru.gb;

/**
 * created by dima on 13.09.2019 23:13
 */
public class CheckArrays {
    public static int[] getArrAfter4(int[] inputArr){
        int num = -1;
        for (int i = inputArr.length-1; i >= 0; i--) {
            if (inputArr[i] == 4){
                num = i;
                break;
            }
        }
        if (num == -1) throw new RuntimeException("Нет 4-ки");
        int[] resArr = new int[inputArr.length-num-1];
        System.arraycopy(inputArr,num+1, resArr,0,resArr.length);
        return resArr;
    }

    public static boolean checkArrTo_1And_4(int[] inputArr){
        int num1 = 0;
        int num4 = 0;
        for (int value : inputArr) {
            if (value == 1) {
                num1++;
            } else if (value == 4) {
                num4++;
            } else return false;
        }
        return (num4 > 0) & (num1 > 0);
    }
}

