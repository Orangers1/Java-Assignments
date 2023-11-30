package lab07;

import java.util.Random;
/**
 * This class contains code for practice using the Eclipse debugger (Lab 7).
 * 
 * @author Prof. Parker
 * @version September 28, 2023
 */
class Fractionz {
	private int numerator;
	private int denominator;
	public Fractionz(int numerator, int denominator) {
		numerator = numerator;
		denominator = denominator;
	}
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
}
public class DebugPractice {

	public static void main(String[] args) {



		Fractionz half = new Fractionz(1, 2);
		System.out.println(half.getNumerator() + " " + half.getDenominator());
	}
}