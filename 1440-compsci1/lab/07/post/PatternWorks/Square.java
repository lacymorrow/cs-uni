import java.awt.Rectangle;

import javax.swing.SwingUtilities;

public class Square {

	private int x;
	private int y;
	private int size;
	private String color = "black";
	private boolean isVisible;

	/**
	 * Constructor that creates a Square object of a specified location, size
	 * and color.
	 * 
	 * @param x
	 *            x position on the canvas
	 * @param y
	 *            y position on the canvas
	 * @param s
	 *            size of a side of the square
	 * @param color
	 *            color String--black, green, red, yellow, etc.
	 */
	public Square(int x, int y, int s, String color) {
		this.x = x;
		this.y = y;
		size = s;
		this.color = color;
		setVisible(true);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
//		erase();
		this.x = x;
		draw();
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
//		erase();
		this.y = y;
		draw();
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
//		erase();
		this.size = size;
		draw();
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
		draw();
	}

	/**
	 * @return the isVisible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible
	 *            the isVisible to set
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		if (!isVisible)
			erase();
		draw();
	}

	/**
	 * If it is visible, draws representation of this object onto the canvas.
	 */
	private void draw() {
		if (isVisible) {
			Canvas.getCanvas().draw(this, color, new Rectangle(x, y, size, size));
		}
	}

	/**
	 * Erases this object from the canvas if it is visible
	 */
	private void erase() {
		if (isVisible) {
			Canvas.getCanvas().erase(this);
		}
	}
}
