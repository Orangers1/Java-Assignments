/**
 * @author Josh Eggett
 * @course CS1420
 * @assignment Assignment 5
 * @date October 4, 2023
 */
package assign05;

public class Circle {
    // instance variables - x,y position, radius.
    int xPosition = 0;
    int yPosition = 0;
    int radius = 1;

    /**
     * Empty constructor.
     */
    public Circle() { }

    /**
     * Constructor to make a circle with given information.
     *
     * @param positionX - position of circle on x-axis
     * @param positionY - position of circle on y-axis
     * @param inRadius  - radius of the circle to be made
     */
    public Circle(int positionX, int positionY, int inRadius) {
        this.xPosition = positionX;
        this.yPosition = positionY;
        this.radius = inRadius;
    }

    /**
     * getter for the x position of the circle
     *
     * @return x position of circle
     */
    public int getX() {
        return this.xPosition;
    }


    /**
     * getter for the y position of the circle
     *
     * @return y position of circle
     */
    public int getY() {
        return this.yPosition;
    }

    /**
     * getter for the radius position of the circle
     *
     * @return radius of circle
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * method that changes the position x and y of the circle, effectively moving it in space.
     * @param newX the new x value of the circle
     * @param newY new y value of circle.
     */
    public void move(int newX, int newY) {
        this.xPosition = newX;
        this.yPosition = newY;
    }

    /**
     * Method scaling the circle by a factor
     * @param factor factor by which to scale the circle.
     */
    public void scale(double factor) {
        this.radius = (int) (this.radius * factor);
    }

    /**
     * Method comparing size of two circles.
     * @param other - the circle to compare with
     * @return boolean whether this circle is larger than the other circle
     */
    public boolean largerThan(Circle other) {
        if (this.radius > other.radius) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method which creates a rectangle bounding the circle.
     * @return the rectangle bounding this circle
     */
    public Rectangle boundingRectangle() {
        Rectangle boundingRectangle = new Rectangle();
        int rightX = (this.xPosition + this.radius);
        int leftX = (this.xPosition - this.radius);
        int top = (this.yPosition + this.radius);
        int bottom = (this.yPosition - radius);

        boundingRectangle.width = rightX - leftX;
        boundingRectangle.height = top - bottom;

        boundingRectangle.xPosition = leftX;
        boundingRectangle.yPosition = bottom;

        return boundingRectangle;
    }

    /**
     * Method that creates a rectangle which bounds the circle and another circle provided
     * @param other the circle you provide to include in the bound range.
     * @return the rectangle bounding the circles.
     */
    public Rectangle boundingRectangle(Circle other) {
        Rectangle boundingRectangle = new Rectangle();
        int rightX = Math.max((this.xPosition + this.radius), other.xPosition + other.radius);
        int leftX = Math.min(this.xPosition - this.radius, other.xPosition - other.radius);
        int top = Math.max(this.yPosition + this.radius, other.yPosition + other.radius);
        int bottom = Math.min(this.yPosition - radius, other.yPosition - radius);

        boundingRectangle.width = rightX - leftX;
        boundingRectangle.height = top - bottom;

        boundingRectangle.xPosition = leftX;
        boundingRectangle.yPosition = bottom;

        return boundingRectangle;
    }

    /**
     *  Method that generates a string with information about the circle
     * @return the string detailing the circle
     */
    public String toString() {
        return "r = " + this.radius + " circle at (" + this.xPosition + ", " + this.yPosition + ")";
    }
}