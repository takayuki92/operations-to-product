package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PrintOut {
    //method to print out both to console and to a text file with new line
    static void printOut(String output) {
        try{
            PrintStream console = System.out;
            PrintStream ps = new PrintStream(new FileOutputStream("console_output.txt", true), true);
            System.setOut(ps);
            System.out.println(output);
            System.setOut(console);
            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //method to print out both to console and to a text file with same line
    static void printOut2(String output) {
        try{
            PrintStream console = System.out;
            PrintStream ps = new PrintStream(new FileOutputStream("console_output.txt", true), true);
            System.setOut(ps);
            System.out.print(output);
            System.setOut(console);
            System.out.print(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


