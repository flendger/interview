package ru.flendger.interview.lesson3;

public class PingPong {
    private boolean isPing = true;

    synchronized public void ping() throws InterruptedException {
        while (!isPing) {
            wait();
        }
        System.out.println("ping");
        try {
            Thread.sleep(500);
            isPing = false;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void pong() throws InterruptedException {
        while (isPing) {
            wait();
        }
        System.out.println("pong");
        try {
            Thread.sleep(500);
            isPing = true;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
