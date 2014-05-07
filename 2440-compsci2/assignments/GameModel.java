
public class GameModel {

	private GameView gameView;
	private int x = 0;
	private int y = 0;
	private int width;
	private int height;
	
	// Fields for all game elements: players, objects, score, etc.
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = (x>=width)? 0 : x ;
		gameView.somethingChanged();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = (y>=height)? 0 : y;
		gameView.somethingChanged();
	}

	public GameModel() {
		
		// create the objects you want in the game
		// you will need to create some new classes for most/all of the objects
	}
	
	public void setGameView(GameView gv) {
		gameView = gv;
	}
}
