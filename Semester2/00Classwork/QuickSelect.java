/*
* for loop
* counters for start and end
*/
import java.util.*;

public class QuickSelect {
	public static int partition (int[] data, int start, int end) {
		Random rand = new Random();
		int pivotInd = rand.nextInt(end-start+1) + start;
		int[] newData = Arrays.copyOfRange(data,start,end+1);
		int pivot = data[pivotInd];
		List<Integer> newerData = new ArrayList<Integer>();
		newerData.add(pivot);
		for (int i = 0; i < newData.length; i ++) {
			int x = newData[i];
			if (x<pivot) {
				newerData.add(0,x);
			}
			else {
				newerData.add(x);
			}
		}
		//int[] holder = new int[newerData.size()];
		for (int i = 0; i < newData.length; i ++) {
			newData[i] = newerData.get(i);
			System.out.println(newData[i]);
		}
		System.out.println(pivot);
		return newerData.indexOf(pivot);

	}
	public static void main(String[] args) {
		int[] data = new int[10];
		for (int i =0 ;i < 10; i ++) {
			data[i] = i +1;
		}
		partition(data,1,5);
	}
}
