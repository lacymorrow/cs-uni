import java.awt.geom.Ellipse2D;


@SuppressWarnings("serial")
public class Segment extends Ellipse2D.Double {

	private static final int radius = 10; 
	private String direction;

	public Segment(int x, int y) {
		this.x = x;
		this.y = y;
		height = radius;
		width  = radius;
		direction = "right";
	}

	public void move() {
		
		// move snake forward
		if(direction.equals("right"))
			setFrame(x+radius, y, radius, radius);
		else if(direction.equals("left"))
			setFrame(x-radius, y, radius, radius);
		else if(direction.equals("up"))
			setFrame(x, y-radius, radius, radius);
		else if(direction.equals("down"))
			setFrame(x, y+radius, radius, radius);
		
		// wrap around walls
		if(x < 0)
			setFrame(GamePanel.WIDTH - radius, y, radius, radius);
		if(x >= GamePanel.WIDTH)
			setFrame(0, y, radius, radius);
		if(y < 0)
			setFrame(x, GamePanel.HEIGHT - radius, radius, radius);
		if(y > GamePanel.HEIGHT)
			setFrame(x, 0, radius, radius);
	}	
	
	public void setDirection(String dir) {
		direction = dir;
	}
}
