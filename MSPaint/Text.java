import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTabbedPane;



public class Text extends JPanel implements ActionListener{

	private JFrame frame;
	private JTabbedPane pane;
	private JComponent panel1,panel2,panel3;
	private JComponent panel4,panel5,panel6;
	private JButton submit, next1;
	private String s = null;
	private JTextArea box;
	private float x = 0;
	private float y = 0;
	private Paint paint = null;
	private JTextField textor,texter,textar,textur,textir;
	private Color color = Color.white;
	private int Width = 25;
	private JSpinner spinner;
	private Font font;
/**
* This constructs the GUI called by the MenuBar to draw a String.
* It uses a JFrame and a JTabbedPane inside so the user can navigate through multiple tabs
* The first Tab is for the user to input a string to write, so I used a JTextArea
* , which allowed me to have multiple lines on input. It stores the string in a variable.
* The second Tab is for the user to select the coordinate where they want the 
* String to start from. It stores the x-cor and y-cor.
* The third tab selects the Color the user wants to draw the string in, and stores the color.
* The fourth tab chooses the size and font of the string and stores both.
* The fifth tab confirms the information with the user
* and passes it along to the paint program.
*/
	public Text() {

		frame = new JFrame("Draw Text");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBackground(Color.white);

		pane = new JTabbedPane();
		pane.setPreferredSize(new Dimension(500,500));
		frame.add(pane,BorderLayout.CENTER);
		pane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		panel1 = new JPanel();
		//panel1.add(new JLabel("Input String"));
		panel1.setLayout(new GridLayout(0,2));
		panel1.setBackground(Color.white);
		box = new JTextArea("Input String here");
		box.setEditable(true);
		box.setColumns(10);
		box.setRows(10);
		box.setLineWrap(true);
		panel1.add(box);
		next1 = new JButton("Next");
		next1.addActionListener(this);
		panel1.add(next1);
		pane.addTab("Input String",null,panel1,"What you want to input");
		pane.setMnemonicAt(0,KeyEvent.VK_1);

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(52,0));
		panel2.setBackground(Color.white);
		//panel2.add(new JLabel("Select Coordinate"));
		pane.addTab("Select Coordinate",null,panel2,"Where it should go");
		pane.setMnemonicAt(1,KeyEvent.VK_2);
		JButton[][] grid = new JButton[51][51];
		for (int y = 0; y <51;y ++) {
			for (int x = 0; x <51;x++) {
				grid[x][y] = new JButton("(" + x + "," + y + ")");
				grid[x][y].addActionListener(this);
				panel2.add(grid[x][y]);
			}
		}
		panel2.revalidate();
		

		panel3 = new JPanel();
		pane.addTab("Color",null,panel3,"Choose Color");
		pane.setMnemonicAt(2,KeyEvent.VK_3);
		panel3.setLayout(new GridLayout(0,2));
		panel3.setBackground(Color.white);

		JButton b1 = new JButton("Black");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setOpaque(true);
		b1.setBorderPainted(false);
		b1.addActionListener(this);

		JButton b2 = new JButton("White");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setOpaque(true);
		b2.setBorderPainted(false);
		b2.addActionListener(this);

		JButton b3 = new JButton("Light-Gray");
		b3.setBackground(Color.lightGray);
		b3.setForeground(Color.black);
		b3.setOpaque(true);
		b3.setBorderPainted(false);
		b3.addActionListener(this);

		JButton b4 = new JButton("Green");
		b4.setBackground(Color.green);
		b4.setForeground(Color.black);
		b4.setOpaque(true);
		b4.setBorderPainted(false);
		b4.addActionListener(this);

		JButton b5 = new JButton("Blue");
		b5.setBackground(Color.blue);
		b5.setForeground(Color.black);
		b5.setOpaque(true);
		b5.setBorderPainted(false);
		b5.addActionListener(this);

		JButton b6 = new JButton("Yellow");
		b6.setBackground(Color.yellow);
		b6.setForeground(Color.black);
		b6.setOpaque(true);
		b6.setBorderPainted(false);
		b6.addActionListener(this);

		JButton b7 = new JButton("Red");
		b7.setBackground(Color.red);
		b7.setForeground(Color.black);
		b7.setOpaque(true);
		b7.setBorderPainted(false);
		b7.addActionListener(this);

		JButton b8 = new JButton("Dark-Gray");
		b8.setBackground(Color.darkGray);
		b8.setForeground(Color.white);
		b8.setOpaque(true);
		b8.setBorderPainted(false);
		b8.addActionListener(this);

		JButton b9 = new JButton("Orange");
		b9.setBackground(Color.orange);
		b9.setForeground(Color.black);
		b9.setOpaque(true);
		b9.setBorderPainted(false);
		b9.addActionListener(this);

		JButton b10 = new JButton("Pink");
		b10.setBackground(Color.pink);
		b10.setForeground(Color.black);
		b10.setOpaque(true);
		b10.setBorderPainted(false);
		b10.addActionListener(this);

		JButton b11 = new JButton("Magenta");
		b11.setBackground(Color.magenta);
		b11.setForeground(Color.black);
		b11.setOpaque(true);
		b11.setBorderPainted(false);
		b11.addActionListener(this);

		JButton b12 = new JButton("Cyan");
		b12.setBackground(Color.cyan);
		b12.setForeground(Color.black);
		b12.setOpaque(true);
		b12.setBorderPainted(false);
		b12.addActionListener(this);

		panel3.add(b1);
		panel3.add(b2);
		panel3.add(b3);
		panel3.add(b4);
		panel3.add(b5);
		panel3.add(b6);
		panel3.add(b7);
		panel3.add(b8);
		panel3.add(b9);
		panel3.add(b10);
		panel3.add(b11);
		panel3.add(b12);

		panel4 = new JPanel();
		pane.addTab("Size",null,panel4,"Select size");
		pane.setMnemonicAt(3,KeyEvent.VK_4);
		SpinnerNumberModel totalModel = new SpinnerNumberModel(25,1,50,1);
		spinner = new JSpinner(totalModel);
		JButton thicButton = new JButton("Next");
		thicButton.addActionListener(this);
		JLabel l = new JLabel("Select Size");
		panel4.add(l);
		panel4.add(spinner);
		panel4.add(thicButton);

		panel5 = new JPanel();

		panel5.setLayout(new GridLayout(0,2));
		pane.addTab("Font",null,panel5,"Select Font");
		pane.setMnemonicAt(4,KeyEvent.VK_5);

		JButton textb1 = new JButton("Font: Arial");
		textb1.addActionListener(this);
		textb1.setFont(new Font("Arial",Font.PLAIN,20));
		panel5.add(textb1);
		JButton textb2 = new JButton("Font: Helvetica");
		textb2.addActionListener(this);
		textb2.setFont(new Font("Helvetica",Font.PLAIN,20));
		panel5.add(textb2);
		JButton textb3 = new JButton("Font: Serif");
		textb3.addActionListener(this);
		textb3.setFont(new Font("Serif",Font.PLAIN,20));
		panel5.add(textb3);
		JButton textb4 = new JButton("Font: SansSerif");
		textb4.addActionListener(this);
		textb4.setFont(new Font("SansSerif",Font.PLAIN,20));
		panel5.add(textb4);
		JButton textb5 = new JButton("Font: Times New Roman");
		textb5.addActionListener(this);
		textb5.setFont(new Font("Times New Roman",Font.PLAIN,20));
		panel5.add(textb5);
		JButton textb6 = new JButton("Font: Monospaced");
		textb6.addActionListener(this);
		textb6.setFont(new Font("Monospaced",Font.PLAIN,20));
		panel5.add(textb6);


		panel6 = new JPanel();
		pane.addTab("Submit",null,panel6, "Confirm Selection");
		pane.setMnemonicAt(5,KeyEvent.VK_6);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		textor = new JTextField("Text: " + box.getText());
		textor.setHorizontalAlignment(JTextField.CENTER);
		texter = new JTextField("Coordinate: (" + x + "," + y + ")");
		texter.setHorizontalAlignment(JTextField.CENTER);
		textor.setEditable(false);
		textor.setBackground(Color.gray);
		texter.setBackground(Color.gray);
		texter.setEditable(false);
		textar = new JTextField("Color: " + color);
		textar.setHorizontalAlignment(JTextField.CENTER);
		textar.setEditable(false);
		textar.setBackground(Color.gray);

		textur = new JTextField("Font: " + font);
		textur.setHorizontalAlignment(JTextField.CENTER);
		textur.setEditable(false);
		textur.setBackground(Color.gray);

		textir = new JTextField("Size: " + Width);
		textir.setHorizontalAlignment(JTextField.CENTER);
		textir.setEditable(false);
		textir.setBackground(Color.gray);

		panel6.setLayout(new GridLayout(0,2));
		panel6.add(textor);
		panel6.add(texter);
		panel6.add(textar);
		panel6.add(textir);
		panel6.add(textur);
		panel6.add(submit);


		frame.pack();
		frame.setVisible(true);

	}

	public Text(Paint p) {
		this();
		paint = p;
	}
	/**
	* I overrid the actionPerformed command to handle the new ActionEvents caused by the buttons.
	* If the button called is "Next", it switches panes, stores the text field, and stores the width.
	* I combined these two buttons so I wouldn't have to have two cases in my actionPerformed for 
	* virtually the same operation.
	* If the button is the coordinate grid, it stores the coordinates and switches panes.
	* If the button is a color, it stores the color and switches panes.
	* If the button is in the Font pane, it stores the Font and switches panes. 
	* Lastly, if it's the submit button, it passes the information onto the Paint program and draws the
	* Text, and disposes of the window.
	*/
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String str = b.getText();
		if (str.equals("Next")) {
			pane.setSelectedIndex(pane.getSelectedIndex()+1);
			textor.setText("String: " + box.getText());
			Width = (Integer) spinner.getValue();
			textir.setText("Font: " + Width);
			}
		else if (str.substring(0,1).equals("(")) {
			int comma = str.indexOf(",");
			int end = str.indexOf(")");
			x = 8 * Integer.parseInt(b.getText().substring(1,comma));
			y = 8 *Integer.parseInt(b.getText().substring(comma+1,end));
			texter.setText("Coordinates: " + str);
			paint.setCor(x,y);
			pane.setSelectedIndex(pane.getSelectedIndex()+1);
		}
		else if (str.equals("Submit")) {
			paint.setString(box.getText());
			paint.Text(paint.getString(),x,y,color,Width,font);
			frame.dispose();

			//paint.text(s,x,y);
		}
		else if (str.substring(0,4).equals("Font")) {
			font = b.getFont();
			textur.setText(b.getText());
			//System.out.println(b.getText());
			pane.setSelectedIndex(pane.getSelectedIndex() + 1);
			
		}
		else {
			color = b.getBackground();
			textar.setText("Color: " + b.getText());
			pane.setSelectedIndex(pane.getSelectedIndex() +1);
		}
	}
	public static void main(String[] args) {
		new Text();
	}
}
