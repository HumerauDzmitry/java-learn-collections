package com.humerau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    SinglyLinkedList singlyLinkedList;

    @BeforeEach
    void setUp() { singlyLinkedList = new SinglyLinkedList(); }

    @DisplayName("Test remove successful")
    @Test
    void shouldBeTrueRemove() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("g");
        list.add("g");
        SinglyLinkedList actualList = new SinglyLinkedList();
        actualList.add("b");
        actualList.add("a");
        actualList.add("a");
        actualList.add("e");
        actualList.add("g");
        actualList.add("g");
        list.remove("a");
        assertEquals(list.toString(), actualList.toString());
    }
    @DisplayName("Test remove unsuccessful")
    @Test
    void shouldBeFalseRemove() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("g");
        list.add("g");
        SinglyLinkedList actualList = new SinglyLinkedList();
        actualList.add("g");
        actualList.add("a");
        actualList.add("a");
        actualList.add("e");
        actualList.add("g");
        actualList.add("g");
        list.remove("a");
        assertNotEquals(list.toString(), actualList.toString());
    }

    @DisplayName("Test remove nonexistent item")
    @Test
    void shouldBeNoSuchElementExceptionRemove() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");

        Throwable exception = assertThrows(NoSuchElementException.class, () -> {
            list.remove("k");
        });
        assertEquals(null, exception.getMessage());
    }


    @DisplayName("Test removeDuplicate successful")
    @Test
    void shouldBeTrueRemoveDuplicate() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("g");
        list.add("g");
        SinglyLinkedList actualList = new SinglyLinkedList();
        actualList.add("a");
        actualList.add("b");
        actualList.add("e");
        actualList.add("g");
        list.removeDuplicate();
        assertEquals(list.toString(), actualList.toString());
    }
    @DisplayName("Test removeDuplicate unsuccessful")
    @Test
    void shouldBeFalseRemoveDuplicate() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("g");
        list.add("g");
        SinglyLinkedList actualList = new SinglyLinkedList();
        actualList.add("a");
        actualList.add("b");
        actualList.add("u");
        actualList.add("g");
        list.removeDuplicate();
        assertNotEquals(list.toString(), actualList.toString());
    }

    @DisplayName("Test length successful")
    @Test
    void shouldBeTrueLength() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("g");
        list.add("g");
        list.length();
        assertEquals(list.length(), 7);
    }
    @DisplayName("Test length unsuccessful")
    @Test
    void shouldBeFalseLength() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("g");
        list.add("g");
        list.length();
        assertNotEquals(list.length(), 6);
    }

    @DisplayName("Test getKthNodeFromEnd successful")
    @Test
    void shouldBeTrueGetKthNodeFromEnd() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("g");
        list.add("g");
        assertEquals(list.getKthNodeFromEnd(3), "e");
    }

    @DisplayName("Test getKthNodeFromEnd unsuccessful")
    @Test
    void shouldBeFalseGetKthNodeFromEnd() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("e");
        list.add("g");
        list.add("g");
        assertNotEquals(list.getKthNodeFromEnd(3), "l");
    }

    @DisplayName("Test remove nonexistent item")
    @Test
    void shouldBeNoSuchElementExceptionKthNodeFromEnd() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("a");
//        list.getKthNodeFromEnd(4);
//        System.out.println(list.getKthNodeFromEnd(10));

        Throwable exception = assertThrows(NoSuchElementException.class, () -> {
            list.getKthNodeFromEnd(5);
        });

        assertEquals("Incorrect index", exception.getMessage());
    }

    @DisplayName("Test getMiddleElement successful")
    @Test
    void shouldBeTrueGetMiddleElement() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        assertEquals(list.getMiddleElement(), "d");
    }
    @DisplayName("Test getMiddleElement unsuccessful")
    @Test
    void shouldBeFalseGetMiddleElement() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        assertNotEquals(list.getMiddleElement(), "c");
    }

    @DisplayName("Test isCyclic successful")
    @Test
    void shouldBeTrueIsCyclic() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        assertEquals(list.isCyclic(), false);
    }
    @DisplayName("Test isCyclic unsuccessful")
    @Test
    void shouldBeFaleIsCyclic() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        assertNotEquals(list.isCyclic(), true);
    }

    @DisplayName("Test reverse successful")
    @Test
    void shouldBeTrueReverse() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        SinglyLinkedList acrualList = new SinglyLinkedList();
        acrualList.add("g");
        acrualList.add("f");
        acrualList.add("e");
        acrualList.add("d");
        acrualList.add("c");
        acrualList.add("b");
        acrualList.add("a");
        list.reverse();
        assertEquals(list.toString(), acrualList.toString());
    }
    @DisplayName("Test reverse unsuccessful")
    @Test
    void shouldBeFalseReverse() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        SinglyLinkedList acrualList = new SinglyLinkedList();
        acrualList.add("g");
        acrualList.add("f");
        acrualList.add("e");
        acrualList.add("d");
        acrualList.add("c");
        acrualList.add("a");
        acrualList.add("b");
        list.reverse();
        assertNotEquals(list.toString(), acrualList.toString());
    }
}