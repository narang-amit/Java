public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    //Instance Variables
    private String callNumber;
    //Constructor with 4 parameters
    public LibraryBook(String auth, String tit, String IS, String num) {
	   super(auth,tit,IS);
       callNumber = num;
    }
    //GetterSetter Pair #4: callNumber
    public String getCallNumber() {
	   return callNumber;
    }
    public void setCallNumber(String s) {
	   callNumber = s;
    }
    //Abstract methods, later to be implemented
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    //LibraryBook compareTo, implemented from Comparable<LibraryBook>
    public int compareTo(LibraryBook a) {
	   String x = a.getCallNumber();
       String y = this.getCallNumber();
	   return x.compareTo(y);
    }
    //ToString function
    public String toString() {
	   return super.toString() + ", Circulation Status: " + circulationStatus() + ", Call Number: " + getCallNumber();
    }
}
