package org.example.learnsmashers.Project01;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to the number guessing game!");

        while (true) {
            System.out.println("\nEnter the difficulty level(easy, hard): ");
            String level = scanner.next().toLowerCase();

            String playAgain;
            int chances = 0;
            if (level.equals("easy"))
                chances = 10;
            else
                chances = 5;

            int numToGuess = random.nextInt(0, 101);
            int num = -1;

            while (chances != 0) {
                System.out.println("Guess the number: ");
                num = scanner.nextInt();

                if (num == numToGuess) {
                    System.out.println("You've guessed it right!");
                    break;
                } else if (num > numToGuess) {
                    System.out.println("Take a lower guess.");
                } else {
                    System.out.println("Take a higher guess.");
                }
                chances--;
            }
            if (chances == 0)
                System.out.println("\nGame Over!");
            System.out.println("The number to be guessed was: " + numToGuess);
            System.out.println("\nDo you want to play again?(y/n): ");
            playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("n"))
                break;
        }
        System.out.println("\nThan you for playing.");
    }
}
