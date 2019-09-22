import net.evricom.edu.java3lesson6.ru.gb.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * created by dima on 13.09.2019 15:28
 */
@RunWith(Parameterized.class)
public class CalcAddParamTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {1, 1, 2},
                {2, 2, 4},
                {4, 5, 9}
        });
    }

    private int a;
    private int b;
    private int c;

    private Calculator calculator;

    public CalcAddParamTest(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void addParamTest(){
        Assert.assertEquals(c, calculator.add(a,b));
    }
}
