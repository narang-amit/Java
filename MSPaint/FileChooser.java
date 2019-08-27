import javax.swing.JFileChooser;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Component;
import java.lang.String;
import javax.swing.*;
import java.io.*;

/**
 * This is the FileChooser GUI we used in the MenuBar. 
 * By using JFileChooser, a preexisiting model, we cut down our work significantly.
 * After making a new JFileChooser, I added a filter so that it would limit it to images only.
 * It then returns 
 */
public class FileChooser {

    /**
     * After making a new JFileChooser, I added a filter so that it would limit it to images only.
     * It then returns the file chosen by the reader. 
     */
    public static String FileReturn() {
	
	JFileChooser fc = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpg", "png", "jpeg");	
	fc.setFileFilter(filter);
	int returnval = fc.showOpenDialog(null);
	return fc.getSelectedFile().getAbsolutePath();
    }
    

    public static String main() {
	try{
	    return FileReturn();
	} catch (NullPointerException error) {
	    //System.out.println("Select a file");
	    return null;
	}
    }
}
