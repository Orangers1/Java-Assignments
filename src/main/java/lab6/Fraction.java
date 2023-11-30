package lab6;

/**
 * This class represents a fraction; e.g., 1/2.
 *
 * @author Prof. Parker and Prof. Heisler
 * @version September 20, 2023
 */
public class Fraction {

    private int numerator;
    private int denominator;

    /**
     * This constructor builds a "default" Fraction object 0/1.
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * This constructor builds a Fraction object, given a numerator and denominator.
     *
     * @param numerator - value for initializing the numerator
     * @param denominator - value for initializing the denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    /**
     * Getter method for accessing the numerator of this Fraction object.
     *
     * @return the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Getter method for accessing the denominator of this Fraction object.
     *
     * @return the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * This method calculates the decimal-point equivalent of this Fraction object.
     *
     * @return the decimal-point equivalent
     */
    public double toDouble() {
        return numerator / (double) denominator;
    }

    /**
     * This method generates a textual representation of this Fraction object.
     *
     * @return a string containing the textual representation
     */
    public String toString() {
        return numerator + "/" + denominator;
    }
    private int gcd() {
      // stores minimum(a, b)
        int a = this.numerator;
        int b = this.denominator;
            int i;
            if (a < b)
                i = a;
            else
                i = b;

            // take a loop iterating through smaller number to 1
            for (i = i; i > 1; i--) {

                // check if the current value of i divides both
                // numbers with remainder 0 if yes, then i is
                // the GCD of a and b
                if (a % i == 0 && b % i == 0)
                    return i;
            }

            // if there are no common factors for a and b other
            // than 1, then GCD of a and b is 1
            return 1;
        }
        // Driver method
        public static void main(String[] args)
        {
            int a = 30, b = 20;

        }
    /**
     * This method determines whether this Fraction object and the given
     * object are equal.
     *
     * @param other - the other object to compare
     * @return true if the two objects are equal, false otherwise
     */
    public boolean equals(Object other) {
        if (!(other instanceof Fraction))
            return false;
        Fraction otherFraction = (Fraction) other;
        return this.numerator == otherFraction.numerator &&
                this.denominator == otherFraction.denominator;
    }
}