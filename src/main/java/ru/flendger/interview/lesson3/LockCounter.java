package ru.flendger.interview.lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    private final Lock lock;
    private int currentI;

    public LockCounter() {
        lock = new ReentrantLock();
    }

    public void increase() {
        try {
            lock.lock();
            currentI++;
        } finally {
            lock.unlock();
        }
    }

    public int getCurrentI() {
        try {
            lock.lock();
            return currentI;
        } finally {
            lock.unlock();
        }
    }
}
