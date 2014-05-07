import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A canvas class for drawing shapes. Used
 * instead of BlueJ Canvas class.
 * Works in a similar fashion (has some
 * of the same drawbacks) but it is
 * customizable for our purposes.
 * 
 * @author BarryEF
 *
 */
public class Canvas extends JFrame {
	
	private List<Object> objectList = Collections.synchronizedList(new ArrayList<Object>());
	private Map<Object,ShapeInfo> shapeMap = Collections.synchronizedMap(new HashMap<Object,ShapeInfo>());
	private static Canvas canvas = null;
	private ViewPanel panel = null;
	private final static Dimension panelSize = new Dimension(600,600);
	
	
	public static void main(String[] args){
		Canvas c = Canvas.getCanvas();
	}
	
	/**
	 * Provides access to the singleton canvas
	 * 
	 * @return canvas - the single Canvas object
	 */
	public static Canvas getCanvas(){
		if(canvas == null){
			canvas = new Canvas();
		}
		return canvas;
	}
	private Canvas(){
		super("CS 1440 PatternWorks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new ViewPanel();
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/**
	 * sets the title of the JFrame
	 */
	public void setTitle(String t){
		setTitle(t);
	}
	/**
	 * causes a shape to be redrawn on the panel.
	 * Since the shape's state may have changed,
	 * it is removed from the list, then re-added to 
	 * the list. 
	 */
	public void draw(Object refObject, String color, Shape shape){
		Color c = getColor(color);
		objectList.remove(refObject);
		objectList.add(refObject);
		shapeMap.put(refObject, new ShapeInfo(shape, c));
		panel.repaint();
	}
	
	public void erase(Object refObject){
		objectList.remove(refObject);
		shapeMap.remove(refObject);
		panel.repaint();
	}
	/**
	 * Static method for clearing the canvas
	 */
	public static void clear(){
		getCanvas().eraseAll();
	}
	
	/**
	 * Erases canvas, removing all objects
	 */
	public void eraseAll(){
		objectList.clear();
		shapeMap.clear();
		panel.repaint();
	}
	/**
	 * Converts a String to a color. Standard colors
	 * are checked first, it checks for a color string
	 * specified as a 24-bit hex or octal number.
	 * 
	 * @param color
	 * @return Color object corresponding to input String
	 * 
	 */
	private Color getColor(String color){
		if(color.equals("blue") || color.equals("BLUE"))
			return Color.blue;
		else if(color.equals("red") || color.equals("RED"))
			return Color.red;
		else if(color.equals("black") || color.equals("BLACK"))
			return Color.black;
		else if(color.equals("cyan") || color.equals("CYAN"))
			return Color.cyan;
		else if(color.equals("gray") || color.equals("GRAY"))
			return Color.gray;
		else if(color.equals("green") || color.equals("GREEN"))
			return Color.green;
		else if(color.equals("magenta") || color.equals("MAGENTA"))
			return Color.magenta;
		else if(color.equals("orange") || color.equals("ORANGE"))
			return Color.orange;
		else if(color.equals("pink") || color.equals("PINK"))
			return Color.pink;
		else if(color.equals("white") || color.equals("WHITE"))
			return Color.white;
		else if(color.equals("yellow") || color.equals("YELLOW"))
			return Color.yellow;
		else {
			try {
				// Treat as a hex string in RGB format, e.g. "0xAABBCC"
				return Color.decode(color);
			}catch(Exception e){
				System.out.println("Invalid color string. Setting default.");
				return Color.black;
			}
			
		}

	}
	/**
	 * Panel used for drawing
	 * @author BarryEF
	 *
	 */
	class ViewPanel extends JPanel {

		public ViewPanel(){
			panel = this;
			setPreferredSize(panelSize);
		}
		/**
		 * draw contents of panel
		 */
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			
			/**
			 * we're using a synchronized list and it is required
			 * that iteration over the list be explicitly synchronized
			 * to avoid concurrent modification exceptions.
			 */
			synchronized(objectList){
				for(Iterator it = objectList.iterator(); it.hasNext();){
					ShapeInfo si = shapeMap.get(it.next());
					if(si != null){
						si.draw(g2);
					}
				}
			}
		}
		
	} // end ViewPanel
	/**
	 * Class used to store some side-info
	 * about a shape to be drawn.
	 * @author BarryEF
	 *
	 */
	class ShapeInfo {
		private Color color;
		private Shape shape;
		public ShapeInfo(Shape s, Color c){
			color = c;
			shape = s;
		}
		public void draw(Graphics2D g2){
			Color tempc = g2.getColor();
			g2.setColor(color);     // change to shape's color
			g2.fill(shape);         // fill shape
			g2.setColor(tempc);     
		}
	} // end ShapeInfo
	

} // end class
