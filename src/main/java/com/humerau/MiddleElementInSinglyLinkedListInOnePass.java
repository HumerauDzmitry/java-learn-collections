package com.humerau;

public class MiddleElementInSinglyLinkedListInOnePass<T> extends BaseSinglyLinkedList<T>{

    public String getMiddleElement() {
        Node<T> current = super.getHead();
        int length = 0;
        Node<T> middle = super.getHead();

        while (current.getNext() != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.getNext();
            }
            current = current.getNext();
        }
        if (length % 2 == 1) {
            middle = middle.getNext();
        }
        return middle.getData().toString();
    }

    public static void main(String[] args) {
        MiddleElementInSinglyLinkedListInOnePass<String> list = new MiddleElementInSinglyLinkedListInOnePass<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        System.out.println(list);
        System.out.println("middle element \'" + list.getMiddleElement() + "\'");
    }
}
