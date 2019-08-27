import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D.*;
import java.lang.*;
import java.awt.Font;

 /**
 * Paint
 * The most important file! JavaPaint by Picasso Baby
 * @author Amit Narang and Ivan Zhang
 * @version 1.0
 * @since 1-8-17
 *
 */

//When loading image into constructor, initalize size and set photo size = to window size, so it changes size with window.

public class Paint extends JFrame implements MouseListener{

    private JPanel biggerPane;
    private JLabel imageLabel;
    private MenuBar menu;
    
    private BufferedImage img;
    private String original;
    private Graphics2D g;
    private ImageIcon icon; 
    private String fileName;// = "images/black.png";
    
    private int penThickness = 1;
    private Color color;
    private int startX, startY;
    private int endX, endY;

    private Boolean line = true;
    private Boolean rectangle = false;
    private Boolean roundRect = false;
    private Boolean circle = false;  
    private Boolean oval = false;
    private Boolean filled = false;

    private String str = null;
    private float Textx,Texty;

    /** Constructor for Paint
     *
     *@param fileName String of the name of the image file
     */
    public Paint(String FileName) {
	try {
	    original = "images/originals/" + returnFile(FileName);
	    if (!new File(original).exists()){
		moveFile(original);
	    }
	
	    String[] colorFileName = {"images/color/Black.png", "images/color/Blue.png", "images/color/Cyan.png", "images/color/Dark-Gray.png",
				      "images/color/Green.png", "images/color/Light-Gray.png", "images/color/Magenta.png", "images/color/Orange.png",
				      "images/color/Pink.png", "images/color/Red.png", "images/color/White.png", "images/color/Yellow.png"};

	    for (int i = 0; i < colorFileName.length; i++){
	    
		if (FileName.equals(colorFileName[i])){
		    fileName = "images/temp.png";
		}
	    
	    }
	    if (fileName == null || !fileName.equals("images/temp.png")){
		fileName = FileName;
	    }
	} catch (IllegalArgumentException e){
	    System.out.println("Whoops! File Name is either too powerful (big), the temp.png, or not in the 'images' folder. Try Again!");
	    System.exit(1);
	}

        biggerPane = new JPanel();
        biggerPane.setLayout(new BorderLayout());
        try {
	    img = ImageIO.read(new File(FileName));
	    icon = new ImageIcon(img);
	    imageLabel = new JLabel(icon);
	    if (icon.getIconWidth() > 1024 || icon.getIconHeight() > 768){
		throw new IOException();
	    }
 	    biggerPane.add(imageLabel);	
	}
	catch (IOException e) {
	    System.out.println("Whoops! File Name is either too powerful (big), the temp.png, or not in the 'images' folder. Try Again!");
	    System.exit(1);
	}

        addMouseListener(this);
	this.add(biggerPane);
	this.pack();
	
	menu = new MenuBar(this);
	this.setJMenuBar(menu);
	
	setTitle("JavaPaint");
	setSize(600,600);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setVisible(true);
    }

    /** Default constructor for Paint */
    public Paint(){
        this("images/color/Black.png");
    }

    /** Creates a new file
     *@param fileName String of the new fileName
     */
    public void moveFile(String fileName){
	try{
	    ImageIO.write(img, "png", new File(fileName));
	}
	catch(IOException e){
	    System.out.println("Nnoooooooooooo");
	}	
    }

    /** Sets the Color of the brush
     *@param newColor Color of the brush
     */
    public void setColor(Color newColor){
	color = newColor;
    }

    /** Sets the thickness of the brush
     * @param thickness int of the new brush thickness
     */
    public void setThickness(int thickness){
	penThickness = thickness;
    }

    /** Changes the brush shape variables 
     * i.e. line, rectangle, circle, roundRect, oval, filled
     * @param shape String of the shape the user has choosen (from Shapes GUI)
     */
    public void makeShapeTrue(String shape){
	if (shape.equals("rectangle")){
	    line = false;
	    rectangle = true;
	    circle = false;
	    roundRect = false;
	    oval = false;
	    filled = false;
	}else if (shape.equals("circle")){
	    line = false;
	    rectangle = false;
	    circle = true;
	    oval = false;
	    roundRect = false;
	    filled = false;
	}else if (shape.equals("oval")){
	    line = false;
	    rectangle = false;
	    circle = false;
	    oval = true;
	    roundRect = false;
	    filled = false;
	}else if (shape.equals("roundRect")){
	    line = false;
	    rectangle = false;
	    circle = false;
	    oval = false;
	    roundRect = true;
	    filled = false;
	}else if (shape.equals("filled")){
	    filled = true;
	}
	else{
	    line = true;
	    rectangle = false;
	    circle = false;
	    oval = false;
	    roundRect = false;
	    filled = false;
	}
    }

    /** Gets just the fileName (with  path, directories, etc.)
     *@param file String of the complete path/file
     *return file if found, else empty string
     */
    public static String returnFile(String file){
	for (int i = file.length() - 1; i > 0; i -= 1){
	    if (file.charAt(i) == '/'){
		return file.substring(i+1);
	    }
	}
	return "";
    }
    
    /** Main method of Paint, creates new Paint instance */
    public static void main(String[] args){
	new Paint();
    }

    /** Draws the shapes
     *@param g Graphics object being used to draw
     */
    public void paint(Graphics g){

	g = (Graphics2D)img.getGraphics();
	g.drawImage(img, 0, 0, this);
	g.setColor(color);
	Graphics2D g2 = (Graphics2D)g;
	g2.setStroke(new BasicStroke(penThickness));

	int sizeX = Math.abs(endX - startX);
	int sizeY = Math.abs(endY - startY);
	double distance = Math.hypot((endX - startX), (endY-startY));
	
	if (line){
	    g2.drawLine(startX, startY, endX, endY);
	}

	int temp = 0;
	if (startX > endX){
	    temp = startX;
	    startX = endX;
	    endX = temp;
	}
	if (startY > endY){
	    temp = startY;
	    startY = endY;
	    endY = temp;
	}
	
	if (rectangle){
	    g2.drawRect(startX, startY, sizeX, sizeY);
	    if (filled){
		g2.fillRect(startX, startY, sizeX, sizeY);
	    }
	}

	if (roundRect){
	    g2.drawRoundRect(startX, startY, sizeX, sizeY, 20, 20);
	    if (filled){
		g2.fillRoundRect(startX, startY, sizeX, sizeY, 20, 20);
	    }
	}

  	if (oval){
	    g2.drawOval(startX, startY, sizeX, sizeY);
	    if (filled){
		g2.fillOval(startX, startY, sizeX, sizeY);
	    }
				 
	}

	if (circle){
	    g2.drawOval(startX, startY, (int) distance, (int) distance);
	    if (filled){
		g2.fillOval(startX, startY, (int) distance, (int) distance);
	    }
	}
	
	try{
	    ImageIO.write(img, "png", new File(fileName));
	    img = ImageIO.read(new File(fileName));
	    imageLabel.setIcon(new ImageIcon(img));
	    this.pack();
	}
	catch(IOException e){
	    System.out.println("Abort mission");
	}
	
	g.dispose();
		
    }

    /** Clears the entire canvas
     */
    public void clear(){
	try {
	    img = ImageIO.read(new File(original));
	    imageLabel.setIcon(new ImageIcon(img));
	    this.pack();
	}
	catch (IOException e) {
	    System.out.println("Whoops! File Name is either too powerful (big), the temp.png, or not in the 'images' folder. Try Again!");
	    System.exit(1);
	}
	    
    }
    /** Grayscale
     * return the fileName of the GrayScale file
     */
    public String Grayscale() {
    	Image myImg = new ImageIcon(fileName).getImage();
    	BufferedImage buffer = new BufferedImage(img.getHeight(this), img.getWidth(this), BufferedImage.TYPE_BYTE_GRAY);
    	Graphics gi = buffer.getGraphics();
    	gi.drawImage(myImg, 0, 0, null);
    	gi.dispose();
    	Graphics2D g2d = (Graphics2D) g;
    	g2d.drawImage(buffer,null,0,0);
    	String x = "Gray" + fileName;
    	try {
    		ImageIO.write(buffer, "png", new File(x));
    		return x;
    		}
    	catch (IOException e) {
    		System.out.println(":(");
    		return "ho";
    		}
    	}

    //START OF METHODS FOR MouseListener
    /** mousePressed of MouseListener interface
     * Sets the startX and startY of the shape to be drawn.
     */
    public void mousePressed(MouseEvent event){
	startX = event.getX();
	startY = event.getY() - 50;
    }

    /** mouseReleased of MouseListener interface
     * Sets the endX and endY of the shape to be drawn.
     * Draws the shape! (repaint())
     */
    public void mouseReleased(MouseEvent event){
	endX = event.getX();
	endY = event.getY() - 50;
	repaint();
    }

    public void mouseClicked(MouseEvent event){
    }
    public void mouseEntered(MouseEvent event){
    }
    public void mouseExited(MouseEvent event){
    }

    //END OF METHODS FOR MouseListener

    public void setString(String s) {
    	str = s;
    }
    public String getString() {
    	return str;
    }
    public void setCor(float x, float y) {
    	Textx = x;
    	Texty = y;
    }
    public String getCor() {
    	return "(" + Textx + "," + Texty + ")";
    }
    public void Text(String s, float x, float y,Color c,int a, Font font) {
    	g = (Graphics2D)img.getGraphics();
    	g.setColor(c);
    	Font newFont = font.deriveFont(a);
    	g.setFont(newFont);
    	g.drawString(s,x,y);
    	try{
	    	ImageIO.write(img, "png", new File(fileName));
	    	img = ImageIO.read(new File(fileName));
	    	imageLabel.setIcon(new ImageIcon(img));
	    	this.pack();
			}		
		catch(IOException e){
	    	System.out.println("Abort mission");
	    }
	}

}
