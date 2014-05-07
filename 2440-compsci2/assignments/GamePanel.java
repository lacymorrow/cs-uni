import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private GameModel gameModel;
	
	public GamePanel(GameModel gm) {
		gameModel = gm;
	}
	
	//paints the background
	public void paintComponent(Graphics g) {
	        int w = getWidth();
	        int h = getHeight();
	        gameModel.setWidth(getWidth());
			gameModel.setHeight(getHeight());
	        g.setColor(Color.WHITE);
	        g.fillRect(0, 0,w,h);
	        g.setColor(Color.RED);
	        //x,y,w,h
	        g.fillRect(gameModel.getX(), gameModel.getY(),10,10);
	}
}
