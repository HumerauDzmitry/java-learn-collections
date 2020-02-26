package com.humerau;

public class RemoveDuplicateSinglyLinkedList<T> extends BaseSinglyLinkedList<T> {

    public void removeDuplicate() {
        Node<T> current = super.getHead(), temp = null;

        while (current != null && current.getNext() != null) {
            temp = current;

            while (temp.getNext() != null) {
                if (current.getData() == temp.getNext().getData()) {
                    temp.setNext(temp.getNext().getNext());
                } else {
                    temp = temp.getNext();
                }
            }
            current = current.getNext();
        }
        System.gc();
    }

    public static void main(String[] args) {
        RemoveDuplicateSinglyLinkedList<String> list = new RemoveDuplicateSinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("b");
        list.add("g");
        System.out.println(list.toString());
        list.removeDuplicate();
        System.out.println(list.toString());
    }
}
