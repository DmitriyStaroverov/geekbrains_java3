package net.evricom.edu.java3lesson1;

import java.util.HashMap;
import java.util.HashSet;

/**
 * created by dima on 10.08.2019 2:40
 */
public class DemoCallback implements CallBack {


    public static void main(String[] args) {

        PhoneBox book = new PhoneBox();
        book.regCallBack(new DemoCallback());
        book.add("Ivanov", "123");
        book.add("Ivanov", "124");
        book.add("Ivanov", "125");
        book.add("Petrov", "444");
        book.add("Petrov", "445");
        book.add("Petrov", "446");

        book.findString("Ivanov");
        book.findString("Petrov");
        book.findString("Petrasdovjhk");

    }

    @Override
    public void callingBack(String name) {
        System.out.println("Новая зпись добавлена " + name);
    }
}



interface CallBack{
    void callingBack(String name);
}

class PhoneBox {

    private CallBack callBack;

    void regCallBack(CallBack callBack){
        this.callBack = callBack;
    }

    HashMap<String, HashSet<String>> hm;

    public PhoneBox() {
        this.hm = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> hs = hm.getOrDefault(name, new HashSet<>());
        hs.add(phone);
        if (hm.put(name, hs) == null ) callBack.callingBack(name);
    }

    public void findString(String name) {
        if(hm.containsKey(name)) {
            System.out.println(hm.get(name));
        } else {
            System.out.println("такой фамилии нет");
        }
    }

}
