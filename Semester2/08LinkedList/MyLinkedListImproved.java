// if you do
// class fru<T extends Interface<T>>
// user can only use types T that are Interface (comparable, iterable, etc)
import java.util.*;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{

    private Node first, last;
    private int length;


    public Iterator<T> iterator() {
      return new NodeIterator(first);
    }

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

    public boolean add(T value) {
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
//fix
    public void add(int index, T value) {
      Node temp = new Node(value);
      Node curr;
      if (length == 0){
          temp.setPrev(temp);
          temp.setNext(temp);
          first = temp;
          last = temp;
      }
      else{
        if (index < 0 || index > length) {
          throw new IndexOutOfBoundsException();
        }
        else if (index == 0){
            curr = first;
            temp.setPrev(temp);
            temp.setNext(curr);
            curr.setPrev(temp);
            first = temp;
          }
          else if (index == length || index == length +1){
        curr = last;
        temp.setPrev(curr);
        temp.setNext(null);
        curr.setNext(temp);
        last = temp;
          }
          else{
        curr = getNode(index);
        //System.out.println("Here");
        curr.getPrev().setNext(temp);
        temp.setPrev(curr.getPrev());
        temp.setNext(curr);
        curr.setPrev(temp);
        //System.out.println(this);
        }
      }
      length ++;
    }

    public T get(int index) {
      if (index > length || index < 0) {
        throw new IndexOutOfBoundsException();
      }
      Node node = getNode(index);
      return node.getValue();
    }

    public T set(int index, T newValue) {
      if (index > length || index < 0) {
        throw new IndexOutOfBoundsException();
      }
    Node node = getNode(index);
    T temp = node.getValue();
    node.setData(newValue);
    return temp;
    }

    public int indexOf(T value)  {
      Node node = first;
      for (int i = 0; i < length; i ++) {
        if (node.getValue() == value) {
          return i;
        }
        node = node.getNext();
      }
      return -1;
    }

    public T remove(int index) {
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

    public boolean remove(T value) {
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

    public Node getNode(int index) {
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
public int max(){
  if (length == 0) {
    return -1;
  }
  T one = getNode(0).getValue();
  int ind, tempInd;
  ind = tempInd = 0;
  for (T iterate: this) {
    if (iterate.compareTo(one) > 0) {
      one = iterate;
      tempInd = ind;
    }
    ind ++;
  }
  return tempInd;
}
    public int min(){
      int temp = -1;
      int counter = 0;
      T value = null;
      try{
          value = first.getValue();
          temp = 0;
      }
      catch(NullPointerException e){
          return temp;
      }

      for(T obj: this){
          if (obj.compareTo(value) < 0){
            temp = counter;
            value = obj;
          }
          counter+=1;
      }
      return temp;
    }
    public Node getLast() {
      return last;
    }
    private class Node {

      private Node next, prev;
      private T data;

      public Node(T info) {
          data = info;
      }

      public Node getNext() {
          return next;
      }

      public Node getPrev() {
          return prev;
      }

      public T getValue() {
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

      public void setData(T value) {
          data = value;
      }

    }

    private class NodeIterator implements Iterator<T> {
      Node s;

      public NodeIterator(Node node) {
        s = node;
      }
      public T next() {
        if (!hasNext()) {
          System.exit(0);
        }
        T x = s.getValue();
        s = s.getNext();
        return x;
      }
      public boolean hasNext() {
        return s != null;
      }
    }
    public void extend(MyLinkedListImproved<T> other){
      if (other.size() != 0) {
        if (length == 0) {
          first = other.getNode(0);
          last = other.getLast();
        }
        else {
          last.setNext(other.getNode(0));
          other.getNode(0).setPrev(last);
          last = other.getLast();
        }
        length += other.size();
        other.clear();
      }
  }

    public static void main(String[] args) {
      MyLinkedListImproved<Integer> temp = new MyLinkedListImproved<>();
      for (int i = 0; i < 15; i ++) {
        temp.add(new Integer(i));
      }
      System.out.println(temp.min());

    }
}
