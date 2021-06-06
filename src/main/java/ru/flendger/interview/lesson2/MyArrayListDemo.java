package ru.flendger.interview.lesson2;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        //add to tail
        for (int i = 0; i < 5; i++) {
            myArrayList.add("a_" + i);
        }
        System.out.println(myArrayList.size());

        //add head, middle, tail
        myArrayList.add(0, "head");
        myArrayList.add(3, "middle");
        myArrayList.add(myArrayList.size(), "tail");
        System.out.println(myArrayList.size());

        //remove head, middle, tail
        myArrayList.remove("head");
        myArrayList.remove("middle");
        myArrayList.remove("tail");
        System.out.println(myArrayList.size());

        //get and index
        int idx = myArrayList.index("a_3");
        System.out.println(idx);
        System.out.println(myArrayList.get(idx));
    }
}
