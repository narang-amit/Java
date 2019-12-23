import java.util.*;
import java.io.*;

public class WordSearch {
    //Instance Variables
    private static int Seed;
    private Random randgen;
    private char[][] data;
    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    private boolean answerKey;

    //Main
    public static void main(String[] args) {
	String howTo = "Call me like this: java WordSearch [rows columns filename [seed [key]]]";
	howTo += "\n If you want to see the solution, include the seed and 'key'";
	if (args.length < 3 || args.length > 5) {
	    System.out.println(howTo);
	}
	if (args.length==3) {
	    Seed = (int)( Math.random() * 100000);
	    try {
		WordSearch current = new WordSearch(Integer.valueOf(args[0]), Integer.valueOf(args[1]), args[2], Seed, false);
		System.out.println(current);
	    }
	    catch (IllegalArgumentException e) {
		System.out.println(howTo);
		System.exit(3);
	    }
	}
	if (args.length ==4) {
	    try {
		WordSearch current = new WordSearch(Integer.valueOf(args[0]), Integer.valueOf(args[1]), args[2], Integer.valueOf(args[3]), false);
		System.out.println(current);
	    }
	    catch (IllegalArgumentException e) {
		System.out.println(howTo);
		System.exit(3);
	    }
	}
	if (args.length ==5) {
	    try {
		WordSearch current = new WordSearch(Integer.valueOf(args[0]), Integer.valueOf(args[1]), args[2], Integer.valueOf(args[3]), args[4].equals("key"));
		System.out.println(current);
	    }
	    catch (IllegalArgumentException e) {
		System.out.println(howTo);
		System.exit(3);
	    }
	}
    }		
	    
	    
   
    
    //Constructor

    public WordSearch(int numRows, int numCols, String file, int seed, boolean key) {
	data = new char[numRows][numCols];
        Seed = seed;
	answerKey = key;
	randgen = new Random(seed);
	boardClear();
	loader(file);
	Check();
    }
    
    //File-Opener
    
    private void loader(String file) {
	try {
	    Scanner input = new Scanner(new File(file));
	    while (input.hasNext()) {
		String toAdd = input.next().toUpperCase();
		wordsToAdd.add(toAdd);
	    }
	}
	catch(FileNotFoundException except) {
	    System.out.print("Invalid filename or path");
	    System.exit(3);
	}
    }
    // See if they want the solution
    private void Check() {
	if (answerKey) {
	    boardClear();
	    addWords();
	}
	else {
	    addWords();
	    fill();
	}
    }
    // Empty the board
    private void boardClear() {
	for (int i = 0;i <data.length;i++) {
	    for (int j = 0; j < data[i].length; j++) {
		data[i][j] = '_';
	    }
	}
    }
    // Fill the board with random letters
    private void fill() {
	String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for (int i = 0;i < data.length; i++) {
	    for (int j = 0; j < data[i].length; j ++) {
		if (data[i][j] == '_') {
		    data[i][j] = alpha.charAt(randgen.nextInt(alpha.length()));
		}
	    }
	}
    }
    // check if there's space to add words
    private boolean canAddWords(String word, int row, int column, int rInc, int cInc) {
	if (rInc == 0 && cInc == 0) {
	    return false;
	}
	for (int i = 0;i < word.length(); i ++) {
	    int a = row + i * rInc;
	    int b = column + i * cInc;
	    if (((a > data.length) || (a < 0) || (b > data[0].length) || (b < 0)) || (data[a][b] != '_' && data[a][b] != word.charAt(i))) {
		return false;
	    }
	}
	return true;
    }
    	
    // add words
    private boolean addWordDirectional(String word, int row, int column, int rInc, int cInc) {
	int b = word.length();
	if ( (data.length - row >= b) && (data.length - column >= b) && canAddWords(word,row,column,rInc,cInc)) {
	    for (int i = 0; i < b; i ++) {
		data[row + i * rInc][column + i * cInc] = word.charAt(i);
	    }
	    return true;
	}
	return false;
    }
    //addWords (part two)
    private void addWords() {
	for (int i = 0; i < wordsToAdd.size(); i++) {
	    String word = wordsToAdd.get(i);
	    boolean temp = false;
	    int cnt = 0;
	    int randomRow;
	    int randomColumn;
	    int rInc;
	    int cInc;
	    while (!temp && cnt <= 500) {
		randomRow = randgen.nextInt(data.length);
		randomColumn = randgen.nextInt(data[0].length);
		rInc = randgen.nextInt(3) -1;
		cInc = randgen.nextInt(3) -1;
		if (addWordDirectional(word,randomRow, randomColumn, rInc, cInc)) {
		    wordsToAdd.remove(i);
		    wordsAdded.add(word);
		    temp = true;
		    i --;
		}
		cnt ++;
	    }
	}
    }
    // print the board
    public String toString() {
	String end = "\n";
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[i].length; j++) {
		end += data[i][j] + "";
	    }
	    end += "\n";
	}
	end += "\n" + "The seed is: " + Seed + ".\n";
	System.out.println(end);
	return wordsAdded + "\n";
    }
		
	
}
		    
	
	
	
