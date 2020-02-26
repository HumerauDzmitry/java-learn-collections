package com.humerau;

import java.util.NoSuchElementException;

public class KthNodeFromEndInSinglyLinkedList<T> extends BaseSinglyLinkedList<T> {

    public Object getKthNodeFromEnd(int k) throws NoSuchElementException {
        Node<T> fast = super.getHead();
        Node<T> slow = super.getHead();
        int count = 1;
        while (fast.getNext() != null) {
            fast = fast.getNext();
            count++;
            if (count > k) {
                slow = slow.getNext();
            }
        }

        if (k > count) {
            throw new NoSuchElementException("Incorrect index");
        }

        return slow.getData();
    }

    public static void main(String[] args) {
        KthNodeFromEndInSinglyLinkedList<String> list = new KthNodeFromEndInSinglyLinkedList<String>();
        list.add(new Node<String>("a"));
        list.add(new Node<String>("b"));
        list.add(new Node<String>("c"));
        list.add(new Node<String>("d"));
        list.add(new Node<String>("e"));
        list.add(new Node<String>("f"));
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(list);
        System.out.println("3th node from end \'" + list.getKthNodeFromEnd(3) + "\'");
    }
}
