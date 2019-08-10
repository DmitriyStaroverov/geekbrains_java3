package net.evricom.edu.java3lesson1;

/**
 * оьобщенный класс с несколькими параметрами типа
 * created by dima on 08.08.2019 16:12
 */
public class TwoGen<T, V> {
    private T obj1;
    private V obj2;

    public T getObj1() {
        return obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public void showTypes(){
        System.out.println("Тип T: " + obj1.getClass().getName());
        System.out.println("Тип V: " + obj2.getClass().getName());
    }

    public TwoGen(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
}

class SimpleGenApp{
    public static void main(String[] args) {
        TwoGen<Integer, String> hello = new TwoGen<>(555, "Hello");
        hello.showTypes();
        System.out.println(hello.getObj1() + " " + hello.getObj2());
    }
}