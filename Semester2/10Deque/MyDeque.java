import java.util.*;
@SuppressWarnings("unchecked")

public class MyDeque<T>{
    
    private T[] holder;
    public int first, last;
    private int length;
    //Constructors
    public MyDeque(){
		length = 0;
		last = -1;
		holder = (T[]) new Object[10];
    }
    public MyDeque(int initCap){
		holder = (T[]) new Object[initCap];
		length = 0;
		last = -1;
    }
    //Mutators
    public void resize(){
		T[] temp = holder;
		int size = holder.length;
		holder = (T[])new Object[size*2+1];
		for(int i = 0; i < size; i++){
		    holder[i] = temp[(first+i)%length];
		}
		first = 0;
		last = size - 1;
    }
    public void addFirst(T val){
		checkNull(val);
		if(size() == holder.length){
		    resize();
		}
		first --;
		if (first == -1){
		    first = holder.length - 1;
		}
		holder[first] = val;
		length++;
    }
    public void addLast(T val){
		checkNull(val);
		if(size() == holder.length) {
		    resize();
		}
		last = (last + 1) % holder.length;
		holder[last] = val;
		length++;
    }
    public T removeFirst(){
		check();
		T lastVal = holder[first];	
		holder[first] = null;
		first = (first + 1)%holder.length;
		length-=1;
		return lastVal;
    }
    public T removeLast(){
		check();
		T lastVal = holder[last];
		holder[last] =  null;
		last -= 1;
		if(last == -1){
		    last = holder.length - 1;
		}
		length--;
		return lastVal;
    }
    //Accessors
    public int size() {
    	return length;
    }  
    public T getFirst(){
		check();
		return holder[first];
    }
    public T getLast(){
		check();
		return holder[last];
    }
    //Helpers
    private void check() {
    	if (length == 0) {
    		throw new NoSuchElementException();
    	}
    }
    private void checkNull(T val) {
    	if (val == null) {
    		throw new NullPointerException();
    	}
    }
}