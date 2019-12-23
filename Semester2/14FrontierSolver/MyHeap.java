//SOrry
import java.util.*;
import java.lang.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

	private T[] data;
	private boolean max;
	private int size;

	public MyHeap() {
		this(true);
	}

	public MyHeap(boolean val) {
		data = (T[]) new Comparable[10];
		size = 0;
		max = val;
	}

	public void add(T value) {
		if (size == data.length) {
			resize();
		}
		data[size] = value;
		pullUp(value,size);
		size ++;
	}

	public T remove(){
		T temp = data[0];
		data[0] = data[size-1]; 
		pushdown(0);
		data[size-1] = null;
		size--;
		return temp;
    }
	
	public T peek() {
		return data[0];
	}

	public int size() {
		return size;
	}

	private void resize() {
		T[] newData = (T[]) new Comparable[2*size +1];
		for (int i =0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	private void pullUp(T val, int start) {
		int newStart = (start-1)/2;
		if ((max && val.compareTo(data[newStart]) > 0) || (!max && val.compareTo(data[newStart]) < 0)) {
			swap(data,start, newStart);
			pullUp(val,newStart);
		}
	}



private void help(int index, int num) {
	swap(data,index,2*index+num);
	pushdown(2*index+num);
}


public void pushdown(int index) {
	if (2*index+2<size){
		int temp = data[2*index+2].compareTo(data[2*index+1]);
		int tempO = data[2*index+2].compareTo(data[index]);
		int tempA = data[2*index+1].compareTo(data[index]);
	    if (max && (tempO >0 || tempA >0)){
	        if (temp>0){
				help(index,2);
			}
			else{
				help(index,1);
			}
	    }
	    else if(!max && (tempO<0 || tempA<0)){
	        if (temp<0){
				help(index,2);
			}
			else{
				help(index,1);
			}
	    }
	}
	else if (2*index+1<size){
		int tempA = data[2*index+1].compareTo(data[index]);
		if(max && tempA>0){
			help(index,1);
		}
		else if(!max && tempA<0){
			help(index,1);
		}
	}
}
	private void swap(T[] holder, int ind1, int ind2) {
		T temp = holder[ind1];
		holder[ind1] = holder[ind2];
		holder[ind2] = temp;
	}
}
