package assign06;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tester for the Word class.
 *
 * @author Prof. Parker and Josh Eggett
 * @version 1.0
 */
public class WordTester {

    /**
     * Test that the Word class constructor properly throws an exception when
     * the given string contains characters that are not a-z or A-Z.
     */
    @Test
    public void testConstructorException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Word("hel!o");
        });
    }

    /**
     * Test that the Word class constructor properly sets the private instance
     * variable, which is used to generate and return a String in the toString method.
     */
    @Test
    public void testToStringNormal() {
        Word normal = new Word("Normal");
        assertEquals("Normal", normal.toString());
    }

    /**
     * Test that the Word class constructor properly sets the private instance
     * variable when an empty string is provided.
     */
    @Test
    public void testToStringEdgeCases() {
        Word case1 = new Word("");
        assertEquals("", case1.toString());
    }

    /**
     * Test if the isPalindrome method correctly identifies a palindrome word.
     */
    @Test
    public void testIsPalindromeTrue() {
        Word palindrome = new Word("saippuakivikauppias");
        assertTrue(palindrome.isPalindrome());
    }

    /**
     * Test if the isPalindrome method correctly identifies a single-letter word as a palindrome.
     */
    @Test
    public void testIsPalindromeOneLetter() {
        Word oneLetter = new Word("a");
        assertTrue(oneLetter.isPalindrome());
    }

    /**
     * Test if the isPalindrome method correctly identifies a non-palindrome word.
     */
    @Test
    public void testIsPalindromeFalse() {
        Word palindrome = new Word("steveapsdjf");
        assertFalse(palindrome.isPalindrome());
    }

    /**
     * Test if the isPalindrome method correctly identifies an empty word as not a palindrome.
     */
    @Test
    public void testIsPalindromeEmpty() {
        Word palindrome = new Word("");
        assertFalse(palindrome.isPalindrome());
    }

    /**
     * Test that the replaceLetter method properly throws an exception when an invalid character is provided as the first argument.
     */
    @Test
    public void testDoesPalindromeChangeState() {
        Word firstWord = new Word("aabbccddccbbaa");
        Word secondWord = firstWord;
        secondWord.isPalindrome();
        assertEquals(firstWord.toString(), secondWord.toString());
    }

    /**
     * Test that the replaceLetter method properly throws an exception when an invalid character is provided as the first argument.
     */
    @Test
    public void testReplaceLetterExceptionFirstArg() {
        Word oneLetter = new Word("a");
        assertThrows(IllegalArgumentException.class, () -> {
            oneLetter.replaceLetter(' ', 'l');
        });
    }

    /**
     * Test that the replaceLetter method properly throws an exception when an invalid character is provided as the second argument.
     */
    @Test
    public void testReplaceLetterExceptionSecondArg() {
        Word word = new Word("steve");
        assertThrows(IllegalArgumentException.class, () -> {
            word.replaceLetter('l', ' ');
        });
    }

    /**
     * Test that the replaceLetter method correctly replaces the specified character in the word with another character.
     */
    @Test
    public void testReplaceLetterHello() {
        Word hello = new Word("hello");
        assertEquals("hesso", hello.replaceLetter('l', 's').toString());
    }

    /**
     * Test that the replaceLetter method does not make any changes if no matches are found.
     */
    @Test
    public void testReplaceLetterNoMatches() {
        Word word = new Word("Steve");
        assertEquals("Steve", word.replaceLetter('z', 'f').toString());
    }

    /**
     * Test that the replaceLetter method works as expected for an empty word.
     */
    @Test
    public void testReplaceLetterEmptyWord() {
        Word word = new Word("");
        assertEquals("", word.replaceLetter('z', 'f').toString());
    }

    /**
     * Test that the reverse method correctly reverses the characters in the word.
     */
    @Test
    public void testReverseHello() {
        Word hello = new Word("hello");
        hello.reverse();
        assertEquals("olleh", hello.toString());
    }

    /**
     * Test that the reverse method has no effect on an empty word.
     */
    @Test
    public void testReverseEmpty() {
        Word empty = new Word("");
        empty.reverse();
        assertEquals("", empty.toString());
    }

    /**
     * Test that the reverse method has no effect on a palindrome word.
     */
    @Test
    public void testReversePalindrome() {
        Word palindrome = new Word("asdfdsa");
        palindrome.reverse();
        assertEquals("asdfdsa", palindrome.toString());
    }

    /**
     * Test that the reverse method has no effect on a single-character word.
     */
    @Test
    public void testReverseOneCharacter() {
        Word one = new Word("A");
        one.reverse();
        assertEquals("A", one.toString());
    }
}