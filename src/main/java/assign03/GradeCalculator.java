/**
 * @author Josh Eggett
 * @course CS1420
 * @assignment Assignment 3
 * @date September 12, 2023
 */
package assign03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        boolean finished = false;
        Scanner input = new Scanner(System.in);

        while(!finished) {
            try { // use try catch to make sure we don't crash due to file not found

                // get file name to read
                System.out.println("Please input the file name with path.");
                String fileName = input.next();
                // make scanner to read file
                File file = new File(fileName);
                Scanner fileReader = new Scanner(file);

                // get average exam, lab, and quiz scores
                double examAverages = fileReader.nextDouble();
                double labAverages = fileReader.nextDouble();
                double weeklyQuizAverages = fileReader.nextDouble();

                // logic for making array of assignment scores and initializing it.

                int numAssignments = fileReader.nextInt();
                int[] assignmentScores = new int[numAssignments];
                // fill array up
                for (int i = 0; i < assignmentScores.length; i++) {
                    assignmentScores[i] = fileReader.nextInt();
                }
                // declare variables
                double averageAssignmentScores = 0;
                int numberZeroAssignmentScores = 0;
                int lowestAssignmentScore = 100;
                int highestAssignmentScore = 0;
                int medianAssignmentScore = 0;

                double courseGrade = 0;
                String gradeLetter = "";

                // loop through file and get data for assignments
                for (int i = 0; i < numAssignments; i++) {
                    if (assignmentScores[i] < lowestAssignmentScore) {
                        lowestAssignmentScore = assignmentScores[i];
                    } else if (assignmentScores[i] > highestAssignmentScore) {
                        highestAssignmentScore = assignmentScores[i];
                    }

                    if (assignmentScores[i] == 0) {
                        numberZeroAssignmentScores++;
                    }
                    // accumulate inside average assignment scores for now - divide after
                    averageAssignmentScores += assignmentScores[i];
                }
                // assignmentAvgScore was a sum, make it an average now.
                averageAssignmentScores /= numAssignments;

                // sort the array of scores and get the median using Math.floor
                Arrays.sort(assignmentScores);
                medianAssignmentScore = assignmentScores[(int) Math.floor(assignmentScores.length / 2)];

                // calculate the course grade
                if (examAverages >= 65) {
                    courseGrade = .45 * (examAverages) + .35 * averageAssignmentScores + .1 * labAverages + .1 * weeklyQuizAverages;
                } else {
                    courseGrade = examAverages;
                }
                // set the letter grade based off of course grade numeric
                if (courseGrade < 60) {
                    gradeLetter = "E";
                } else if (courseGrade < 63) {
                    gradeLetter = "D-";
                } else if (courseGrade < 67) {
                    gradeLetter = "D";
                } else if (courseGrade < 70) {
                    gradeLetter = "D+";
                } else if (courseGrade < 73) {
                    gradeLetter = "C-";
                } else if (courseGrade < 77) {
                    gradeLetter = "C";
                } else if (courseGrade < 80) {
                    gradeLetter = "C+";
                } else if (courseGrade < 83) {
                    gradeLetter = "B-";
                } else if (courseGrade < 87) {
                    gradeLetter = "B";
                } else if (courseGrade < 90) {
                    gradeLetter = "B+";
                } else if (courseGrade < 93) {
                    gradeLetter = "A-";
                } else if (courseGrade < 100) {
                    gradeLetter = "A";
                }

                // format the avg assignment score and course grade to only print two decimal places
                String formattedAverageAssignmentScores = String.format("%.02f", averageAssignmentScores);
                String formattedCourseGrade = String.format("%.02f", courseGrade);
                // print requested info
                System.out.println("Average assignment score: " + formattedAverageAssignmentScores);
                System.out.println("Median assignment score: " + medianAssignmentScore);
                System.out.println("Number of 0 assignment scores: " + numberZeroAssignmentScores);
                System.out.println("Highest assignment score: " + (int) highestAssignmentScore);
                System.out.println("Lowest assignment score: " + (int) lowestAssignmentScore);
                System.out.println("Course grade (numeric): " + formattedCourseGrade);
                System.out.println("Course grade (letter): " + gradeLetter + "\n");

                // close scanners
                fileReader.close();
                finished = true;
            } catch (IOException error) {
                System.out.println("An IOException error has occured.");
              }
        }
            input.close();

        } // end of main method
} // end of class
