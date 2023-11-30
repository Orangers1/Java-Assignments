package CS1420.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import CS1420.ansiColors.*;

public class HelloWorld {

    public static String spellCheck(File file, String word) throws FileNotFoundException {
        String checkedWord = word;
        boolean hasCorrectWord = false;

        if (file.canRead()) {
            Scanner fileReader = new Scanner(file);
            String currentWord;

            while (fileReader.hasNext())
            {
                currentWord = fileReader.next();

                if (word.compareTo(currentWord) == 0) { // uses return to end the loop early upon finding it.
                    checkedWord = word;
                    return checkedWord;
                } else if (word.compareTo(currentWord) < 0) {
                    // this will give the closest word to whatever we looking at if we pass it up
                    checkedWord = currentWord;
                    System.out.println(word.compareTo(currentWord));

                    return checkedWord;
                }
            }
            fileReader.close();
            return checkedWord;
        }
        return checkedWord;
    }

    public static int countWords(File file) throws FileNotFoundException {
        int wordCount = 0;
        if (file.canRead()) {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNext()) {
                fileReader.next();
                wordCount++;
            }
            fileReader.close();
        } else {
            wordCount = -1;
        }

        return wordCount;
    }

    public static void main(String[] args) {


    }
}