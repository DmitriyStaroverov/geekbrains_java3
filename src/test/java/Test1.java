import net.evricom.edu.java3lesson6.ru.gb.Calculator;
import org.junit.*;

/**
 * created by dima on 13.09.2019 13:58
 */
public class Test1 {
    private Calculator calculator;
    @Before
    public void init(){
        System.out.println("init");
        calculator = new Calculator();
    }
    @Test
    public void testAdd_2_2(){
        Assert.assertEquals(4,calculator.add(2,2));
    }
    @Test
    public void testAdd_3_2(){
        Assert.assertEquals(5,calculator.add(3,2));

    }
    @Test
    public void testAdd_4_3(){
        Assert.assertEquals(7,calculator.add(4,3));
    }
    @Test
    public void testDiv1(){
        Assert.assertEquals(2,calculator.div(4,2));
    }
    @Test(expected = ArithmeticException.class)
    public void testDiv0(){
        Assert.assertEquals(2,calculator.div(4,0));
    }
    @Test(expected = ArithmeticException.class, timeout = 90)
    public void testDivSleep(){
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calculator.div(4,2);
    }
    @Test
    @Ignore(value = "Не хочу ждать час")
       public void testDiv01(){
        Assert.assertEquals(2,calculator.div(4,0));
    }


    @After
    public void shutdown(){
        System.out.println("end");
    }
}
