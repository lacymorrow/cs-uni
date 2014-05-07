import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
/**
 * View Class
 * @author Thomas Morrow
 *
 */
public class GameView extends JFrame {	
	private GameModel gameModel;
	private SnakeGame gameController;
	
	private GamePanel gamePanel;
	
	public GameView(GameModel gm, SnakeGame sg) {
		//sets up game panel
		super("Snake EXTREME");
		JMenuBar menuBar = new JMenuBar();
        
        // Add the menubar to the frame
        setJMenuBar(menuBar);
        
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        // Create and add simple menu item to one of the drop down menu
        JMenuItem exitAction = new JMenuItem("Exit");
        fileMenu.add(exitAction);
        exitAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
        });
        
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
