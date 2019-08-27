/**
 * Thickness GUI
 * Used from the MenuBar of Java Paint
 *
 * @author Amit Narang and Ivan Zhang
 * @version 1.0
 * @since 1-5-18
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Thickness extends JFrame implements ActionListener{

    private Container pane;
    private Paint paint = null;
    private JSpinner spinner;
    private JButton b;
    private JLabel l;
    private String x;
    /**
    * This is the constructor for the Thickness GUI
    * It makes the JPanel, JLabel, and the JSpinner inside
    */
    public Thickness() {
    	SpinnerNumberModel totalModel = new SpinnerNumberModel(50,1,100,1);
    	spinner = new JSpinner(totalModel);
        b = new JButton("Set");
        b.addActionListener(this);
    	this.setTitle("Thickness Editor");
    	this.setSize(250,100);
    	this.setLocation(-100,100);
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	pane = this.getContentPane();
    	pane.setBackground(Color.white);
    	pane.setLayout(new FlowLayout());
    	l = new JLabel("Select the level of thickness");
    	pane.add(l);
    	pane.add(spinner);
        pane.add(b);
        this.setVisible(true);
    }
    /** Constructor for Thickness
     *@param paraPaint The current Paint instance
     */
    public Thickness(Paint paraPaint){
	this();
	paint = paraPaint;
    }

    /** actionPerformed of the ActionListener interface 
     * Sets the thickness of the current Paint instance
     */
    public void actionPerformed(ActionEvent e) {
	paint.setThickness((Integer)spinner.getValue());
	this.dispose();
    }

    /** Main method returns the Thickness GUI */
    public static void main(String[] args) {
        new Thickness();
    }
}
