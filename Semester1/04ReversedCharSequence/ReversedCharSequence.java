import java.util.*;
import java.lang.*;

public class ReversedCharSequence implements CharSequence {
    //Instance Variable
    public String store;
    //Constructor
    // Converts the input String to a StringBuilder, reverses it, and stores
    // it as a String again in the instance variable.
    // Since it's a String (but reversed), we can run all of the String
    // functions on it without coding anything.
    public ReversedCharSequence(String input) {
	StringBuilder temp = new StringBuilder(input);
	store = temp.reverse().toString();
    }
    // Necessary Function Definitions 
    public char charAt(int index) {
	return store.charAt(index);
    }
    public int length() {
	return store.length();
    }
    public CharSequence subSequence(int start, int end) {
	return store.subSequence(start,end);
    }
    public String toString() {
	return store.toString();
    }
}
