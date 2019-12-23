/**
 * Super Array!
 * A new way to store your information.
 *
 * @author Amit Narang
 * @version 1.0
 * @since 10-28-17
 */

public class SuperArray{
    
    private int size;
    private String[] data;
    
    /**
     * This is the default constructor for a SuperArray.
     * It makes an empty SuperArray that can hold up to 10 values.
     */
    public SuperArray() {
	data = new String[10];
	size = 0;
    }
    /** 
     * This is an alternate constructor for a SuperArray.
     * It makes an emptry SuperArray that holds a specified amount of values.
     * @param startingCapacity This is the amount the array should start out holding.
     */
    public SuperArray(int startingCapacity) {
	data = new String[startingCapacity];
	size = 0;
    }
    /** 
     * This method clears the SuperArray and returns it to its default value.
     */
    public void clear() {
	data = new String[10];
	size = 0;
    }
    /** 
     * This method accesses the private instance variable "size".
     * @return int This returns the "size" value for the object.
     */
    public int size() {
	return size;
    }
    /** 
     * This method accesses the private instance variable "data".
     * @return String[] This returns the "data" value for the object.
     */
    public String[] getData() {
	return data;
    }
    /** 
     * This method checks if the SuperArray is empty.
     * @return boolean This returns true if the SuperArray is empty.
     */
    public boolean isEmpty() {
	return size == 0;
    }
    /** 
     * This method makes the total possible storage of the SuperArray 
     * twice as large.
     */
    public void bumpSize() {
	int a = data.length;
	String[] x = new String[2*a];
	if (a - size <= 5) {
	    for (int i = 0;i<size;i++) {
		x[i] = data[i];
	    }
	    data = x;
	}
    }	    
    /** 
     * This method appends an item to the end of the SuperArray after
     * checking to see if it has space.
     * @param toAdd This is the item to be appended.
     * @return boolean This returns true if the operation has been successfully
     * completed.
     */
    public boolean add(String toAdd) {
	bumpSize();
	data[size] = toAdd;
	size ++;
	return true;
    }
    /** 
     * This method prints out the SuperArray in a 
     * well formatted manner.
     * @return String This is the SuperArray.
     */
     public String toString() {
	 String s = "[";
	 for (int i = 0;i<size;i++) {
	     s += data[i] +", ";
	 }
	 return s + "]";
     }
    /**
     * This method returns the value at a given index.
     * It prints an error if the index given is out of bounds.
     * @param index This is the index to pull the value at. 
     * @return String This is the value stored in the SuperArray at that index.
     */
    public String get(int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	else {
	    return data[index];
	}
    }
    /** 
     * This method sets the value at a certain index, 
     * provided that the index is valid.
     * @param index This is the index to store the value.
     * @param info This is the String to be stored at the index.
     * @return String This is either an error or "true"
     */
    public String set(int index, String info) {
  	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	else {
	    String s = data[index];
	    data[index] = info;
	    return s;
	}
    }
    /**
     * This method checks the SuperArray to see whether
     * a certain value is present.
     * @param value This is the value we're looking for.
     * @return boolean Whether the value is present or not.
     */
    public boolean contains(String value) {
	boolean a = false;
	int i = 0;
	while (!a && i < size) {
	    if (data[i].equals(value)) {
		a = true;
	    }
	    i ++;
	}
	return a;
    }
    /** 
     * This method checks the index of a certain value
     * , returning -1 if the value is not present
     * @param value The value we are looking for the index of. 
     * @return int The (first) index of the value.
     */
    public int indexOf(String value) {
	if (contains(value)) {
	    for (int i = 0;i<size;i++) {
		if (data[i].equals(value)) {
		    return i;
		}
	    }
	}
	return -1;
    }
    /** 
     * This method checks for the last index of a certain value
     * , returning -1 if the value is not present
     * @param value The value we are looking for the last index of.
     * @return int The last index of the value.
     */
    public int lastIndexOf(String value) {
	if (contains(value)) {
	    for (int i = size - 1;i> -1;i -= 1) {
		if (data[i].equals(value)) {
		    return i;
		}
	    }
	}
	return -1;
    }
    /** This method adds an element  at a certain index
     * , with the elements to the right shifting one spot.
     * @param index This is where we add the element.
     * @param element This is what we add.
     */
    public void add(int index, String element) {
	if (index > size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	else {
		bumpSize();
		for (int i = size; i >= index;i --) {
			data[i+1] = data[i];
		}
		data[index] = element;
		size ++;
	}
}
    /**
     * This method removes the element at the specified position in this
     * SuperArray and shifts all subsequent elements to the left.
     * Returns the element removed.
     * Robin Han helped me with the (both) remove function, as my old one didn't
     * work well (It left an extra null at the end). I've left my original code 
     * in theform of a multi-line comment. 
     * @param index The position we want to remove the element from.
     * @return String The element we removed.
     */
    public String remove(int index) {
	if (index < 0 || index >= size) {
	    System.out.println("Error!");
	    return null;
	}
	else {
	    String[] a = new String[data.length-1];
	    String b = data[index];
	    for (int i = 0;i<index;i++) {
		a[i] = data[i];
	    }
	    for (int i = index;i <size;i++) {
		a[i] = data[i];
	    }
	    data = a;
	    size --;
	    return b;
	    /*
	      String s = data[index];
	    String[] a = new String[size-index +1];
	    int x = 0;
	    for (int i = index + 1;i<size;i++) {
		a[x] = data[i];
		x ++;
	    }
	    x = 0;
	    for (int i = index;i<size;i++) {
		data[i] = a[x];
		x ++;
	    }
	    return s;
	    */
	}
    }
    /** 
     *This method removes the first occurence of the specified element
     * from this SuperArray if it is present. Shift all the subsequent
     * elements to the left.
     * @param element The element we want to remove.
     * @return boolean True if successfully completed.
     */
    public boolean remove(String element) {
	if (!contains(element)) {
	    return false;
	}
	else {
	    String[] a = new String[data.length-1];
	    int x = indexOf(element);
	    for (int i = 0;i<x;i++) {
		a[i] = data[i];
	    }
	    for (int i = x;i <size;i++) {
		a[i] = data[i];
	    }
	    data = a;
	    size --;
	    return true;
	    /*
	      int x = indexOf(element);
	    String s = data[x];
	    String[] a = new String[size-x +1];
	    int y = 0;
	    for (int i = x + 1;i<size;i++) {
		a[x] = data[i];
		y ++;
	    }
	    y = 0;
	    for (int i = x;i<size;i++) {
		data[i] = a[x];
		y ++;
	    }
	    return true;
	    */
	}
    }
}
    
