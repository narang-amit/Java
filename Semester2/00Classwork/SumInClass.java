public class SumInClass {

    public static boolean isPossibleSum(int n, int target) {
	return sumHelp(1,n,0,target);
    }

    public static boolean sumHelp(int current, int n, int sum, int target) {
	if (current > n) {
	    System.out.println(sum);
	    return sum == target;
	}
	return sumHelp(current+1,n,sum,target) || sumHelp(current+1,n,sum+current,target);
    }
    public static void main(String[] args) {
	System.out.println(isPossibleSum(5,4));
    }

}
