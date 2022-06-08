package com.company;

import java.io.*;
import java.util.Scanner;

public class Main extends PrintOut{
    public static void showMenu() {
        printOut("Choose one of this options: \n +" +
                "Product list: \n +" +
                "1. Load data from file and display \n +" +
                "2. Input & add to the end. \n +" +
                "3. Display data \n +" +
                "4. Save product list to file \n +" +
                "5. Search by ID \n +" +
                "6. Delete by ID \n +" +
                "7. Sort by ID \n +" +
                "8. Convert to Binary \n +" +
                "9. Load to stack and display \n +" +
                "10. Load to queue and display \n +" +
                "0. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyList list = new MyList();
        MyStack stackList = new MyStack();
        MyQueue queueList = new MyQueue();
        OperationToProduct runTest = new OperationToProduct();
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            if (choice == 0) {
                printOut("Goodbye, Have a nice day!");
                break;
            }
            switch (choice) {
                case 1: //Read data from the file "data.TXT" and save to a linked list, then display the list to console
                    runTest.getAllItemsFromFile("data.TXT", list);
                    runTest.displayAll(list);
                    break;
                case 2: //Input and add a product to the end of the linked list
                    runTest.addLast(list);
                    printOut("List after adding");
                    runTest.displayAll(list);
                    break;
                case 3: //Display the products in the linked list
                    runTest.displayAll(list);
                    break;
                case 4: //Save the linked list to the file
                    runTest.writeAllItemsToFile("data2.TXT", list);
                    break;
                case 5: //Search a product by ID
                    runTest.searchByID(list);
                    break;
                case 6: //Delete a product by ID
                    runTest.deleteByID(list);
                    printOut("List after deleting");
                    runTest.displayAll(list);
                    break;
                case 7: //Sort products by ID
                   printOut("List before sorting: ");
                    runTest.displayAll(list);
                    printOut("List after sorting: ");
                    runTest.sortByID(list);
                    runTest.displayAll(list);
                    break;
                case 8: //Display quantity of the first product from decimal to Binary by recursive method
                    runTest.convertToBinary(list);
                    break;
                case 9: //Read file, then save to stack. Display the stack.
                    runTest.getAllItemsFromFile("data.TXT", stackList);
                    runTest.displayAll(stackList);
                    break;
                case 10:
                    //Read file, then save to queue. Display the queue.

                    runTest.getAllItemsFromFile("data.TXT", queueList);
                    runTest.displayAll(queueList);
                    break;
                /**
                 * Steps to save console ouput to a file:
                 * Run-> Edit configuration -> Modify Options -> Logs -> Save console output to file->  path file.
                 */
                default:
                    printOut("**Invalid input, type again**");
            }
        }
    }
}
