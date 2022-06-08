package com.company;

import java.io.*;
import java.util.Scanner;
/**
 * @OperationToProduct class to manage all functions relate to the product
 */
public class OperationToProduct extends PrintOut{
    Scanner sc = new Scanner(System.in);

    public void writeFile(String fileName, MyList list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
                Node current = list.head;
                while (current != null) {
                    bw.write(current.info.toString());
                    bw.newLine();
                    current = current.next;
                }
                bw.close();

        } catch (Exception e) {
            System.out.println();
        }
    }

    /**
     * Reading all products from the file and insert them to the list at tail
     * @param fileName The file name of the file
     * @param list The linked list contains all products that read from the file
     */
    public void getAllItemsFromFile(String fileName, MyList list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null ) {
                String[] items = line.split(" \\| ");
                String id = items[0];
                String title = items[1];
                int quantity = Integer.parseInt(items[2]);
                double price = Double.parseDouble(items[3]);
                Product pp = new Product(id, title, quantity, price);
                list.insertToTail(pp);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            printOut("Something went wrong.");
        }
    }

    /**
     * Creating and returning a product with info input from keyboard
     * @return the product
     */
    public Product createdProduct() {
        printOut("Input the following info of the product: ");
        printOut("Input new ID: ");
        String id = sc.next();
        printOut("Input Product's Title: ");
        String title = sc.next();
        printOut("Input Product's Quantity: ");
        int quantity = sc.nextInt();
        printOut("Input Product's Price: ");
        double price = sc.nextDouble();
        Product newProduct = new Product(id, title, quantity, price);
        return newProduct;
    }

    /**
     * Adding a product to the list, info of the product input from keyboard
     * @param list the linked list
     */
    public void addLast(MyList list) {
        OperationToProduct op = new OperationToProduct();
        list.insertToTail(op.createdProduct());
        printOut("A new product successfully added");
    }

    /**
     * Printing  all products of the list to console screen
     * @param list the linked list
     */
    public void displayAll(MyList list) {
        if (list.head == null) {
            printOut("List is empty");
        }
        Node i = list.head;
        while(i != null) {
            printOut(i.info.toString());
            i = i.next;
        }
    }

    public void displayAll(MyStack stackList) {
        if (stackList.head == null) {
            printOut("List is empty");
        }
        Node i = stackList.head;
        while(i != null) {
            printOut(i.info.toString());
            i = i.next;
        }
    }

    public void displayAll(MyQueue queueList) {
        if (queueList.head == null) {
            printOut("List is empty");
        }
        Node i = queueList.head;
        while(i != null) {
            printOut(i.info.toString());
            i = i.next;
        }
    }

    /**
     * Writing all products from the list to file
     * @param fileName Input file name
     * @param list Input linked list
     */
    public void writeAllItemsToFile(String fileName, MyList list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            Node i = list.head;
            while (i != null) {
                bw.write(i.info.toString());
                bw.newLine();
                i = i.next;
            }
            bw.flush();
            bw.close();
            printOut("Successfully");
        } catch (Exception e) {
            printOut("Something went wrong");
        }
    }

    /**
     * Searching product by ID input from keyboard
     * @param list the linked list
     */
    public void searchByID(MyList list) {
        printOut("Input the ID to search: ");
        String id = sc.next();
        Node i = list.head;
        String result = "";
        while(i != null) {
            if(i.info.id.equals(id)) {
                 result += i.info.toString();
                break;
            }
            i = i.next;
        }
        if(result != null) {
            printOut(result);
        } else {
            printOut("-1");
        }

    }

    /**
     * Deleting first product that has the ID input from keyboard from the list
     * @param list the linked list
     */
    public void deleteByID(MyList list) {
        printOut("Input the ID to delete ");
        String id = sc.next();
        sc.nextLine();
        Node preNode = list.head;
        while(preNode.next != null) {
            if (preNode.next.info.id.equals(id)) {
                preNode.next = preNode.next.next;
                break;
            }
            preNode = preNode.next;
        }
    }

    /**
     * Sorting products in linked list by ID (Bubble Sort)
     *  @param list the linked list
     */
    public void sortByID(MyList list) {
//        Node i , j;
//        i = list.head;
//        for (i = list.head; i.next != null; i = i.next) {
//            for(j = i.next; j != null; j= j.next) {
//                if(i.info.id.compareTo(j.info.id) > 0) {
//                    Product temp = i.info;
//                    i.info = j.info;
//                    j.info = temp;
//                }
//            }
//        }
        Node current = list.head, run;
        if (current == null) {
            printOut("List is empty");
        } else if (current.next == null){
            printOut(list.head.info.toString());
        } else {
            while(current.next != null) {
                run = current.next;
                while (run != null) {
                    if (current.info.id.compareToIgnoreCase(run.info.id) > 0) {
                        Product temp = current.info;
                        current.info = run.info;
                        run.info = temp;
                    }
                    run = run.next;
                }
                current = current.next;
            }
        }
    }


    /**
     * Convert first quantity of the product from the list to Binary number. Ex: input i = 18 => output = 10010
     * @param list the linked list
     */
    public void convertToBinary(MyList list) {
        int firstIndex = list.head.info.quantity;
        MyList binaryList = new MyList();
        while (firstIndex > 0) {
            if (firstIndex % 2 == 0) {
                binaryList.insertToTail(0);
            }else {
                binaryList.insertToTail(1);
            }
            firstIndex /= 2;
        }
        Node newNode = binaryList.head;
        while (newNode != null ) {
            printOut2(newNode.data + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    /**
     * Reading all products from the file and insert them to stack
     * @param fileName The file name of the file
     * @param list The linked list contains all products that read from the file
     */
    public void getAllItemsFromFile(String fileName, MyStack list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null ) {
                String[] items = line.split(" \\| ");
                String id = items[0];
                String title = items[1];
                int quantity = Integer.parseInt(items[2]);
                double price = Double.parseDouble(items[3]);
                Product pp = new Product(id, title, quantity, price);
                list.push(pp);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            printOut("Something went wrong");
        }
    }

    /**
     * Reading all products from the file and insert them to the queue
     * @param fileName The file name of the file
     * @param list The linked list contains all products that read from the file
     */
    public void getAllItemsFromFile(String fileName, MyQueue list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                String[] items = line.split(" \\| ");
                String id = items[0];
                String title = items[1];
                int quantity = Integer.parseInt(items[2]);
                double price = Double.parseDouble(items[3]);
                Product pp = new Product(id, title, quantity, price);
                list.enqueue(pp);
                line = br.readLine();
            }

            br.close();
        } catch(Exception e) {
            printOut("Something went wrong");
        }
    }
}
