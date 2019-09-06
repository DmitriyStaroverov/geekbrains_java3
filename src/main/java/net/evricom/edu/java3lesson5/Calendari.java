package net.evricom.edu.java3lesson5;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by dima on 04.09.2019 23:33
 */
public class Calendari {

    Timer timer;

    void TestSchedule(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE, 45);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        timer = new Timer();
        timer.schedule(new RemindTask(),time);
    }

    private class RemindTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Time up");
        }
    }

    public static void main(String[] args) {
        Calendari calendari = new Calendari();
        calendari.TestSchedule();
    }
}
