package com.humerau;

public class ReverseSinglyLinkedList<T> extends BaseSinglyLinkedList<T>{

        public void reverse(){
        Node<T> previous = null;
        Node<T> current = super.getHead();
        Node<T> forward = null;

        while (current.getNext() != null) {
            forward = current.getNext();
            current.setNext(previous);
            previous = current;
            current = forward;
            System.out.println(previous.getData() + "-" + current.getData() + "-" + forward.getData());
        }
        setHead(current);
        getHead().setNext(previous);
    }

    public static void main(String[] args) {
        ReverseSinglyLinkedList<String> list = new ReverseSinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
