import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * SaveAsWindow!
 * The GUI that allows the user to input their desired fileName
 * @author Amit Narang and Ivan Zhang
 * @version 1.0
 * @since 1-10-17
 */

public class SaveAsWindow extends JFrame implements ActionListener{
    //Field Variables
    private JTextField newFileName;
    private JButton submit;
    private String fileName;
    private Paint paint = null;

    /** Simple Constructor for SaveAsWindow */
    public SaveAsWindow(){
	setTitle("Save As");
	setSize(600,400);
	setLocation(100,100);
	setLayout(new FlowLayout());
    
	submit = new JButton("Submit!!!");
	submit.addActionListener(this);
    
	newFileName = new JTextField(20);
    
	add(newFileName);
	add(submit);
	setVisible(true);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
    }

    /** Constructor for SaveAsWindow
     *@param paraPaint The current Paint instance 
     */
    public SaveAsWindow(Paint paraPaint){
	this();
	paint = paraPaint;
    }
    
    /** actionPerformed method of the ActionListener interface 
     * This method creates a new file based on the name given by the user.
     */
    public void actionPerformed(ActionEvent event){
	if (event.getActionCommand().equals("Submit!!!") && paint != null && newFileName.getText() != null){
	    fileName = newFileName.getText();
	    //menu.setFileName(fileName);
	    paint.moveFile("images/" + fileName+".png");
	    paint.moveFile("images/originals/" + fileName+".png");
		    
	    this.dispose();
	    
	}
    }

    /** Returns the user's desired fileName for the current image file*/
    public String getFileName(){
	return fileName;
    }
    
}
