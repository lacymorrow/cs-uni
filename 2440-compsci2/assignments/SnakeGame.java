import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SnakeGame {
		
	GameView gameView;
	GameModel gameModel;
	Timer timer;
	
	public SnakeGame() {
		gameModel = new GameModel();
		gameView = new GameView(gameModel, this);
		gameModel.setGameView(gameView);
		timer=new Timer(10,new move());
		timer.start();
	}

	class move implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
		gameModel.setY(gameModel.getY()+5);
		}
	}

	// start the game
	public static void main(String[] args) {
		new SnakeGame();
	}
}
