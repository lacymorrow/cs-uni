import java.util.ArrayList;
import java.util.Random;

/**
 * Model Class
 * @author Thomas Morrow
 *
 */
public class GameModel {

	private GameView gameView;
	private GamePanel gamePanel;
	private int x = 0;
	private int y = 0;
	private int width;
	private int height;
	private int dir = 10;
	private boolean axis = false;
	private int[] food = new int[4];
	public Snake snake;
	public Random rand = new Random();
	
	public void putFood(){
		int fX = -1;
		int fY = -1;
		while(fX == -1){
			int rX = rand.nextInt(width);
			int rY = rand.nextInt(height);
			for(Segment seg : getSnake()){
				if (rX != seg.getX() && rY != seg.getY()){
					fX = rX;
					fY = rY;
				}
			}
		}
		System.out.println("Placed Food");
		
		gamePanel.setFood([10,10,10,10]);
	}
	
	
	
	//sets direction
	public void setDir(boolean axs, boolean dr){
		axis = axs;
		dir = (dr)? -10 : 10;
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
		snake.moveSnake(false, this.x, this.y);
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
		snake.moveSnake(false, this.x, this.y);
		gameView.somethingChanged();
	}
	public ArrayList<Segment> getSnake() {
		return snake.getSnake();
	}
	public GameModel() {
		// create the objects you want in the game
		// you will need to create some new classes for most/all of the objects
		snake = new Snake();
	}
	
	public void setGameView(GameView gv) {
		gameView = gv;
	}

	//calls to move shape
	public void move() {
		if(food==null){
			putFood();
		}
		if(axis){
			setY(dir);
		} else {
			setX(dir);
		}
	}



	public int[] getFood() {
		return food;
	}



	public void setGamePanel(GamePanel gp) {
		gamePanel = gp;
	}
}
