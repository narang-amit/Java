public class Stack {

	private MyLinkedListImproved<Double> list;

	public Stack() {
		list = new MyLinkedListImproved<Double>();
	}
	public Double pop() {
		return list.remove(list.size()-1);
	}
	public Double peek() {
		return list.get(list.size()-1);
	}
	public void push(Double m) {
		list.add(m);
	}
}