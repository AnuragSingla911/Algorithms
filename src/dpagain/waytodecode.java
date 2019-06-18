package dpagain;

import java.util.HashMap;

public class waytodecode {
	
	public static void main(String[] args) {
		System.out.println(new waytodecode().numDecodings("0799733"));
	}

	public int numDecodings(String A) {

		if (A.length() == 1 && A.charAt(0) == '0') {
			return 0;
		}
		for (int i = A.length() - 1; i > 0; i--) {
			if (A.charAt(i) == '0' && (A.charAt(i - 1) > '2' || A.charAt(i - 1) < '1')) {
				return 0;
			}
		}
		
		
		
		int[] dp = new int[A.length()+2];
		dp[A.length()+1] = 1;
		dp[A.length()] = 1;
		
		
		for(int i = A.length()-1; i>= 0; i--) {
			char c = A.charAt(i);

			int wayFirst = dp[i+1];

			if (c > '0' && c < '3' && i < A.length() - 1) {
				char c1 = A.charAt(i + 1);
				if (c1 < '7' && c1 > '0') {
					wayFirst += dp[i+2];
				}
			}
			dp[i] = wayFirst;
		}
		return dp[0];
	}

	public int numDecodings0(String A) {

		if (A.length() == 1 && A.charAt(0) == '0') {
			return 0;
		}
		for (int i = A.length() - 1; i > 0; i--) {
			if (A.charAt(i) == '0' && (A.charAt(i - 1) > '2' || A.charAt(i - 1) < '1')) {
				return 0;
			}
		}
		return find(A, 0);
	}

	HashMap<Integer, Integer> mem = new HashMap<>();

	private int find(String current, int offset) {

		if (current == null || current.length() < 1) {
			return 0;
		}

		if (mem.containsKey(offset)) {
			return mem.get(offset);
		}

		if (offset > current.length() - 1) {
			return 1;
		}

		char c = current.charAt(offset);

		int wayFirst = find(current, offset + 1);

		if (c < '3' && offset < current.length() - 1) {
			char c1 = current.charAt(offset + 1);
			if (c1 < '7' && c1 > '0') {
				wayFirst += find(current, offset + 2);
			}
		}
		mem.put(offset, wayFirst);
		return wayFirst;

	}
}
