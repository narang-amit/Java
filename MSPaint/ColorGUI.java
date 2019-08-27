import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * ColorGUI!
 * This allows you to choose the color you want the brush to be.
 * @author Amit Narang and Ivan Zhang
 * @version 1.0
 * @since 1-10-17
 */

public class ColorGUI extends JFrame implements ActionListener{

    private Container pane;
    private JButton button;
    private Paint paint = null;

    /**
     * Creates a new Color GUI
     *
     */
    public ColorGUI() {
	pane = getContentPane();
	button = new JButton("Choose your color!");
	button.addActionListener(this);
	pane.add(button);
	setSize(400,400);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Creates new Color GUI
     *
     *@param paint The Paint Object
     */
    public ColorGUI(Paint paraPaint){
	this();
	paint = paraPaint;
    }
    

    /** actionPerformed of the ActionListener Interface */
    public void actionPerformed(ActionEvent e) {
	Color initial = Color.WHITE;
	Color big = JColorChooser.showDialog(this,"Select a color",initial);
	paint.setColor(big);
	this.dispose();
    }

    /** Main methods creates a ColorGUI */
    public static void main(String[] args) {
	new ColorGUI();
    }
}
