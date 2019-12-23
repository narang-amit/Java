import java.util.*;
@SuppressWarnings("unchecked")

public class Sorts {

	public static void radixsort(MyLinkedListImproved<Integer> data) {

		if (data.get(0) != null) {
			MyLinkedListImproved<Integer> negative, positive;
			negative = new MyLinkedListImproved<>();
			positive = new MyLinkedListImproved<>();
			for (Integer value : data) {
				if (value < 0) {
					negative.add(value*-1);
					//System.out.println("Negative"+value);
				}
				else {
					positive.add(value);
					//System.out.println("Positive" + value);
				}
			}
			/*for (Integer tmp: negative) {
				System.out.println("neg" + tmp);
			}
			*/
			radixsortAux(negative);
			radixsortAux(positive);
			data.clear();
			for (Integer pos: positive) {
				data.add(pos);
			}
			for (Integer neg: negative) {
				data.add(0,neg*-1);
			}
		}

	}

	public static void radixsortAux(MyLinkedListImproved<Integer> data) {
		if (data.size() == 0) {
			return;
		}
		MyLinkedListImproved<Integer>[] buck = new MyLinkedListImproved[10];
		for (int i = 0; i < 10; i ++) {
			buck[i] = new MyLinkedListImproved<Integer>();
		}
		/*for (Integer tmep: data) {
			System.out.println("" + tmep);
		}
		*/
		int max = digits(data.get(data.max()));
		for (int i = 0; i < max; i ++) {
			for (Integer x: data) {
				int temp = (int) (x/Math.pow(10,i)) % 10;
				buck[temp].add(x);
			}
			data.clear();
			for (MyLinkedListImproved bucket: buck) {
				data.extend(bucket);
				bucket.clear();
			}
		}

	}

	public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data) {
		radixsort(data);
	}

	// Taken shamelessly from Baeldung, but I don't see how I would even be able to change this function
	// should work for all <Integer>s (goes up to 10 digits)
	private static int digits(Integer number) {
		if (number < 100000) {
    		if (number < 100) {
        		if (number < 10) {
            	return 1;
	        } else {
	            return 2;
	        }
    	}
    	else {
	        if (number < 1000) {
	            return 3;
	        } else {
	            if (number < 10000) {
	                return 4;
	            } else {
	                return 5;
	            }
	        }
    	}
	}
		else {
		    if (number < 10000000) {
		        if (number < 1000000) {
		            return 6;
		        } else {
		            return 7;
		        }
	    	}
	    	else {
		        if (number < 100000000) {
		            return 8;
		        } else {
		            if (number < 1000000000) {
		                return 9;
		            } else {
		                return 10;
		            }
	        	}
    		}
		}
	}
}
