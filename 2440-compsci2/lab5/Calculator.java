import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame{
	/**
	 * Calculator
	 * 
	 * @author Lacy Morrow
	 * @version 02.17.2010
	 */
	private static final long serialVersionUID = 1L;
	private static double firstOp = 0;
	private static double secOp = 0;
	private static boolean newNum = false;
	private static boolean deci = false;
	private static String oper = "";
	private static JTextField txt;
	public static void main(String[] args) {
		new Calculator();
	}
	public Calculator() {
		//set title
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create the User Interface
		add(getUserInterface());

		pack();
		setSize(350,400);
		setLocationRelativeTo(null);
		txt.setText("");
		setVisible(true);

	}
	JPanel getUserInterface() {
		// Create a JPanel, it's default layout
		// is FlowLayout, so we change it to
		// BorderLayout
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// Add other panels...
		panel.add(getNorthPanel(), BorderLayout.NORTH);
		panel.add(getEastPanel(), BorderLayout.EAST);
		panel.add(getCenterPanel(),BorderLayout.CENTER);

		return panel;
	}

	class addClick implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(!txt.equals("")){
			if(!oper.equals("")){
				secOp = Double.parseDouble(txt.getText());
				txt.setText(Double.toString(calc()));
			}
			oper = "+";
			deci = false;
			newNum = true;
			firstOp = Double.parseDouble(txt.getText());
			}
		}
	}
	class minClick implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(!txt.equals("")){
			if(!oper.equals("")){
				secOp = Double.parseDouble(txt.getText());
				txt.setText(Double.toString(calc()));
			}
			oper = "-";
			deci = false;
			newNum = true;
			firstOp = Double.parseDouble(txt.getText());
			}
		}
	}
	class mulClick implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(!txt.equals("")){
			if(!oper.equals("")){
				secOp = Double.parseDouble(txt.getText());
				txt.setText(Double.toString(calc()));
			}
			oper = "*";
			deci = false;
			newNum = true;
			firstOp = Double.parseDouble(txt.getText());
			}
		}
	}
	class divClick implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(!txt.equals("")){
				if(!oper.equals("")){
				secOp = Double.parseDouble(txt.getText());
				txt.setText(Double.toString(calc()));
			}
			oper = "/";
			deci = false;
			newNum = true;
			firstOp = Double.parseDouble(txt.getText());
			}
		}
	}
	class eqClick implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(!txt.equals("") && !oper.equals("")){
				secOp = Double.parseDouble(txt.getText());
			txt.setText(Double.toString(calc()));
			newNum = true;
			deci = false;
			oper = "";
			}
		}
	}
	class reset implements ActionListener {
		public void actionPerformed(ActionEvent e){
			txt.setText("");
			oper = "";
			firstOp=0.0;
			secOp=0.0;
			deci = false;
			newNum = false;
		}
	}
	class clearClick implements ActionListener {
		public void actionPerformed(ActionEvent e){
			txt.setText("");
			new reset();
		}
	}
	class dotClick implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(deci == false){
				if(txt.getText().equals("")){
					txt.setText("0");
				} else if(newNum == true){
					txt.setText("0");
				}
				deci = true;
				newNum = false;
				txt.setText(txt.getText() + ".");
			}
		}
	}
	class numClick implements ActionListener {
		private int i;
		numClick(int i){
			this.i = i;
		}
		public void actionPerformed(ActionEvent e){
			if(txt.getText().equals("") || newNum == true){
				txt.setText("0");
				newNum = false;
			}
			if(!deci){
				txt.setText(Integer.toString(Integer.parseInt(txt.getText())*10 + i));
			} else if(!txt.getText().equals("")){
				txt.setText(txt.getText()+i);
			} else {
				txt.setText("0."+i);
			}
		}
	}
	public static double calc(){
		if(oper.equals("+")){
			return firstOp+secOp;
		} else if(oper.equals("-")){
			return firstOp-secOp;
		} else if(oper.equals("*")){
			return firstOp*secOp;
		} else if(oper.equals("/")){
			return firstOp/secOp;
		} else {
			return 0.0;
		}
	}
	JPanel getNorthPanel(){
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,0,5,0));
		txt = getTextPanel();
		p.add(txt);
		JButton clear = new JButton("c");
		clear.addActionListener(new clearClick());
		p.add(clear);
		return p;
	}

	JTextField getTextPanel(){
		JTextField p = new JTextField();
		p.setEditable(false);
		return p;
	}
	JPanel getEastPanel(){
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(0,1,0,10));
		JButton addBtn = new JButton("+");
		addBtn.addActionListener(new addClick());
		p.add(addBtn);
		JButton minBtn = new JButton("-");
		minBtn.addActionListener(new minClick());
		p.add(minBtn);
		JButton mulBtn = new JButton("*");
		mulBtn.addActionListener(new mulClick());
		p.add(mulBtn);
		JButton divBtn = new JButton("/");
		divBtn.addActionListener(new divClick());
		p.add(divBtn);
		JButton eqBtn = new JButton("=");
		eqBtn.addActionListener(new eqClick());
		p.add(eqBtn);
		return p;
	}
	JPanel getCenterPanel(){
		JPanel q = new JPanel();
		q.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,3,20,20));
		for(int i=1;i<10;i++){
			JButton b = new JButton(String.valueOf(i));
			b.addActionListener(new numClick(i));
			p.add(b);
		}
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,0,20,20));
		JButton zero = new JButton("0");
		JButton dot = new JButton(".");
		zero.addActionListener(new numClick(0));
		dot.addActionListener(new dotClick());
		p2.add(zero);
		p2.add(dot);
		q.add(p,BorderLayout.CENTER);
		q.add(p2,BorderLayout.SOUTH);
		return q;
	}
	class getText implements ActionListener {
		public void actionPerformed(ActionEvent e){

		}
	}
}
