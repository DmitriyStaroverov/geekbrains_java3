package net.evricom.edu.java3lesson1;

/**
 * created by dima on 08.08.2019 14:57
 */
public class SimpleBox {
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public SimpleBox(Object object) {
        this.object = object;
    }
}

class BoxDemoApp{
    public static void main(String[] args) {
        SimpleBox intBox1 = new SimpleBox(20);
        SimpleBox intBox2 = new SimpleBox(30);
        System.out.println(intBox1.getObject().getClass());
        if (intBox1.getObject() instanceof Integer && intBox2.getObject() instanceof Integer){
            int sum = (Integer) intBox1.getObject() + (Integer) intBox2.getObject();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("Содержимой различается");
        }

        intBox1.setObject("Java");
        try {
            int sum = (Integer) intBox1.getObject() + (Integer) intBox2.getObject();
            System.out.println("sum = " + sum);
        } catch (ClassCastException e){
            e.printStackTrace();
        }

    }
}
