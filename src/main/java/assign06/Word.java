package assign06;

public class Word {
    private char[] letters;

    /**
     * Constructor for word that takes in a string to make the word out of.
     *
     * @param word - The string word that you want to initialize the word to
     * @throws IllegalArgumentException - word only takes letters, if your word contains other characters will throw.
     */
    public Word(String word) throws IllegalArgumentException {
        letters = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (!isLetter(word.charAt(i))) {
                throw new IllegalArgumentException("The character given at index " + i + " was not a letter!");
            }
            letters[i] = word.charAt(i);

        }
    }

    /**
     * Method to check if a given character is a letter
     *
     * @param character - the character to check whether or not it is a letter
     * @return - boolean whether letter or not (true if it is a letter)
     */
    public static boolean isLetter(char character) {
        if (character < 'A') {
            return false;
        } else if (character > 'z') {
            return false;
        } else if (character > 'Z' && character < 'a') {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Generates and returns a String object to represent this Word object
     * (driver method).
     *
     * @return a String object that represents this Word object
     */
    public String toString() {
        return toString(0);
    }

    /**
     * Generates and returns a String object to represent the letters of
     * this Word object from a given index to the last index (recursive method).
     *
     * @param startIndex - index at which to start
     * @return the letters of this Word from startIndex to the last index, as a String
     */
    private String toString(int startIndex) {
        // base case
        if (startIndex == letters.length)
            return "";
        // recursive case
        return letters[startIndex] + toString(startIndex + 1);
    }

    /**
     * public driver method for recursive isPalindrome. Will determine whether or not this word is a palindrome.
     *
     * @return - boolean whether or not it is a palindrome (same forwards as backwards)
     */
    public boolean isPalindrome() {
        return isPalindrome(0, letters.length - 1);
    }

    /**
     * recursive method of isPalindrome. Checks letters outside in to determine matches.
     *
     * @param startIndex - first letter being checked
     * @param endIndex   - second letter being checked
     * @return - false if the letters don't match, true if it has made it through the entire word. false if the word is empty.
     */
    private boolean isPalindrome(int startIndex, int endIndex) {
        // base case 1
        if (letters.length == 0) {
            return false; // I chose false because the word can't be the same forwards as backwards if there isn't a word, but I could see forwards being argued.
        }
        char firstLetter = letters[startIndex];
        char secondLetter = letters[endIndex];
        // base case 2
        if (firstLetter != secondLetter)
            return false;

        // recursive case
        if (startIndex >= endIndex)
            return true;

        return isPalindrome(startIndex + 1, endIndex - 1);
    }

    /**
     * driver method for recursive replaceLetter
     *
     * @param letter      - letter you want to get replaced
     * @param replacement - what you want to replace the letter with
     * @return - returns the word that has had letters replaced, new object
     */
    public Word replaceLetter(char letter, char replacement) {
        Word replacedWord = this;
        replacedWord.replaceLetter(letter, replacement, 0);
        return replacedWord;
    }

    /**
     * Replaces letters
     *
     * @param letter      - letter to replace
     * @param replacement - letter to replace with
     * @param startIndex  - what letter currently on in the word
     * @return - new string object of the word but with the replaced letters.
     * @throws IllegalArgumentException - if characters aren't a letter it will throw
     */
    private String replaceLetter(char letter, char replacement, int startIndex) throws IllegalArgumentException {
        //base case empty
        if (this.letters.length == 0) {
            return "";
        }
        // base case end of word
        if (startIndex >= this.letters.length) {
            return this.toString();
        }
        // base case either arg is not letter
        if (!(isLetter(letter))) {
            throw new IllegalArgumentException("The letter to replace " + letter + " is not a letter.");
        }
        if (!(isLetter(replacement))) {
            throw new IllegalArgumentException("The replacement letter " + replacement + " is not a letter.");
        }

        // recursive case
        if (this.letters[startIndex] == letter) {
            this.letters[startIndex] = replacement;
        }
        return replaceLetter(letter, replacement, startIndex + 1);
    }

    /**
     * driver method for recursive reverse which reverses this word.
     */
    public void reverse() {
        reverse(0, letters.length - 1);
    }

    /**
     * reverses this word.
     *
     * @param startIndex - current letter on first half
     * @param endIndex   - opposite corresponding letter
     */
    private void reverse(int startIndex, int endIndex) {
        // base case 1
        if (letters.length == 0) {
            return;
        }
        // base case 2
        if (startIndex >= endIndex) {
            return;
        }

        // recursive case
        char replace = letters[startIndex];
        letters[startIndex] = letters[endIndex];
        letters[endIndex] = replace;

        reverse(startIndex + 1, endIndex - 1);
    }
}
