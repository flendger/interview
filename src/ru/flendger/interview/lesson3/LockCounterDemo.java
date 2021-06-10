package ru.flendger.interview.lesson3;

public class LockCounterDemo {
    public static void main(String[] args) {
        LockCounter lockCounter = new LockCounter();

        for (int i = 0; i < 10; i++) {
            new Thread(lockCounter::increase).start();
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(lockCounter.getCurrentI());
    }
}
