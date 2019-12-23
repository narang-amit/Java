/* Functions left to code:
* add(index, value), check
*remove(value)
*remove(index)
*/
public class MyLinkedList {

    private Node first, last;
    private int length;

    public String toString() {
      String holder = "[";
      Node node = first;
      if (length == 0) {
        return "[]";
      }
      while (node != null) {
          holder += node.getValue() + ",";
          node =  node.getNext();
      }
      return holder.substring(0,holder.length()-1) + "]";
    }

    public int size() {
        return length;
    }

    public boolean add(Integer value) {
      Node temp = new Node(value);
        if (length == 0) {
            first = last = temp;
            length = 1;
            return true;
        }
      last.setNext(temp);
      temp.setPrev(last);
      length ++;
      last = temp;
      return true;
    }

    public void add(int index, Integer value) {
      Node newy = new Node(value);
      Node curr;
      if (length == 0){
          newy.setPrev(newy);
          newy.setNext(newy);
          first = newy;
          last = newy;
      }
      else{
        if (index < 0 || index > length) {
          throw new IndexOutOfBoundsException();
        }
        else if (index == 0){
            curr = first;
            newy.setPrev(newy);
            newy.setNext(curr);
            curr.setPrev(newy);
            first = newy;
          }
          else if (index == length || index == length +1){
        curr = last;
        newy.setPrev(curr);
        newy.setNext(null);
        curr.setNext(newy);
        last = newy;
          }
          else{
        curr = getNode(index);
        //System.out.println("Here");
        curr.getPrev().setNext(newy);
        newy.setPrev(curr.getPrev());
        newy.setNext(curr);
        curr.setPrev(newy);
        //System.out.println(this);
        }
      }
      length ++;
    }

    public Integer get(int index) {
      if (index > length || index < 0) {
        throw new IndexOutOfBoundsException();
      }
      Node node = getNode(index);
      return node.getValue();
    }

    public int set(int index, Integer newValue) {
      if (index > length || index < 0) {
        throw new IndexOutOfBoundsException();
      }
    Node node = getNode(index);
    int temp = node.getValue();
    node.setData(newValue);
    return temp;
    }

    public int indexOf(int value)  {
      Node node = first;
      for (int i = 0; i < length; i ++) {
        if (node.getValue() == value) {
          return i;
        }
        node = node.getNext();
      }
      return -1;
    }

    public Integer remove(int index) {
      if (index >= length || index < 0) {
        throw new IndexOutOfBoundsException();
      }
      Node temp = getNode(index);
      Node left = getNode(index-1);
      Node right;
      if (length == 0) {
        first = last = null;
      }
      else if (index == length-1) {
        last = left;
        left.setNext(null);
      }
      else if (index == 0) {
        right = getNode(index+1);
        first = right;
        right.setPrev(null);
      }
      else {
        right = getNode(index+1);
        left.setNext(right);
        right.setPrev(left);
      }
      length --;
      return temp.getValue();
    }

    public boolean remove(Integer value) {
      int x = indexOf(value);
      if (x == -1) {
        return false;
      }
      else {
        remove(x);
        return true;
      }
    }

    public void clear() {
      first = last = null;
      length = 0;
    }

    private Node getNode(int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException();
        }
    Node node = first;
    int cnt = 0;
    while (cnt < index) {
        node = node.getNext();
        cnt ++;
    }
    return node;
    }

    private class Node {

    private Node next, prev;
    private Integer data;

    public Node(Integer info) {
        data = info;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public Integer getValue() {
        return data;
    }

    public String toString() {
        return data + "";
    }

    public void setNext(Node s) {
        next = s;
    }

    public void setPrev(Node s) {
        prev = s;
    }

    public void setData(Integer value) {
        data = value;
    }

    }
}
