import java.util.*;
public class FrontierQueue implements Frontier {

	private LinkedList<Location> set;

	public FrontierQueue() {
		set = new LinkedList<Location>();
	}
	public Location next() {
		return set.removeFirst();
	}
	public void add(Location newVal) {
		set.addLast(newVal);
	}
	public boolean hasNext() {
		return !(set.size() == 0);
	}
}
