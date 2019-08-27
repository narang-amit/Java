import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
//test
//idgi

 /**
 * Marker
 * This allows you to choose the style of the brush.
 * @author Amit Narang and Ivan Zhang
 * @version 1.0
 * @since 1-10-17
 */

public class Marker extends JFrame implements ActionListener{

    private Container pane;
    private JButton b1,b2,b3,b4;
    private int thickness = 1;
    private Paint paint = null;

    /** Creates a Marker GUI */
    public Marker() {

	pane = getContentPane();
	pane.setBackground(Color.white);
	setTitle("Choose your Brush");
	setVisible(true);
	GridLayout experiment = new GridLayout(0,2);
	pane.setLayout(experiment);

	try {

	    b1 = new JButton(new ImageIcon(ImageIO.read(new File("images/types/pen.jpg"))));
	    b1.setBorder(BorderFactory.createEmptyBorder());
	    b1.setContentAreaFilled(false);
	    b1.addActionListener(this);
	    b1.setName("Pen");

	    b2 = new JButton(new ImageIcon(ImageIO.read(new File("images/types/pencil.png"))));
	    b2.setBorder(BorderFactory.createEmptyBorder());
	    b2.setContentAreaFilled(false);
	    b2.addActionListener(this);
	    b2.setName("Pencil");

	    b3 = new JButton(new ImageIcon(ImageIO.read(new File("images/types/crayon.png"))));
	    b3.setBorder(BorderFactory.createEmptyBorder());
	    b3.setContentAreaFilled(false);
	    b3.addActionListener(this);
	    b3.setName("Crayon");

	    b4 = new JButton(new ImageIcon(ImageIO.read(new File("images/types/marker.jpg"))));
	    b4.setBorder(BorderFactory.createEmptyBorder());
	    b4.setContentAreaFilled(false);
	    b4.addActionListener(this);
	    b4.setName("Marker");

	    pane.add(b1);
	    pane.add(b2);
	    pane.add(b3);
	    pane.add(b4);
	    pack();

	}

	catch (IOException e) {
	    System.out.println("Won't happen!");
	    System.exit(1);
	}
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /** Creates a Marker GUI
     * @param paraPaint The Paint object 
     */
    public Marker(Paint paraPaint){
	this();
	paint = paraPaint;
    }

    /** actionPerformed of the ActionListener Interface */
    public void actionPerformed(ActionEvent e) {
	JButton b = (JButton) e.getSource();
	String type = b.getName();
	if (type.equals("Pen")){
	    thickness = 8;
	} else if(type.equals("Pencil")){
	    thickness = 5;
	} else if(type.equals("Crayon")){
	    thickness = 50;
	} else if(type.equals("Marker")){
	    thickness = 100;
	} else {
	    thickness = 1;
	}
	paint.setThickness(thickness);
	this.dispose();
    }
    /* Main method creates a new Marker GUI */
    public static void main(String[] args) {
	new Marker();
    }
}

