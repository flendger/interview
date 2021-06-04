package ru.flendger.interview.lesson2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <T> implements Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, tail, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public T peekFirst() {
        return head.item;
    }

    public T peekLast() {
        return tail.item;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        if (head.next != null) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() {
        if (tail == null) {
            return;
        }
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void remove(T item) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (item.equals(currentNode.item)) {
                Node<T> prev = currentNode.prev;
                Node<T> next = currentNode.next;
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }
                if (next == null) {
                    tail = prev;
                } else {
                    next.prev = prev;
                }
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public int index(T item) {
        Node<T> currentNode = head;
        int i = 0;
        while (currentNode != null) {
            if (item.equals(currentNode.item)) {
                return i;
            }
            i++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public T get(int i) {
        if (i < -1 && i >= size) {
            throw new IndexOutOfBoundsException("Индекс за пределами границ списка");
        }

        Node<T> currentNode = head;
        for (int j = 1; j <= i; j++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<T> {
        private Node<T> currentNode;

        @Override
        public boolean hasNext() {
            if (currentNode != null) {
                return currentNode.next != null;
            }

            return head != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Следующий элемент отсутствует");
            }
            if (currentNode == null) {
                currentNode = head;
            } else {
                currentNode = currentNode.next;
            }
            return currentNode.item;
        }
    }

    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
