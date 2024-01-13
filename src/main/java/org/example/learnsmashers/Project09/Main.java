package org.example.learnsmashers.Project09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to weather forecast!");

        String apiKey = "5abb6102230d411889270612241101", city = null, repeat = null;

        while(true){
            System.out.println("\nEnter the city name: ");
            city = scanner.next();
            System.out.println("Please wait...");

            FetchWeather fetch = new FetchWeather(city, apiKey);
            fetch.currentWeather();

            System.out.println("\nDo you want to search again?(y/n): ");
            repeat = scanner.next().toLowerCase();

            if (repeat.equals("n"))
                break;
        }
        System.out.println("\nThank you!");
    }
}
