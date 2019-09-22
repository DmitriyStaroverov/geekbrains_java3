package net.evricom.edu.java3lesson6.ru.gb;

import org.junit.Assert;
import org.junit.Test;

/**
 * created by dima on 14.09.2019 2:55
 */
public class CheckArraysTest {

    @Test
    public void checkArrTo1And4_1() {
        Assert.assertTrue(CheckArrays.checkArrTo_1And_4(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }
    @Test
    public void checkArrTo1And4_2() {
        Assert.assertFalse("Одни единички",CheckArrays.checkArrTo_1And_4(new int[]{1, 1, 1, 1, 1, 1}));
    }
    @Test
    public void checkArrTo1And4_3() {
        Assert.assertFalse("Одни четверки",CheckArrays.checkArrTo_1And_4(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void checkArrTo1And4_4() {
        Assert.assertFalse("Другие числа кроме 1 и 4",CheckArrays.checkArrTo_1And_4(new int[]{1, 2, 1, 4}));
    }

    @Test
    public void checkArrTo1And4_5() {
        Assert.assertTrue("Одна четверка",CheckArrays.checkArrTo_1And_4(new int[]{1, 1, 1, 4}));
    }

    @Test
    public void checkArrTo1And4_6() {
        Assert.assertTrue("Одни единица",CheckArrays.checkArrTo_1And_4(new int[]{1, 4, 4, 4}));
    }
}