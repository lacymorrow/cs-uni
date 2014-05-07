import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * View Class
 * @author Thomas Morrow
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private GameModel gameModel;
	private int[] food;
	
	public GamePanel(GameModel gm) {
		gameModel = gm;
		gm.setGamePanel(this);
	}
	public void setFood(int[4] fd){
		food = fd;
	}
	
	//paints the background
	public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
	        int w = getWidth();
	        int h = getHeight();
	        gameModel.setWidth(getWidth());
			gameModel.setHeight(getHeight());
			g2d.setColor(Color.WHITE);
	        g2d.fillRect(0, 0,w,h);
	        g2d.setColor(Color.GREEN);
	        for(Segment seg : gameModel.getSnake()){
	        	g2d.fill(seg);
	        }
	        g2d.setColor(Color.BLUE);
	        g2d.fillOval(food[0],food[1],food[2],food[3]);
	}
}
