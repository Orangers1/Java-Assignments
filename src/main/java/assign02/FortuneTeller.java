/**
 * @author Josh Eggett
 * @course CS1420
 * @assignment Assignment 2
 * @date September 6, 2023
 */
package assign02;

import java.util.Scanner;

public class FortuneTeller {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // declare scanner object

        boolean finished = false; // boolean to make while loop work
        while (!finished) {
            System.out.println("Please tell me your name!"); // prompt user input
            String name = scanner.nextLine();

            if (name.equals("exit")) { // if they tell the program to stop then end
                finished = true;
                System.out.println("Goodbye");
            } else {    // else run program

                // sum up the name to get the number
                char currentChar;
                int sum = 0;
                for (int i = 0; i < name.length(); i++) {
                    currentChar = name.charAt(i);
                    sum += currentChar;
                }
                // calculate happiness, career, love stats
                int happiness = (sum % 42)/7;
                int career = sum%6;
                int love = (sum % 66) / 7;

                // print fortune stuff
                if ((love + career + happiness) > 7) {
                    System.out.println("Your fortune is good");
                } else {
                    System.out.println("Your fortune is bad");
                }
                System.out.println("Happiness: " + happiness);
                System.out.println("Career: " + career);
                System.out.println("Love: " + love);
                System.out.println("Lucky number: " + sum);
            }
        } // end of while loop
    }// end of main method
}   // end of class
