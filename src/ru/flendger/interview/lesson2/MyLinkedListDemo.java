package ru.flendger.interview.lesson2;

public class MyLinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        for (int i = 0; i <5; i++) {
            linkedList.addLast("a_" + i);
        }
        System.out.println(linkedList.size());
        linkedList.forEach(System.out::println);
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        System.out.println();

        linkedList.addFirst("a_-1");
        System.out.println(linkedList.peekFirst());
        linkedList.forEach(System.out::println);
        System.out.println();

        System.out.println(linkedList.index("aaa"));
        System.out.println(linkedList.index("a_2"));
        System.out.println();

        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(5));
        System.out.println();

        linkedList.removeFirst();
        System.out.println(linkedList.peekFirst());
        linkedList.forEach(System.out::println);
        System.out.println();

        linkedList.removeLast();
        System.out.println(linkedList.peekLast());
        linkedList.forEach(System.out::println);
        System.out.println();

        linkedList.remove("a_0");
        linkedList.forEach(System.out::println);
        System.out.println();
        linkedList.remove("a_2");
        linkedList.forEach(System.out::println);
        System.out.println();
        linkedList.remove("a_3");
        linkedList.forEach(System.out::println);
        System.out.println();
        linkedList.remove("a_1");
        linkedList.forEach(System.out::println);
        System.out.println(linkedList.size());
        System.out.println();
    }
}
