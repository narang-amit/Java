import java.util.*;
public class Sorts {
	//Naming
	public static String name() {
		return "09.Narang.Amit";
	}
	//Selection Sort
	public static void selectionSort(int[] data) {
		if (data.length == 0) {
			//0 Case
			System.out.println("Silly Mr. K- you know this can't happen");
		}
		else {
			for (int i = 0;i < data.length; i++) {
				int curr = i;
				for (int j = i; j < data.length; j ++) {
					if (data[j] < data[curr]) {
						curr = j;
					}
				}
				int s = data[curr];
				data[curr] = data[i];
				data[i] = s;
			}
		}
	}
	
	//Insertion Sort
	public static void insertionSort(int[] data) {
		if (data.length == 0) {
			//0 Case
			System.out.println("silly Mr. K- you know this can't happen!");
		}
		else if (!isSorted(data)) {
			for (int i = 0;i < data.length; i ++) {
				//Runs through list
				int curr = i;
				for (int j = curr; j >0; j--) {
					if (data[j-1]>data[j]) {
						curr = data[j-1];
						data[j-1] = data[j];
						data[j] = curr;
					}
				}	
			}	
		}
	}
	//Bubble Sort
    public static void bubbleSort(int[] data) {
    	if (data.length == 0) {
    		//0 Case
    		System.out.println("silly Mr. K- you know this can't happen!");
    	}
    	else if (!isSorted(data)) {
    		for (int i = 0; i < data.length; i ++) {
    			//Loops through list
    			int x = data.length - i;
    			for (int j = 0; j < x-1; j++) {
    				//Loops through pairs further ahead
    				if (data[j] > data[j+1]) {
    					//swaps
    					int temp = data[j+1];
    					data[j+1] = data[j];
    					data[j] = temp;
    				}
    			}
    		}
    	}
    }
    public static boolean isSorted(int[] data) {
	for (int n = 0; n < data.length-1; n ++) {
	    if (data[n]>data[n+1]) {
		return false;
	    }
	}
	return true;
    }
}
