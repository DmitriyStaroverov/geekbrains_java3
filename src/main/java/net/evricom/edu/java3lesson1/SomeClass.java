package net.evricom.edu.java3lesson1;

import javax.swing.*;

/**
 * created by dima on 08.08.2019 23:12
 */
public class SomeClass {

    interface Callback{
        void callingBack();
    }

    Callback callback;

    public void regCallBack(Callback callback){
        this.callback = callback;
    }

    void doSomeThing(){
        JOptionPane.showConfirmDialog(null,"Work!!!");
        callback.callingBack();
    }
}

class MyClass implements SomeClass.Callback{

    @Override
    public void callingBack() {
        System.out.println("Вызов метода обратного вызова");
    }
}

class MainClass{
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        MyClass myClass = new MyClass();
        someClass.regCallBack(myClass);

        someClass.doSomeThing();
    }

}