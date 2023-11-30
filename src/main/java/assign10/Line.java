package assign10;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a line, which is a Shape2D.
 * 
 * @author Prof. Heisler
 * @version Nov. 6, 2023
 */
public class Line extends Shape2D{
	private int endX;
	private int endY;
	
	/**
	 * Construct a Line with the given end positions, color, and filled property.
	 * 
	 * @param startX - x position of start point
	 * @param startY - y position of start point
	 * @param endX - x position of end point
	 * @param endY - y position of end point
	 * @param color
	 * @param filled - has no effect on a Line object, but is needed by Shape2D
	 */
	public Line(int startX, int startY, int endX, int endY, Color color, boolean filled) {
		super(startX, startY, color, filled);
		this.endX = endX;
		this.endY = endY;
	}

	// TODO implement the inherited abstract methods
	@Override
	public void resize(int sizeX, int sizeY) {
		this.endX = this.endX * sizeX;
		this.endY = this.endY * sizeY;
	}

	@Override
	public void draw(Graphics g, double zoom) {
		g.drawLine(this.getX(), this.getY(), this.endX, this.endY);
	}

}
