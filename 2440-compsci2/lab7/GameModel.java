/**
 * Model Class
 * @author Thomas Morrow
 *
 */
public class GameModel {

	private GameView gameView;
	private int x = 0;
	private int y = 0;
	private int width;
	private int height;
	private int dir = 10;
	private boolean axis = false;
	
	//sets direction
	public void setDir(boolean axs, boolean dr){
		axis = axs;
		dir = (dr)? -10 : 10;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	//these method move the shape and wrap if necessary
	public void setX(int x) {
		if(this.x+x>width){
			this.x = 0;
		} else if (this.x+x<0) {
			this.x = width;
		} else {
			this.x += x;
		}
		gameView.somethingChanged();
	}
	public void setY(int y) {
		if(this.y+y>height){
			this.y = 0;
		} else if (this.y+y<0) {
			this.y = height;
		} else {
			this.y += y;
		}
		gameView.somethingChanged();
	}

	public GameModel() {
		
		// create the objects you want in the game
		// you will need to create some new classes for most/all of the objects
	}
	
	public void setGameView(GameView gv) {
		gameView = gv;
	}

	//calls to move shape
	public void move() {
		if(axis){
			setY(dir);
		} else {
			setX(dir);
		}
		
	}
}
