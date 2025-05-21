package lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables and printing them
        String hello = "HELLO!!";
        System.out.println(hello);

        //Taking input from user and conditionals
        Scanner input = new Scanner(System.in);
        System.out.println("How is your day? ");
        String day = input.nextLine();
        if (day.equals("Good" )) {
            System.out.println("Awesome!");
        } else if (day.equals("Great")) {
            System.out.println("Awesome!");
        } else if (day.equals("Awesome")) {
            System.out.println("Awesome!");
        }else {
            System.out.println("Sorry. Hope your day gets better!");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many friends do you have? ");
        int Numfriends = scanner.nextInt();
        scanner.nextLine();
        //Using arrays and a loop
        String[] friends = new String[Numfriends];
        for (int i = 0; i < Numfriends; i++) {
            System.out.println("What is his/her name# "+ (i+1) + ":" );
            friends[i] = scanner.nextLine();
        }
        System.out.println("These are your friends: ");
        for (String name : friends) {
            System.out.println(name);
        }
        pickRandomBestFriend(friends);
        System.out.println("Let's try writing something into a file...!");
        Scanner fileScanner = new Scanner(System.in);
        System.out.println("What file do you want to write? ");
        String fileName = fileScanner.nextLine();
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("Hello this is nice file you got here\n");
            fileWriter.write("Just adding more stuff here\n");
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Something went wrong!!");
        }

        }

    /**
     * Repeatedly selects a random friend and aks the user
     * if that friend is their best friend and stops once the user answers
     * "yes" specifically with a lower-case "y"
     * @param friends which is an array of friends entered by the user
     */
    public static void pickRandomBestFriend(String[] friends) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        while (true){
            int index = rand.nextInt(friends.length);
            String friend = friends[index];
            System.out.println("Is " + friend + " your best friend?(yes/no)");
            String answer = input.nextLine();
            if (answer.equals("yes")) {
                System.out.println("Awesome! I got it right 😁😁");
                break;
            } else if (answer.equals("no")) {
                System.out.println("Hmmm🤔🤔 let's try again.");
            }
        }
        }
        }






