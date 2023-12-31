package assign05;


/**
 * This class uses objects of the Rectangle and Circle classes.
 * It uses several methods from each class to confirm that they
 * are working correctly.
 *
 * @author Prof. Heisler and Josh Eggett
 * @version October 4, 2023
 */
public class ShapesDemo {

    /**
     * The main method simply calls the demo methods for each part.
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
         * After creating the Rectangle class in part 1,
         * this method works with your Rectangle class.
         */
        demoPartOne();

        /*
         * After creating the Circle class in part 2,
         * uncomment this method call to check Circle.
         */
        demoPartTwo();
    }

    /**
     * This method works with only the Rectangle class for assignment part 1.
     */
    public static void demoPartOne() {
        // Create some Rectangle objects
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5, 7, 10, 20);
        // r3 is a 5 X 15 rectangle at (-10, 8)
        // r4 is a 2 X 2 rectangle at (1, 1)
        Rectangle r3 = new Rectangle(-10, 8, 5, 15);
        Rectangle r4 = new Rectangle(1, 1, 2, 2);

        // getX
        System.out.println("Checking getX:");
        printResult("5", "" + r2.getX());
        printResult("-10", "" + r3.getX());
        System.out.println("");

        // getY
        System.out.println("Checking getY:");
        printResult("7", "" + r2.getY());
        printResult("8", "" + r3.getY());
        System.out.println("");

        // getWidth
        System.out.println("Checking getWidth:");
        printResult("10", "" + r2.getWidth());
        printResult("5", "" + r3.getWidth());
        System.out.println("");

        // getHeight
        System.out.println("Checking getHeight:");
        printResult("20", "" + r2.getHeight());
        printResult("15", "" + r3.getHeight());
        System.out.println("");

        // move
        System.out.println("Checking move:");
        r1.move(4, 12);
        printResult("4", "" + r1.getX());
        printResult("12", "" + r1.getY());

        r3.move(2, 2);
        printResult("2", "" + r3.getX());
        printResult("2", "" + r3.getY());

        System.out.println("");

        // scale
        System.out.println("Checking scale:");
        r1.scale(11, 2);
        printResult("11", "" + r1.getWidth());
        printResult("2", "" + r1.getHeight());

        r3.scale(2, 2);
        printResult("10", "" + r3.getWidth());
        printResult("30", "" + r3.getHeight());

        System.out.println("");

        // largerThan
        System.out.println("Checking larger than:");
        printResult("false", "" + r1.largerThan(r2));

        printResult("true", "" + r3.largerThan(r4));
        System.out.println("");

        // toString
        System.out.println("Checking toString:");
        printResult("10 x 20 rectangle at (5, 7)", r2.toString());

        printResult("10 x 30 rectangle at (2, 2)", r3.toString());
        System.out.println("");

        // bounding rectangle
        System.out.println("Checking bounding rectangle:");
        Rectangle boundR1R2 = r1.boundingRectangle(r2);
        printResult("11 x 20 rectangle at (4, 7)", "" + boundR1R2);

        Rectangle boundR3R4 = r3.boundingRectangle(r4);
        printResult("11 x 31 rectangle at (1, 1)", "" + boundR3R4);
        System.out.println("");
    }

    /**
     * This method works with both classes for assignment part 2.
     */
    public static void demoPartTwo() {
        // Create some Circle objects
        Circle c1 = new Circle();
        Circle c2 = new Circle(4, 5, 6);
        // c3 is an r = 10 circle at (0, 0)
        // c4 is an r = 2 circle at (88, 88)
        Circle c3 = new Circle(0, 0, 10);
        Circle c4 = new Circle(88, 88, 2);

        // getX
        System.out.println("Checking getX:");
        printResult("4", "" + c2.getX());

        printResult("0", "" + c3.getX());
        System.out.println("");

        // getY
        System.out.println("Checking getY:");
        printResult("5", "" + c2.getY());

        printResult("0", "" + c3.getY());
        System.out.println("");

        // getRadius
        System.out.println("Checking getRadius:");
        printResult("6", "" + c2.getRadius());

        printResult("10", "" + c3.getRadius());
        System.out.println("");

        // move
        System.out.println("Checking move:");
        c1.move(-2, -3);
        printResult("-2", "" + c1.getX());
        printResult("-3", "" + c1.getY());

        c4.move(3, 3);
        printResult("3", "" + c4.getX());
        printResult("3", "" + c4.getY());

        System.out.println("");

        // scale
        System.out.println("Checking scale:");
        c1.scale(10);
        printResult("10", "" + c1.getRadius());

        c4.scale(4);
        printResult("8", "" + c4.getRadius());
        System.out.println("");

        // largerThan
        System.out.println("Checking larger than:");
        printResult("true", "" + c1.largerThan(c2));

        printResult("false", "" + c4.largerThan(c3));
        System.out.println("");

        // toString
        System.out.println("Checking toString:");
        printResult("r = 6 circle at (4, 5)", c2.toString());

        printResult("r = 10 circle at (0, 0)", c3.toString());
        System.out.println("");

        // bounding rectangle 1
        System.out.println("Checking bounding rectangle 1:");
        Rectangle boundC2 = c2.boundingRectangle();
        printResult("12 x 12 rectangle at (-2, -1)", "" + boundC2);

        Rectangle boundC3 = c3.boundingRectangle();
        printResult("20 x 20 rectangle at (-10, -10)", "" + boundC3);
        System.out.println("");

        // bounding rectangle 2
        System.out.println("Checking bounding rectangle 2:");
        Rectangle boundC1C2 = c1.boundingRectangle(c2);
        printResult("22 x 24 rectangle at (-12, -13)", "" + boundC1C2);

        Rectangle boundC3C4 = c3.boundingRectangle(c4);
        printResult("21 x 21 rectangle at (-10, -10)", "" + boundC3C4);
        System.out.println("");
    }

    /**
     * A private helper method for printing out a useful message.
     *
     * @param expected - expected output
     * @param actual   - actual output
     */
    private static void printResult(String expected, String actual) {
        System.out.println("Expected: " + expected);
        System.out.println("   Yours: " + actual);
    }
}
