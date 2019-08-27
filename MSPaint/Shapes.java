import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;

 /**
 * Shapes
 * This allows you to choose the shape you want to draw in.
 * @author Amit Narang and Ivan Zhang
 * @version 1.0
 * @since 1-10-17
 */

public class Shapes extends JFrame implements ActionListener{

    private Container pane;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private Paint paint = null;

    /** Shapes constructor */
    public Shapes() {

	pane = getContentPane();
	pane.setBackground(Color.white);
	setTitle("Choose a Shape");
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	try {

	    b1 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/line.jpeg"))));
	    b1.setBorder(BorderFactory.createEmptyBorder());
	    b1.setContentAreaFilled(false);
	    b1.addActionListener(this);
	    b1.setName("line");
	    
	    b2 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/rectangle.jpeg"))));
	    b2.setBorder(BorderFactory.createEmptyBorder());
	    b2.setContentAreaFilled(false);
	    b2.addActionListener(this);
	    b2.setName("rectangle");
	    
	    b3 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/circle.jpeg"))));
	    b3.setBorder(BorderFactory.createEmptyBorder());
	    b3.setContentAreaFilled(false);
	    b3.addActionListener(this);
	    b3.setName("circle");

	    b4 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/oval.png"))));
	    b4.setBorder(BorderFactory.createEmptyBorder());
	    b4.setContentAreaFilled(false);
	    b4.addActionListener(this);
	    b4.setName("oval");

	    b5 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/roundRect.png"))));
	    b5.setBorder(BorderFactory.createEmptyBorder());
	    b5.setContentAreaFilled(false);
	    b5.addActionListener(this);
	    b5.setName("roundRect");

	    b6 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/filledrectangle.png"))));
	    b6.setBorder(BorderFactory.createEmptyBorder());
	    b6.setContentAreaFilled(false);
	    b6.addActionListener(this);
	    b6.setName("$rectangle");

	    b7 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/filledcircle.png"))));
	    b7.setBorder(BorderFactory.createEmptyBorder());
	    b7.setContentAreaFilled(false);
	    b7.addActionListener(this);
	    b7.setName("$circle");

	    b8 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/filledoval.png"))));
	    b8.setBorder(BorderFactory.createEmptyBorder());
	    b8.setContentAreaFilled(false);
	    b8.addActionListener(this);
	    b8.setName("$oval");

	    b9 = new JButton(new ImageIcon(ImageIO.read(new File("images/shapes/filledroundRect.png"))));
	    b9.setBorder(BorderFactory.createEmptyBorder());
	    b9.setContentAreaFilled(false);
	    b9.addActionListener(this);
	    b9.setName("$roundRect");
	    
	    pane.add(b1);
	    pane.add(b2);
	    pane.add(b3);
	    pane.add(b4);
	    pane.add(b5);
	    pane.add(b6);
	    pane.add(b7);
	    pane.add(b8);
	    pane.add(b9);
	    pane.setLayout(new GridLayout(0,3));
	    pack();


	}

	catch (IOException e) {
	    System.out.println("Won't happen!");
	    System.exit(1);
	}
    }

    /** Shapes constructor
     * @param paraPaint The current Paint instance
     */
    public Shapes(Paint paraPaint){
	this();
	paint = paraPaint;
    }

    /** Checks to see if the shape chosen by the user is filled in
     *@param shape String of the shape image file selected by the user
     * returns true if the shape is a filled in shape, else false
     */

    public Boolean isFilled(String shape){
	return (shape.charAt(0) == '$');
    }

    /** Gets the shape chosen by the user
     *@param shape String of the shape image file selected by the user
     * return the String shape of the shape chosen
     */
    public String getShape(String shape){
	if (shape.charAt(0) == '$'){
	    return shape.substring(1);
	}
	return shape;
    }

    /** actionPerformed of ActionListener interface
     * Passes the shape selected by the user into the Paint instance
     */
    public void actionPerformed(ActionEvent e) {
	JButton b = (JButton) e.getSource();
	String shape = getShape(b.getName());
	paint.makeShapeTrue(shape);
	if (isFilled(b.getName())){
	    paint.makeShapeTrue("filled");
	}
	this.dispose();
    }

    /** Main method creates a new Shapes GUI*/
    public static void main(String[] args) {
    	new Shapes();
    }
}



