import java.util.*;

public class Sorts{

	private static void swap (int ind1, int ind2, int[] data){
		int temp = data[ind1];
		data[ind1] = data[ind2];
		data[ind2] = temp;
    }
    private static boolean eval(int ind1, int ind2, int[] data){
    	return data[ind1] >= data[ind2];
    }


    public static void heapsort(int[] data){
		heapify(data);
		for (int i = data.length - 1; i > 0; i--){
		    swap(0, i, data);
		    pushDown(0, data, i - 1);
		}
    }
    
    private static void heapify(int[]data){
		for (int i = 0; i < data.length; i++){
		    pushDown(i, data, data.length - 1);
		}	
    }

    private static void pushDown(int index, int[] data, int limit){
    	int left = index * 2 + 1;
    	int right = left + 1;
    	boolean leftLimit = left <= limit;
    	boolean rightLimit = right <= limit;
		if (leftLimit && !eval(index,left,data) && (!rightLimit || eval(left,right,data))){
		    swap(index, left, data);
		    pushDown(left, data, limit);
		}
		else if(rightLimit && !eval(index,right,data) && (!leftLimit || eval(right,left,data))){
		    swap(index, right, data);
		    pushDown(right, data, limit);
		}
    }
}