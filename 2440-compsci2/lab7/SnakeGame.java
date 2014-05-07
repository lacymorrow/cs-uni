import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

/**
 * Controller Class
 * @author Thomas Morrow
 *
 */
public class SnakeGame extends KeyAdapter{

	GameView gameView;
	GameModel gameModel;
	Timer timer;
	DirectionListener dirListener;

	public SnakeGame() {
		//creates model and view objects
		gameModel = new GameModel();
		gameView = new GameView(gameModel, this);
		gameModel.setGameView(gameView);
		//creates/starts timer
		timer=new Timer(100,new move());
		timer.start();
		//creates listener for keystrokes
		dirListener = new DirectionListener();
		gameView.addKeyListener(getDirectionListener());
	}

	class move implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			//when timer fires
			gameModel.move();
		}
	}
	class DirectionListener extends KeyAdapter {
		public void keyPressed(KeyEvent ke){
			//choose direction from keystroke
			if(ke.isActionKey()){
				if(ke.getKeyCode() == 37){
					//left
					gameModel.setDir(false, true);
				}else if(ke.getKeyCode() == 38){
					//up
					gameModel.setDir(true, true);
				}else if(ke.getKeyCode() == 39){
					//right
					gameModel.setDir(false, false);
				}else if(ke.getKeyCode() == 40){
					//down
					gameModel.setDir(true, false);
				}
			}
		}
	}

	public KeyAdapter getDirectionListener(){
		return dirListener;
	}

	// start the game
	public static void main(String[] args) {
		new SnakeGame();
	}
}
