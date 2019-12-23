public class Quick {

	private static void swap(int[] data, int ind1, int ind2) {
		int temp = data[ind1];
		data[ind1] = data[ind2];
		data[ind2] = temp;
	}
	private static int rando(int start, int end) {
		return (int) (Math.random() * (end-start+1) + start);
	}
    public static int quickselect(int[] data, int k) {
		int start = 0;
		int end = data.length-1;
		int[] holder = partition(data, start, end);
		int low = holder[0];
		int high = holder[1];
		while (k < low || k > high){
			if (k < low){
				end = low- 1;
			}
			else{
				start = high;
			}
		    holder = partition(data, start, end);
			low = holder[0];
		    high = holder[1];
		}
		
		return data[low];
	}
	private static int[] partition(int[] data, int start, int end) {
			int pivotInd = rando(start,end);
			int pivot = data[pivotInd];
			int lt = start;
			int i = start;
			int gt = end;
			while (i <= gt) {
				if (data[i] > pivot) {
					swap(data,i,gt);
					gt --;
				}
				else if (data[i] < pivot) {
					swap(data,i,lt);
					lt ++;
					i ++;
				}
				else {
					i ++;
				}
			}
			//System.out.println(pivot);
			return new int[] {lt,i};
	}
	public static void quicksort(int[] data) {
		quicksortAux(data,0,data.length-1);
	}
	public static void quicksortAux(int[] data,int start, int end) {
		if (start < end) {
			int[] holder = partition(data,start,end);
			quicksortAux(data,start,holder[0]-1);
			quicksortAux(data,holder[1],end);
		}
	}
	public static void main(String[] args) {
		int[] data = {10,2,33,115,566,342};
		//System.out.println(data.length);
		System.out.println(quickselect(data,5));
	}
}