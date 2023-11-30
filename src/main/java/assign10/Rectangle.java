package assign10;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a rectangle, which is a Shape2D.
 * 
 * @author Prof. Heisler
 * @version Nov. 6, 2023
 */
public class Rectangle extends Shape2D{
	private int width;
	private int height;
	
	/**
	 * Construct a Rectangle with the given position, size, color, and filled property.
	 * 
	 * @param posX - x position
	 * @param posY - y position
	 * @param width
	 * @param height
	 * @param color
	 * @param filled - true if it will be drawn filled
	 */
	public Rectangle(int posX, int posY, int width, int height, Color color, boolean filled) {
		super(posX, posY, color, filled);
		this.width = width;
		this.height = height;
	}

	// TODO implement the inherited abstract methods

	@Override
	public void resize(int sizeX, int sizeY) {
		this.width = sizeX;
		this.height = sizeY;
	}

	@Override
	public void draw(Graphics g, double zoom) {
		System.out.println("trying to draw a rectangle");
		g.setColor(getColor());
		g.drawRect(this.getX(), this.getY(), width, height);
	}

}
