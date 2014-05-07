import java.awt.Dimension;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class GameView extends JFrame {	
	private GameModel gameModel;
	private SnakeGame gameController;
	
	private GamePanel gamePanel;
	
	public GameView(GameModel gm, SnakeGame sg) {
		super("Snake EXTREME");
		setPreferredSize(new Dimension(500,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameController = sg;
		gameModel = gm;
		
		gamePanel = new GamePanel(gm);
		this.add(gamePanel);
		
		this.pack();
		this.setVisible(true);
	}
	
	// When the Model is updated, it will call this method
	public void somethingChanged() {
		gamePanel.repaint();
	}
}
