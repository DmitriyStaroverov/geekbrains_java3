package net.evricom.edu.java3lesson1;

import java.util.ArrayList;

/**
 * created by dima on 09.08.2019 14:45
 */
abstract class Fruit {


    Fruit(float weight) {
        this.weight = weight;
    }

    private float weight;

    float getWeight(){
        return weight;
    }

}

class Apple extends Fruit{
    Apple() {
        super(1.0f);
    }
}

class Orange extends Fruit{
    public Orange() {
        super(1.5f);
    }
}


class Box<T extends Fruit> extends ArrayList<T>{

    @Override
    public boolean add(T t) {
        return super.add(t);
    }

    boolean compare(Box<?> anotherBox){
        return Math.abs(this.getWeight()-anotherBox.getWeight()) < 0.0001;
    }

    void moveFruit(Box<T> anotherBox){
        anotherBox.addAll(this);
        this.clear();
    }

    private String infoType(){
        String rez = "пустая";
        if (this.size()>0){
            rez = this.get(0).getClass().getSimpleName();
        }
        return rez;
    }

    private float getWeight(){
        float rez = 0;
        for (T fruit : this) {
            rez += fruit.getWeight();
        }
        return rez;
    }

    void info(){
        System.out.println("Коробка вес = " + getWeight() +
                ", тип = " + infoType() +
                ", количество фруктов = " + this.size()
                );
    }

}

class demoAppFruit{
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.info();

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.info();

        System.out.println(appleBox.compare(orangeBox));

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox.info();
        orangeBox1.info();
        orangeBox.moveFruit(orangeBox1);
        orangeBox.info();
        orangeBox1.info();

    }

}
