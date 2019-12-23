public class CirculatingBook extends LibraryBook {
    
    private String currentHolder;
    private String dueDate;

    //Constructor
    public CirculatingBook(String auth, String tit, String ISB, String callNumber) {
        super(auth,tit,ISB, callNumber);
        returned();
    }
    //GetterSetter Pair #5- currentHolder
    public String getCurrentHolder() {
	   return currentHolder;
    }
    public void setCurrentHolder(String s) {
	   currentHolder = s;
    }
    //GetterSetter Pair #6 - dueDate
    public String getDueDate() {
	   return dueDate;
    }
    public void setDueDate(String s) {
	   dueDate = s;
    }
    public void checkout(String a, String b) {
        currentHolder = a;
        dueDate = b;
    }
    public void returned() {
        currentHolder = null;
        dueDate = null;
    }
    public String circulationStatus() {
        if (dueDate == null) {
            return "The Book is here! Never fear";
        }
        return "The Book is not here! Blame: " + getCurrentHolder() + ". You can come in to check it out on " + getDueDate() + ".";
    }
    public String toString() {
        if (dueDate == null) {
            return super.toString();
        }
        else {
            return super.toString() + ", Current Holder: " + getCurrentHolder() + ", Due Date: " + getDueDate();
        }
    }
}
