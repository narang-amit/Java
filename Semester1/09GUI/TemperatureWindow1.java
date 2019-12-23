//Importing Stuff!
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public TemperatureWindow1 extends JFrame implements ActionListener{
    private Container pane;
    private JButton c;
    private JLabel l;
    private JCheckBox b1,b2;
    private JTextField t;
    public TemperatureWindow1() {
	this.setTitle("Convert your temperature");
	this.setSize(800,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	c = new JButton("Convert");
	l = new JLabel("This is the onLY way to convert", null,JLabel.CENTER);
	t = new JTextField(5);
	b1 = new JCheckBox("F to C");
	b2 = new JCheckBox("C to F");
	pane.add(l);
	pane.add(t);
	pane.add(b1);
	pane.add(b2);
	pane.add(c);
    }
    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();
	if (event.equals("Convert")) {
	    
	    
	    


}
