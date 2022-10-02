package edu.bsu.cs222;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        WikipediaRevisionReader.getRevisionInfo(input);
        if (input.isBlank()) {
            System.err.println("No value entered.");
            System.exit(2);
        }
    }
}
