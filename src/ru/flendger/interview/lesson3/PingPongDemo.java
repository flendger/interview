package ru.flendger.interview.lesson3;

public class PingPongDemo {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        final int count = 5;

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    pingPong.pong();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    pingPong.ping();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
