
public class Merge {


	public static void mergesort(int[]data){
    	int[] temp = new int[data.length];
        mergesortAux(data, temp, 0, data.length - 1);
    }
    
    public static void insertionsort(int[] data, int lo, int hi){  // I needed some help from Jerry Sun on this function. For some reason my sort from last semester wouldn't work.
        int ind;
        for (int i = lo; i < hi+1; i ++) {
            int k = data[i];
            for (ind = i; ind > lo && k < data[ind-1]; ind --) {
                data[ind] = data[ind-1];
            }
            data[ind] = k;
        }
    
    }

    private static void mergesortAux(int[]data,int[]temp,int low, int high){
        if (high - low < 11){
            insertionsort(data,low,high);
        }
        else {
	        for (int i = low; i <= high; i++){
	            temp[i] = data[i];
	        }
	        int mid = (low + high)/2;
	        mergesortAux(temp, data, low, mid );
	        mergesortAux(temp, data, mid + 1, high);
	        merge(data, temp, low, mid , high);
	    }
    }
    
    private static void merge(int[]data, int[]temp, int low, int mid, int high){
        int count = low;
        int hold = low;
        int middle = mid + 1;

        while (count<= mid && middle <= high){
            if (temp[count] < temp[middle]){
                data[hold] = temp[count];
                count ++;
            }
            else{
                data[hold] = temp[middle];
                middle++;
            }
            hold ++;
        }

        while (count <= mid) {
        	data[hold] = temp[count];
        	count ++;
        	hold ++;
        }
        while (middle <= high) {
        	data[hold] = temp[middle];
        	hold ++;
        	middle ++;
        }
    }
}
