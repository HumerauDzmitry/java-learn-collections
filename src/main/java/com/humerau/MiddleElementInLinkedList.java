package com.humerau;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MiddleElementInLinkedList {

    public String getMiddleElementInLinkedList(List<String> linkedList) {
        String middle = null;
        int countIter = 0;
        ListIterator<String> iterator = linkedList.listIterator();
        ListIterator<String> middleIterator = linkedList.listIterator();

        while (iterator.hasNext()) {
            countIter++;
            if (countIter % 2 == 0) {
                middle = middleIterator.next();
            }
            iterator.next();
        }
        if (countIter % 2 == 1) {
            middle = middleIterator.next();
        }
        return middle;
    }

    public static void main(String[] args) {
        MiddleElementInLinkedList middleElementInLinkedList = new MiddleElementInLinkedList();
        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");
        linkedList.add("g");
        System.out.println(middleElementInLinkedList.getMiddleElementInLinkedList(linkedList));
    }
}
