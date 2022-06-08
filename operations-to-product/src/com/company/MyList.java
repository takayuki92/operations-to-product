package com.company;

import java.util.Scanner;

/**
 * @MyList class to contain info and behaviors of a linked list
 * Generic version of linked list class
 */
public class MyList extends PrintOut{
    //Head node and tail node, defaults are null
    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    };

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    //Return the length of this list
    public int length() {
        int count = 0;
        if (head == null) {
            return 0;
        }
            while(head != null) {
                count++;
                head = head.next;
            }
        return count;
    }

    //Insert an item to the head of the list
    public void insertToHead(Product item) {
        Node newNode = new Node(item);
        if (head == null) {
            newNode.next = null;
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    //Insert an item to the tail of the list
    public void insertToTail(Product item) {
        Node newNode = new Node(item);
        if (tail == null) {
            newNode.next = null;
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //Insert an item to the tail of the list
    public void insertToTail(int x) {
        Node newNode = new Node(x);
        if (tail == null) {
            newNode.next = null;
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    /**
     * Insert an item after position to this list
     * @param position the position of new item
     * @param item the item to be inserted
     */
    public void insertAfterPosition(int position, Product item) {
        Node newNode = new Node(item);
        Node current = head;
            if (position > this.length() || position < 0) { //Check if the position is valid
                printOut("The previous position has still not existed.");
                return;
            }
            if(position == 0) {
                insertToHead(item);
            }else if (position == size) {
                insertToTail(item);
            } else { int count = 1;
                while (count < position) {
                    current = current.next;

                }
                newNode.next = current.next;
                current.next = newNode;
                size++;
            }
    }

    //Deleting the tail of this list
    public void deleteTail() {

        Node preTail = head;
        while(preTail.next != tail) {
            preTail = preTail.next;
        }
        if (preTail != null) {
            preTail.next = null;
            tail = preTail;
        }
    }

    //Deleting all items in the list
    public void clear() {
        head = tail = null;
    }

}
