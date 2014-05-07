import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Snake {
	private ArrayList<Segment> snake;
	public char dir = 'r';
	public Snake (){
		snake = new ArrayList<Segment>();
		snake.add(new Segment(0,0));
	}
	public ArrayList<Segment> getSnake(){
		return snake;
	}
	public void changeDir(char d){
		dir = d;
	}
	public void moveSnake(boolean grow,int x,int y){
		snake.add(new Segment(x, y));
		if(!grow && snake.size()>3){
			snake.remove(0);
		}
	}
}
