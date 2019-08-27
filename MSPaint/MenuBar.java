/**
 * Menu Bar for JavaPaint
 * Menu Bar with Menu options
 *
 * @author Amit Narang and Ivan Zhang
 * @version 1.0
 * @since January 5, 2018
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class MenuBar extends JMenuBar implements ActionListener{

    private Paint paint = null;
    private JMenu FileMenu,CanvasMenu,BasicMenu,AdvancedMenu;
    private JMenuItem File1, File2, File3, File4;
    private JMenuItem Canvas1,Canvas2;
    private JMenuItem Basic1, Basic2;
    private JMenuItem Advanced1, Advanced2, Advanced3,Advanced4;
    
    private String fileName = "images/color/black.png";
    
    

    public MenuBar() {
	   
	FileMenu = new JMenu("File");
	CanvasMenu = new JMenu("Canvas");
	BasicMenu = new JMenu("Basic");
	AdvancedMenu = new JMenu("Advanced");

	//File Menu 
	File1 = new JMenuItem("Start from Scratch");
	File1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
	FileMenu.add(File1);
	File2 = new JMenuItem("Start from Image");
	File2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
	FileMenu.add(File2);
	File3 = new JMenuItem("Save As");
	File3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
	FileMenu.add(File3);
		
	//Canvas Menu

	Canvas1 = new JMenuItem("Clear");
	Canvas1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
	CanvasMenu.add(Canvas1);
	//Canvas2 = new JMenuItem("Undo");
	//CanvasMenu.add(Canvas2);
		
	//Basic Menu

	Basic1 = new JMenuItem("Color");
	Basic1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
	BasicMenu.add(Basic1);
	Basic2 = new JMenuItem("Thickness");
	Basic2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
	BasicMenu.add(Basic2);

	//Advanced Menu

	Advanced1 = new JMenuItem("Choose Background");
	Advanced1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
	AdvancedMenu.add(Advanced1);
	Advanced2 = new JMenuItem("Choose Style");
	Advanced2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
	AdvancedMenu.add(Advanced2);
	Advanced3 = new JMenuItem("Choose Shape");
	Advanced3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK));
	AdvancedMenu.add(Advanced3);
	Advanced4 = new JMenuItem("Textbox");
	Advanced4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK));
	AdvancedMenu.add(Advanced4);
	
	//Adding MenuListeners
	File1.addActionListener(this);
	File2.addActionListener(this);
	File3.addActionListener(this);
	Canvas1.addActionListener(this);
	//Canvas2.addActionListener(this);	
	Basic1.addActionListener(this);
	Basic2.addActionListener(this);	
	Advanced1.addActionListener(this);
	Advanced2.addActionListener(this);
	Advanced3.addActionListener(this);
	Advanced4.addActionListener(this);
	//Adding Menus to MenuBar

	this.add(FileMenu);
	this.add(Box.createHorizontalStrut(15));
	this.add(CanvasMenu);
	this.add(Box.createHorizontalStrut(15));
	this.add(BasicMenu);
	this.add(Box.createHorizontalStrut(15));
	this.add(AdvancedMenu);
	
    }
    /** Constructor for MenuBar
     *@param paraPaint The current Paint instance
     */
    
    public MenuBar(Paint paraPaint){
	this();
	paint = paraPaint;
    }

    /** getFileName()
     * returns desired fileName for the current Paint file
     */
    public String getFileName(){
	return fileName;
    }
	
    /**
     * actionPerformed method of the ActionLisener interface
     * This method determins which menu option the user pressed and runs the appropiate methods
     * @param ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("Start from Scratch")){
	    new Paint("images/color/Black.png");
	}
	if (e.getActionCommand().equals("Start from Image")){
	    fileName = FileChooser.main();
	    if (fileName != null){
		new Paint(fileName);
	    }
	}
	if (e.getActionCommand().equals("Save As")){
	    new SaveAsWindow(paint);
	}	
        if (e.getActionCommand().equals("Clear")){
	    paint.clear();
	}
	if (e.getActionCommand().equals("Color")){
	    new ColorGUI(paint);
	}
	if (e.getActionCommand().equals("Thickness")){
	    new Thickness(paint);
	}
	if (e.getActionCommand().equals("Choose Background")){
	    new BackgroundColorGUI();
	}
	if (e.getActionCommand().equals("Choose Style")){
	    new Marker(paint);
	}
	if (e.getActionCommand().equals("Choose Shape")){
	    new Shapes(paint);
	}
	if (e.getActionCommand().equals("Textbox")) {
		new Text(paint);
	}
    }

    

}
