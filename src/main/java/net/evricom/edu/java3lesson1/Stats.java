package net.evricom.edu.java3lesson1;

/**
 * ограниченных типов
 * created by dima on 08.08.2019 16:40
 */
public class Stats<T extends Number> {
    private T[] nums;

    public Stats(T... nums) {
        this.nums = nums;
    }

    /**
     * среднее значение
     * @return
     */
    public double avg(){
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum/nums.length;
    }

    // это метасимвольный аргумсент - значит любой тип
    // но типы ограничены в описании класса
    public boolean sameAvg(Stats<?> another) {
        return Math.abs(this.avg()-another.avg()) < 0.0001;
    }
}

class StatsDemoApp{
    public static void main(String[] args) {
        Stats<Integer> intStats = new Stats<>(1,2,3,4,5);
        System.out.println("Среднее значение intStats = " + intStats.avg());
        Stats<Double> doubleStats = new Stats<>(1.0,2.0,3.0,4.0,5.0);
        System.out.println("Среднее значение doubleStats = " + doubleStats.avg());
        // сравним средние значения
        if (intStats.sameAvg(doubleStats)){
            System.out.println("Средние значения равны");
        } else {
            System.out.println("Средине значения не равны");
        }

        //Stats<String> stringStats = new Stats<>("454","655");
   }
}

