package net.evricom.edu.java3lesson1;

/**
 * created by dima on 08.08.2019 15:35
 */
public class TestGeneric<T> {
    private T obj;

    public void setObj(T obj) {
        this.obj = obj;
    }

    public TestGeneric(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void showType(){
        System.out.println("Тип Т: " + obj.getClass().getName());
    }
}

class GenericDemoApp{
    public static void main(String[] args) {
        TestGeneric<String> genStr = new TestGeneric<>("Hello");
        genStr.showType();
        System.out.println("genStr.getObj(): " + genStr.getObj());
        System.out.println();
        TestGeneric<Integer> genInt = new TestGeneric<>(140);
        genInt.showType();
        System.out.println("genStr.getObj(): " + genInt.getObj());
        String s = genStr.getObj();
        //genInt.setObj("Java");


    }
}
