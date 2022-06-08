package com.company;

import java.util.Queue;

/**
 * @MyQueue class to contain info and behaviors of the queue
 * Generic version of queue class
 */
public class MyQueue {

    Node head, tail;

    MyQueue() {
        this.head = this.tail = null;
    }

    //Add a product to the queue list
    public void enqueue(Product p) {
        Node temp = new Node(p);
        //if queue list is empty, the new node is head and tail both
        if (this.tail == null) {
            this.head = this.tail = temp;
        }
        tail.next = temp;
        tail = temp;
    }

    void dequeue() {
        if(this.head == null) {
            return;
        }
        //store previous node and move front one node ahead
        Node temp = head;
        this.head = head.next;
        //if head becomes NULL, then change tail as also NULL
        if (this.head == null) {
            this.tail = null;
        }
    }

}
