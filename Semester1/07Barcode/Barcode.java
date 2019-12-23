import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class Barcode implements Comparable<Barcode> {
    //Instance Variables
    private String zipper;
    //Constructor
    public Barcode(String zip) {
    	checker(zip);
    	zipper = zip;
    }
    //Methods
    public static void checker(String zip) {
    	if (zip.length() == 5) {
    		Pattern x = Pattern.compile("\\d{5}");
    		Matcher y = x.matcher(zip);
    		if (!y.find()) {
    			throw new IllegalArgumentException();
    		}
    	}
    	else {
    		throw new IllegalArgumentException();
    	}
    }
    public static int getCheckDigit(String zip) {
	int a = 0;
	for (int i = 0; i < 5; i ++) {
	    a +=  Integer.parseInt(zip.substring(i, i+1));
	}
	return a % 10;
    }
    //Public Methods
    public static String toCode(String zip) {
    	String stored = "|";
    	HashMap<String, String> hasher = new HashMap<String,String>() {
		{
		    put("1",":::||");
		    put("2","::|:|");
		    put("3","::||:");
		    put("4",":|::|");
		    put("5",":|:|:");
		    put("6",":||::");
		    put("7","|:::|");
		    put("8","|::|:");
		    put("9","|:|::");
		    put("0","||:::");
		}
	    };
	    String temp = zip + getCheckDigit(zip);
	    for (int i = 0;i < 6; i++) {
	    	String s = temp.substring(i,i+1);
	    	stored += hasher.get(s);
	    }
	    return stored + "|";
    }
    public static String toZip(String code) {
    	if(code.length() != 32 || (code.charAt(0) != '|' || code.charAt(code.length()-1) != '|')){
      		throw new IllegalArgumentException();
    	}
    	String s = "";
    	HashMap<String, String> hasher = new HashMap<String,String>() {
		{
		    put(":::||", "1");
		    put("::|:|", "2");
		    put("::||:", "3");
		    put(":|::|", "4");
		    put(":|:|:", "5");
		    put(":||::", "6");
		    put("|:::|", "7");
		    put("|::|:", "8");
		    put("|:|::", "9");
		    put("||:::", "0");
		}
	    };
	    String st = code.substring(1, code.length()-2);
	    for (int i = 0; i < st.length()-5;i += 5) {
	    	//System.out.println(st.substring(i,i+5));
	    	//System.out.println(hasher.get(st.substring(i,i+5)));
	    	s += hasher.get(st.substring(i,i+5));
	    }
	    return s;
    }
    public String getZip() {
		return zipper;
    }
    public String getCode() {
    	return toCode(zipper);
    }
    public String toString() {
    	return getCode() + " " + "(" + getZip() + ")";
    }
    public boolean equals(Barcode x) {
		return x.getZip().equals(getZip());
    }
    public int compareTo(Barcode x) {
    	return x.getZip().compareTo(getZip());
    }
}
