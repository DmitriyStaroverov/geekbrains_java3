package net.evricom.edu.java3lesson3;

import java.io.*;

/**
 * created by dima on 18.08.2019 23:00
 * сериализация и десериализация
 */
public class Seriali {
    public static void main(String[] args) {
        Student student = new Student(1, "Bob");
        student.book = new Book("Book");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"));
            oos.writeObject(student);
            oos.close();
            //
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"));
            Student student2 = (Student) ois.readObject();
            ois.close();
            student2.info();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class Book{
    String title;

    public Book(String title) {
        this.title = title;
    }
}

class Human{
    public Human() {
        System.out.println("default");
        this.x = 1;
    }

    public Human(int x) {
        this.x = x;
        System.out.println(x);
    }

    int x;
}

class Student extends Human implements Serializable{


    int id;
    String name;
    transient Book book;

    public Student(int id, String name) {
        super(10);
        this.id = id;
        this.name = name;
    }

    void info(){
        System.out.println("ID:" + id + " Name:" + name + " X: " + x + " Book " + book.title);
    }
}
