package com.humerau;

public class LengthOfSinglyLinkedList<T> extends BaseSinglyLinkedList<T> {

    public int getLengthSinglyLinkedLis() {
        int count = 0;
        Node<T> current = super.getHead();

        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfSinglyLinkedList<String> list = new LengthOfSinglyLinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("b");
        list.add("g");
        System.out.println(list + " length = " + list.getLengthSinglyLinkedLis());
    }
}
