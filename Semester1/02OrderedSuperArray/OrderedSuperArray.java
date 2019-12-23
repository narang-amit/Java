import java.util.*;

public class OrderedSuperArray extends SuperArray {

	public OrderedSuperArray() {
		super(10);
	}

	public OrderedSuperArray(int s) {
		super(s);
	}

	public OrderedSuperArray(String[] list) {
		super(list.length);
		for (int x = 0; x < list.length; x ++) {
			add(list[x]);
		}
	}
	//Fix from Ivan
	private String[] data() {
		String[] info = new String[size()];
		for (int i = 0; i < size(); i++) {
			info[i] = get(i);
		}
		return info;
	}
	//Overrides previous method
	public void add(int i, String temp) {
		add(temp);
	}
	public boolean add(String temp) {
		super.add(findIndexBinary(temp),temp);
		return true;
	}
	public String set(int i, String temp) {
		throw new UnsupportedOperationException();
	}

	private int indexOfBinary(String s) {
		int st = 0;
		int e = size();
		String[] big = data();
		if (e ==1) {
			if (s.equals(big[0])) {
				return 0;
			}
			return -1;
		}
		while (st != e) {
			int ste = st + e;
			if (s.equals(big[ste/2])) {
				e = ste /2;
				if (e != 0 && big[e-1].equals(s)) {
					st = e -1;
				}
				else {
					return st;
				}
			}
			else {
				if (s.compareTo(big[ste/2]) > 0) {
					st = ste / 2;
				}
				else {
					e = ste/2;
				}
			}
		}
		return -1;
	}

	private int findIndexBinary(String str) {
		int start = 0; 
		int end = size();
		while (size() != 0 && start != end) {
			if (get((start+end)/2).compareTo(str) < 0) {
				if (end-start > 1) {
					start = (end+ start)/2;
				}
				else {
					start ++;
				}
			}
			else {
				if (end-start>1) {
					end = (start+ end)/2;
				}
				else {
					end --;
				}
			}
		}
		return end;
	}
}