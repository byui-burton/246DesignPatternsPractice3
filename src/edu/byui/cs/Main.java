package edu.byui.cs;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

	    System.out.println("Please enter the input file: ");
	    String inputFile = scanner.nextLine();

        try {
            FileProcessor processor = new FileProcessor();
            processor.processFile(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
