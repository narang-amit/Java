public class Driver {
    public static void main(String[] args){
     MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
     a.add(new Integer(4));
     System.out.println(a.get(0));
     MyLinkedListImproved<String> b = new MyLinkedListImproved<>();
     b.add("Hello");
     System.out.println(b.get(0));

   }
}