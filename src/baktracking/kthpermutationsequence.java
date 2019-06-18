package baktracking;

import java.util.ArrayList;

public class kthpermutationsequence {

	public static void main(String[] args) {
		System.out.println(new kthpermutationsequence().getPermutation(0, 6));
	}

	public String getPermutation(int A, int B) {
		
		for(int i = 1; i <= A; i++) {
			store.add(i);
		}

		find(A,B);

		return answer.toString();


	}
	
	private ArrayList<Integer> store = new ArrayList<Integer>();

	private void find(int A, int B) {
		System.out.println("A and B "+ A + " "+ B);
		
		
		if(A < 2) {
			
			answer.append(store.get(0));
			
			return;
		}
		
		if(B ==0) {
			B=A;
		}

		int factorial = factorial(A-1);
		int factor = B/(int)factorial;
		
		if(B%factorial==0) {
			int val = store.get(factor-1);
			answer.append(val);
			store.remove(factor-1);
			
		}else {
			factor++;
			int val = store.get(factor-1);
			answer.append(val);
			store.remove(factor-1);
		}
		find(A-1, B- (factorial * (factor-1)));

		
	}




	private StringBuilder answer = new StringBuilder();


	private int factorial(int no) {

		if(no ==0){
			return 0; 

		}
		int one = 1;

		for(int i = 2 ; i <= no;i++) {
			one *= i;
		}

		return one;
	}

	public String multipleByNumber(String a, int no) {
		int carry = 0;
		StringBuilder result = new StringBuilder();
		for(int i = a.length()-1; i>= 0; i--) {
			Integer x = Integer.parseInt(String.valueOf(a.charAt(i)));
			int temp = x* no + carry;

			if(temp >= 10) {
				carry = temp/10;
			}else {
				carry =0;
			}

			result.append(temp%10);
		}

		if(carry != 0) {
			result.append(carry);
		}
		return result.reverse().toString();
	}



}
