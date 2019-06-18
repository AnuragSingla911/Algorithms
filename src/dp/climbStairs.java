package dp;

public class climbStairs {

	public static void main(String[] args) {
		
		System.out.println(new climbStairs().climbStairs(4));
	}
	
	 public int climbStairs(int A) {
		 
		 return find(A);
		 
	    }
	 
	 private int find(int no) {
		 if(no == 0) {
			 return 1;
		 }
		 
		 if(no == 1) {
			 return 1;
		 }
		 int no1 = find(no-1) + find(no-2);
		 return no1;
	 }
}
