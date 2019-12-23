//SOrry

import java.util.*;

public class RunningMedian {

	private MyHeap<Double> less, more;
	int size;

	public RunningMedian() {
		less = new MyHeap<Double>();
		more = new MyHeap<Double>(false);
	}
	public void add(Double element){
	    if(more.size() == 0 && less.size() == 0){
	      less.add(element);
	    }
	    else if(element > less.peek()){
	      more.add(element);
	      rebalance();
	    }
	    else{
	      less.add(element);
	      rebalance();
	    }
	    size++;
	  }
	 public void rebalance(){
	    if(less.size() - more.size() > 1){
	    more.add(less.remove());
	    }
	    else if(more.size() - less.size() > 1){
	      less.add(more.remove());
	    }
	  }
	private int size() {
		return less.size() + more.size();
	}

	public Double getMedian() {
		if (less.size() < more.size()) {
			return more.peek();
		}
		if (less.size() > more.size()) {
			return less.peek();
		}
		Double x = less.peek() + more.peek();
		return x/2;
	}
  }
