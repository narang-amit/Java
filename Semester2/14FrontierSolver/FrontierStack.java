//SOrry

import java.util.*;
public class FrontierStack implements Frontier {

	private Stack<Location> set;

	public FrontierStack() {
		set = new Stack<Location>();
	}
	public Location next() {
		return set.pop();
	}
	public void add(Location temp) {
		set.add(temp);
	}
	public boolean hasNext() {
		return !(set.size() == 0);
	}
}
