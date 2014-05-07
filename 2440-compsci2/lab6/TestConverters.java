import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TestConverters extends JFrame {
	public static void main(String[] args) {
		TestConverters();
	   }

	public TestConverters() {
		setTitle("Dollars to Pounds");
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      JPanel north = new JPanel();
	      north.add(new JLabel("Dollars: "));
	      north.add(dollars);
	      dollars.addActionListener(new ConvertListener());

	      JPanel south = new JPanel();
	      south.add(new JLabel("Pounds: "));
	      south.add(pounds);
	      pounds.addActionListener(new ConvertListener());

	      add(north, BorderLayout.NORTH);
	      add(south, BorderLayout.SOUTH);

	      pack();
	      setLocationRelativeTo(null);
	      setVisible(true);
	}
}
