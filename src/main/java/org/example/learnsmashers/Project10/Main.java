package org.example.learnsmashers.Project10;

import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to prime number checker!");
        String repeat = null;

        while (true) {
            System.out.println("\nEnter the number: ");
            int num = scanner.nextInt();

            IsPrime isPrime = new IsPrime(num);
            if (isPrime.check()) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
            System.out.println("\nDo you wish to check for another number?(yes/no)");
            repeat = scanner.next();

            if (repeat.equals("no"))
                break;
        }

        System.out.println("Thank you!");
    }
}
