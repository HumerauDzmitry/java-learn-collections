package com.humerau;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T data) {
        Node<T> node = new Node(data);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    public void remove(T data) {
        if (this.head == null) {
            throw new NoSuchElementException();
        } else if (this.head.getData().equals(data)) {
            this.head = this.head.getNext();
            this.size--;
            return;
        }

        Node<T> current = this.head;
        Node<T> next = current.getNext();
        while (next != null) {
            if (next.getData().equals(data)) {
                current.setNext(next.getNext());
                if (current.getNext() == null) {
                    this.tail = current;
                }
                this.size--;
                return;
            }
            current = next;
            next = current.getNext();
        }
        throw new NoSuchElementException();
    }

    public int length() {
        int count = 0;
        Node<T> current = head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Object getKthNodeFromEnd(int k) throws NoSuchElementException {
        Node<T> fast = head;
        Node<T> slow = head;
        int count = 1;
        while (fast.next != null) {
            fast = fast.next;
            count++;
            if (count > k) {
                slow = slow.next;
            }
        }
        System.out.println(count + " - " + k);

        if (k > count) {
            throw new NoSuchElementException("Incorrect index");
        }

        System.out.println(k);
        return slow.data;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        Node<T> current = this.head;
        while (current != null) {
            buffer.append(current.getData());
            if (current.getNext() != null) {
                buffer.append(", ");
            }
            current = current.getNext();
        }
        buffer.append("}");
        return buffer.toString();
    }

    public String getMiddleElement() {
        Node<T> current = head;
        int length = 0;
        Node<T> middle = head;

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
        return middle.data.toString();
    }

    public boolean isCyclic() {
        Node<T> fast = head;
        Node<T> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> forward = null;

        while (current.next != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        head = current;
        head.next = previous;
    }

    public void removeDuplicate() {
        Node<T> current = head, temp = null;

        while (current != null && current.next != null) {
            temp = current;

            while (temp.next != null) {
                if (current.data == temp.next.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            current = current.next;
        }
//        System.gc();
    }

    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
    }

    Node<T> node(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }
}
