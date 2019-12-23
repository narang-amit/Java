//Importing Stuff!
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{

    private Container pane;
    private JButton c;
    private JLabel l;
    private JCheckBox b1,b2;
    private JTextField t;

    public TemperatureWindow() {
		this.setTitle("Convert your temperature");
		this.setSize(300,200);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pane = this.getContentPane();
		pane.setLayout(new FlowLayout());
		c = new JButton("Convert");
		c.addActionListener(this);
		l = new JLabel("This is the only good way to convert!", null,JLabel.CENTER);
		t = new JTextField(5);
		t.addActionListener(this);
		b1 = new JCheckBox("F to C");
		b1.addActionListener(this);
		b2 = new JCheckBox("C to F");
		b2.addActionListener(this);
		pane.add(l);
		pane.add(t);
		pane.add(b1);
		pane.add(b2);
		pane.add(c);
    }
    public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if (event.equals("Convert")) {
			if (b2.isSelected()) {
				double x = (double) Integer.parseInt(t.getText());
				t.setText("" + TempConverter.CtoF(x));
			}
			else {
				double x = (double) Integer.parseInt(t.getText());
				t.setText("" + TempConverter.FtoC(x));
			}
		}
	}
	
	public static void main(String[] args) {
		TemperatureWindow x = new TemperatureWindow();
		x.setVisible(true);
	}   
	    
	    


}
