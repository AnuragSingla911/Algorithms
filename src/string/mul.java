package string;

import java.util.ArrayList;

public class mul {

	public static void main(String[] args) {
		System.out.println(new mul().multiply("0123", "0004"));
	}
	public String multiply(String A, String B) {
		
		 

		ArrayList<StringBuilder> list = new ArrayList<>();


		int k =0;

		for(int i = B.length()-1; i>= 0  ; i--) {

			String no = multipleByNumber(A, Integer.parseInt(String.valueOf(B.charAt(i))));
			StringBuilder build = new StringBuilder(no);
			for(int j = 0; j < k ; j++) {
				build.append("0");
			}

			list.add(build.reverse());
			k++;
		}

		StringBuilder result = new StringBuilder();
		int carry = 0;
		int index = 0;
		int max = Integer.MIN_VALUE;
		for(int i =0; i< list.size() ; i++) {
			int s = list.get(i).length();
			if(s > max) {
				max = s;
			}
		}

		boolean allZero = true;
		while(index < max) {
			int no = carry;
			for(int i =0; i< list.size() ; i++) {
				if(index < list.get(i).length())
				no+= Integer.parseInt(String.valueOf(list.get(i).charAt(index)));
				
			}
			carry = no/10;
			if(no%10 != 0) {
				allZero = false;
			}
			result.append(no%10);
			index++;
		}
		if(carry > 0) {
			allZero = false;
			result.append(carry);
		
		}

		if(allZero) {
			return "0";
		}
		result = result.reverse();
		int f=-1;
		for(int i =0; i< result.length() ; i++) {
			if(result.charAt(i) == '0') {
				f=i;
			}else {
				break;
			}
		}
		
		return f > 0 ? result.substring(f+1) : result.toString();

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
