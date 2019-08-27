import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagConstraints;

/**
 * BackgroundColorGUI!
 * This allows you to choose the color you want the background to be.
 *
 * @author Amit Narang and Ivan Zhang
 * @version 1.0
 * @since 12-5-17
 */

public class BackgroundColorGUI extends JFrame implements ActionListener{

    private Container pane;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    /**
     * This is the constructor for the GUI. 
     * I made 12 buttons,  and set their backgrounds and foregrounds so they 
     * look like the color they're supposed to represent.
     * In order to display the color properly, I had to modify the opaqueness
     * and BorderPainted values. I also added ActionListener to all the buttons.
     * Once the buttons were made, I made the pane use the GridLayout so that
     * all the buttons would be the same size.
     */
    public BackgroundColorGUI() {

	pane = getContentPane();
	pane.setBackground(Color.black);

	b1 = new JButton("Black");
	b1.setBackground(Color.black);
	b1.setForeground(Color.white);
	b1.setOpaque(true);
	b1.setBorderPainted(false);
	b1.addActionListener(this);

	b2 = new JButton("White");
	b2.setBackground(Color.white);
	b2.setForeground(Color.black);
	b2.setOpaque(true);
	b2.setBorderPainted(false);
	b2.addActionListener(this);

	b3 = new JButton("Light-Gray");
	b3.setBackground(Color.lightGray);
	b3.setForeground(Color.black);
	b3.setOpaque(true);
	b3.setBorderPainted(false);
	b3.addActionListener(this);

	b4 = new JButton("Green");
	b4.setBackground(Color.green);
	b4.setForeground(Color.black);
	b4.setOpaque(true);
	b4.setBorderPainted(false);
	b4.addActionListener(this);

	b5 = new JButton("Blue");
	b5.setBackground(Color.blue);
	b5.setForeground(Color.black);
	b5.setOpaque(true);
	b5.setBorderPainted(false);
	b5.addActionListener(this);

	b6 = new JButton("Yellow");
	b6.setBackground(Color.yellow);
	b6.setForeground(Color.black);
	b6.setOpaque(true);
	b6.setBorderPainted(false);
	b6.addActionListener(this);

	b7 = new JButton("Red");
	b7.setBackground(Color.red);
	b7.setForeground(Color.black);
	b7.setOpaque(true);
	b7.setBorderPainted(false);
	b7.addActionListener(this);

	b8 = new JButton("Dark-Gray");
	b8.setBackground(Color.darkGray);
	b8.setForeground(Color.white);
	b8.setOpaque(true);
	b8.setBorderPainted(false);
	b8.addActionListener(this);

	b9 = new JButton("Orange");
	b9.setBackground(Color.orange);
	b9.setForeground(Color.black);
	b9.setOpaque(true);
	b9.setBorderPainted(false);
	b9.addActionListener(this);

	b10 = new JButton("Pink");
	b10.setBackground(Color.pink);
	b10.setForeground(Color.black);
	b10.setOpaque(true);
	b10.setBorderPainted(false);
	b10.addActionListener(this);

	b11 = new JButton("Magenta");
	b11.setBackground(Color.magenta);
	b11.setForeground(Color.black);
	b11.setOpaque(true);
	b11.setBorderPainted(false);
	b11.addActionListener(this);

	b12 = new JButton("Cyan");
	b12.setBackground(Color.cyan);
	b12.setForeground(Color.black);
	b12.setOpaque(true);
	b12.setBorderPainted(false);
	b12.addActionListener(this);

	GridLayout experiment = new GridLayout(0,2);
	pane.setLayout(experiment);
	pane.add(b1);
	pane.add(b2);
	pane.add(b8);
	pane.add(b3);
	pane.add(b4);
	pane.add(b5);
	pane.add(b12);
	pane.add(b7);
	pane.add(b9);
	pane.add(b6);
	pane.add(b10);
	pane.add(b11);
	pack();
	setSize(350,300);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    /**
     * This is the overridden actionPerformed function. Once any button is 
     * clicked, I get the source of the button so that I can see where it came 
     * from. This lets me avoid using a massive if check or switch. Once it gets
     * the source, it constructs a new Paint window with the starting image of 
     * its text. Then it closes itself.
     */
    public void actionPerformed(ActionEvent e) {
	JButton b = (JButton) e.getSource();
	new Paint("images/color/" + b.getText() + ".png");
	this.dispose();
    }

}
