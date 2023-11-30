package lab6;

import lab6.*;

import java.util.ArrayList;

public class Lab06 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach( n -> System.out.println(n));
    }
}
class PositiveIntegers {
    int[] array;
    PositiveIntegers(int[] paramArray) {
        this.array = paramArray.clone();
    }
    public void setElement(int index, int item) {
        if (!(index >= array.length || index < 0)) {
            array[index] = item;
        } else {
            System.out.println("Given index is out of bounds");
        }
    }
}
