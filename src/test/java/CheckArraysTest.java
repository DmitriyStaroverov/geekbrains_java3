import net.evricom.edu.java3lesson6.ru.gb.CheckArrays;
import org.junit.Assert;
import org.junit.Test;


/**
 * created by dima on 14.09.2019 1:32
 */
public class CheckArraysTest {
    @Test(expected = RuntimeException.class)
    public void testNot4_1() {
        Assert.assertNull(CheckArrays.getArrAfter4(new int[]{24, 1, 24, 2, 3, 5}));
    }

    @Test(expected = RuntimeException.class)
    public void testNot4_2() {
        Assert.assertNull(CheckArrays.getArrAfter4(new int[]{4444}));
    }

    @Test(expected = RuntimeException.class)
    public void testNot4_3() {
        Assert.assertNull(CheckArrays.getArrAfter4(new int[]{24, 7, 0, -25}));
    }

    @Test(expected = RuntimeException.class)
    public void testNot4_4() {
        Assert.assertNull(CheckArrays.getArrAfter4(new int[]{458, -78, 2, -545, 321, 458}));
    }

    @Test(expected = RuntimeException.class)
    public void testEmptyArr() {
        Assert.assertNull(CheckArrays.getArrAfter4(new int[0]));
    }

    @Test
    public void test4_1() {
        int[] inpArr = {24, 1, 4, 2, -1, 5};
        int[] resArr = {2, -1, 5};
        Assert.assertArrayEquals(resArr, CheckArrays.getArrAfter4(inpArr));
    }

    @Test
    public void test4_2() {
        int[] inpArr = {4444, 4};
        int[] resArr = {};
        Assert.assertArrayEquals(resArr, CheckArrays.getArrAfter4(inpArr));
    }

    @Test
    public void test4_3() {
        int[] inpArr = {4, -78, 2, -545, 321, 458};
        int[] resArr = {-78, 2, -545, 321, 458};
        Assert.assertArrayEquals(resArr, CheckArrays.getArrAfter4(inpArr));
    }

    @Test
    public void test4_4() {
        int[] inpArr = {24, 4, 0, -25};
        int[] resArr = {0, -25};
        Assert.assertArrayEquals(resArr, CheckArrays.getArrAfter4(inpArr));
    }


}
