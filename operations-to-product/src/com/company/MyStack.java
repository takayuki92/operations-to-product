package com.company;

/**
 * @MyStack class to contain info and behaviors of the stack
 * Generic version of stack class
 */
public class MyStack extends PrintOut{
    Node head;

    MyStack() {
        this.head = null;
    }

    /**
     * Checking if the list is empty
     * @return true if the list is empty
     */
    boolean isEmpty() {
        return head == null;
    }

    //Add a product into the stack list
    public void push(Product p) {
        Node temp = new Node(p);
        // check if stack (heap) is full. Then inserting an
        //  element would lead to stack overflow
        if (temp == null) {
            printOut("\n Heap overflow");
        }
        temp.next = head;
        head = temp;
    }

    //Return top product in the stack list
    Product peek() {
        if(!(isEmpty())) {
            return head.info;
        } else {
            printOut("Stack is empty");
            return null;
        }
    }

    //Remove top product from the stack list
    void pop() {
        if (head == null) {
            printOut("\nStack underflow");
            return;
        }
        head = head.next;
    }

    void display() {
        //check for stack underflow
        if (head == null) {
            printOut("\nStack underflow");
           System.exit(1);
        } else {
            Node temp = head;
            while (temp != null) {
                printOut(temp.info.toString());
                temp = temp.next;
            }
        }

    }


}
