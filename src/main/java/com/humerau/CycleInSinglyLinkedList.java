package com.humerau;

public class CycleInSinglyLinkedList<T> extends BaseSinglyLinkedList<T>{

        public boolean isCyclic(){
            Node<T> fast = super.getHead();
            Node<T> slow = super.getHead();
            while((fast != null) && (fast.getNext() != null)){
                fast = fast.getNext().getNext();
                slow = slow.getNext();
                if(fast == slow ){
                    return true;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        System.out.println(list);
        System.out.println(list.isCyclic());
    }
}
