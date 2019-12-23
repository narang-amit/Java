public class Book {
    //Instance Variables
    private String author;
    private String title;
    private String ISBN;
    //Null Constructor
    public Book() {
	   author = "Amit Narang";
	   title = "The Art";
	   ISBN = "231851098";
    }
    //Constructor with three  parameters
    public Book(String auth, String tit, String IS) {
	   author = auth;
	   title = tit;
	   ISBN = IS;
    }
    //GetterSetter Pair #1: Author
    public String getAuthor() {
	   return author;
    }
    public void setAuthor(String s) {
	   author = s;
    }
    //GetterSetter Pair #2: Title
    public String getTitle() {
	   return title;
    }
    public void setTitle(String s) {
	   title = s;
    }
    //GetterSetter Pair #3: ISBN
    public String getISBN() {
	   return ISBN;
    }
    public void setISBN(String s) {
	   ISBN = s;
    }
    //ToString Function
    public String toString() {
	   String s = ",";
	   return "Title: " + title + ", Author: " + author +  ", ISBN: "+ ISBN ;
    }
}
