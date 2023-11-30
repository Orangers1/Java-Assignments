/**
 * @author Josh Eggett
 * @course CS1420
 * @assignment Assignment 1
 * @date August 23, 2023
 */
package assign01;

public class FluidCalculator {

    public static void main (String[] args) {
        // UID is in FL. Oz -> Convert to Gallons, then print leftover quarts, cups, and ounces
        int uid = 1433303;
        // calculate remainder after simplify to gallons
        int remainder = uid%128;
        // calculate gallons, then how many oz are left to do next with
        int gallons = (uid - remainder)/128;
        int newOz = uid - gallons*128;
        // do same as above but with new number and 32 because thats how many oz are in a quart
        int  quarts = (newOz - newOz%32)/32;
        int newerOz = newOz - quarts*32;
        // see above
        int cups = (newerOz - newerOz%8)/8;
        int ounces= newerOz - cups*8;
        // print output
        System.out.println(uid + " fluid ounces is equivalent to " + gallons + " gallon(s), " +
                quarts + " quart(s), " + cups + " cup(s), and " + ounces + " ounce(s).");
    }
}