package com.company;

/**
 * Generic version of the Node class
 */
public class Node {
    Product info;
    int data;
    Node next;

    public Node(Product info) {
        this.info = info;
        this.next = null;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
