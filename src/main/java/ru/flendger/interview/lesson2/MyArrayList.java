package ru.flendger.interview.lesson2;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 4;

    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length + DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public void add(T item) {
        add(size, item);
    }

    public void add(int i, T item) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Индекс за пределами границ списка");
        }

        if (size == array.length) {
            resize();
        }

        System.arraycopy(array, i, array, i + 1, size - i);
        array[i] = item;
        size++;
    }

    public void remove(T item) {
        if (size == 0) {
            return;
        }

        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                System.arraycopy(array, i + 1, array, i, size - (i + 1));
                array[size-1] = null;
                size--;
                return;
            }
        }
    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Индекс за пределами границ списка");
        }

        return (T) array[i];
    }

    public int index(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
}
