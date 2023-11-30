/**
 * @author Josh Eggett
 * @course CS1420
 * @assignment Assignment 5
 * @date October 4, 2023
 */
package assign05;

public class Rectangle {
    /*
     * Instance variables - x, y position, and width as well as height for rectangle.
     */
    int xPosition = 0;
    int yPosition = 0;
    int width = 1;
    int height = 1;

    public Rectangle() {
    }

    /**
     * Constructor with position and width / height values as parameters to create any size / location rectangle.
     *
     * @param positionX - x pos for the rectangle to be made at
     * @param positionY - y pos for the rectangle to be made at
     * @param inWidth   - width for the rectangle
     * @param inHeight  - height for the rectangle
     */
    public Rectangle(int positionX, int positionY, int inWidth, int inHeight) {
        this.xPosition = positionX;
        this.yPosition = positionY;
        this.width = inWidth;
        this.height = inHeight;
    }

    /**
     * getter for the x position of the rectangle
     *
     * @return the x position of the rectangle
     */
    public int getX() {
        return this.xPosition;
    }

    /**
     * getter for the y position of the rectangle
     *
     * @return the y position of the rectangle
     */
    public int getY() {
        return this.yPosition;
    }

    /**
     * getter for the rectangle's width
     *
     * @return the width of the rectangle
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * getter for the rectangle's height
     *
     * @return the height of the rectangle
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * method that changes the position x and y of the rectangle, effectively moving it in space.
     *
     * @param newX the new x value of the rectangle
     * @param newY new y value of rectangle.
     */
    public void move(int newX, int newY) {
        this.xPosition = newX;
        this.yPosition = newY;
    }

    /**
     * Changes the width and height of the rectangle by an x and y factor respectively
     *
     * @param xFactor factor by which to scale the width
     * @param yFactor factor by which to scale the height
     */
    public void scale(double xFactor, double yFactor) {
        this.width = (int) (this.width * xFactor);
        this.height = (int) (this.height * yFactor);
    }

    /**
     * Method that compares the area of two rectangles and returns a boolean
     * based on whether this one is larger than the input.
     *
     * @param other the rectangle provided to compare size with
     * @return boolean whether the current rectangle is larger than the one provided
     */
    public boolean largerThan(Rectangle other) {
        int thisArea = this.width * this.height;
        int otherArea = other.height * other.width;
        if (thisArea > otherArea) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to create a new rectangle that binds the current rectangle and one provided.
     *
     * @param other - the rectangle object to provide
     * @return boundingRectangle - a rectangle object that encompasses the 2 rectangles.
     */
    public Rectangle boundingRectangle(Rectangle other) {
        Rectangle boundingRectangle = new Rectangle();
        int rightX = Math.max((this.xPosition + this.width), other.xPosition + other.width);
        int leftX = Math.min(this.xPosition, other.xPosition);
        int top = Math.max(this.yPosition + this.height, other.yPosition + other.height);
        int bottom = Math.min(this.yPosition, other.yPosition);

        boundingRectangle.width = rightX - leftX;
        boundingRectangle.height = top - bottom;

        boundingRectangle.xPosition = leftX;
        boundingRectangle.yPosition = bottom;

        return boundingRectangle;
    }

    /**
     * method to generate a string about the rectangle.
     *
     * @return string detailing information about the rectangle
     */
    public String toString() {
        return this.width + " x " + this.height + " rectangle at (" + this.xPosition + ", " + this.yPosition + ")";
    }
}
