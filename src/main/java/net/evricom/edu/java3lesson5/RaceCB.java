package net.evricom.edu.java3lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * created by dima on 06.09.2019 12:33
 */

class TestRaceCB {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        RaceCB race = new RaceCB(new RoadCB(60), new TunnelCB(), new RoadCB(40));
        CarCB[] cars = new CarCB[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new CarCB(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            race.step = 0;
            race.cyclicBarrier.await();
            race.step = 1;
            race.cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class CarCB implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private RaceCB race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public CarCB(RaceCB race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            race.cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if ((!race.existWinner) & (race.cyclicBarrier.getNumberWaiting() == 1)){
            race.existWinner = true;
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + this.name + " WIN!!");
        }
        try {
            race.cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

abstract class StageCB {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(CarCB c);
}

class RoadCB extends StageCB {
    public RoadCB(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(CarCB c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TunnelCB extends StageCB {

    Semaphore semaphoreTunnel;

    public TunnelCB() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        semaphoreTunnel = new Semaphore(TestRaceCB.CARS_COUNT/2);
    }

    @Override
    public void go(CarCB c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphoreTunnel.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphoreTunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class RaceCB {
    private ArrayList<StageCB> stages;

    CyclicBarrier cyclicBarrier;
    int step = 0;
    volatile boolean existWinner;

    public ArrayList<StageCB> getStages() {
        return stages;
    }



    public RaceCB(StageCB... stages) {
        this.existWinner = false;
        this.cyclicBarrier = new CyclicBarrier(TestRaceCB.CARS_COUNT + 1, new Runnable() {
            @Override
            public void run() {
                if (step == 0){
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                } else if (step == 1){
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                }
            }
        });
        this.stages = new ArrayList<StageCB>(Arrays.asList(stages));
    }
}