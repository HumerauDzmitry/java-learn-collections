package com.humerau;

import java.util.NoSuchElementException;

public abstract class BaseSinglyLinkedList<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public BaseSinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T data) {
        Node<T> node = new Node<T>(data);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    public void add(Node<T> node) {

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            tail.setNext(node);
            tail = tail.getNext();
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

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> node) {
        this.head = node;
    }

    public Node<T> getTail() {
        return tail;
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
}
