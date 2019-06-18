package dpagain;

public class counttrue {

	public static void main(String[] args) {
		System.out.println(new counttrue().cnttrue("T^T^T^F|F&F^F|T^F^T"));
	}

	public int cnttrue(String A) {
		int[][] truedp = new int[A.length()][A.length()];
		int[][] falsedp = new int[A.length()][A.length()];
		
		for (int j = 0; j < A.length(); j++) {
			for (int i = A.length()-1; i >= 0; i--) {
				if(i == j) {
					if(A.charAt(i) == 'T') {
						truedp[i][j] = 1;
					}else {
						falsedp[i][j] = 1;
					}
				}
			}
		}

		for (int j = 0; j < A.length(); j++) {
			for (int i = A.length()-1; i >= 0; i--) {

				int countTrue = 0;
				int countFalse = 0;
				for (int k = j; k >= i; k--) {
					char c = A.charAt(k);
					if (c == '|') {
						countTrue += truedp[i][k-1] * falsedp[k+1][j];
						countTrue += truedp[i][k-1] * truedp[k+1][j];
						countTrue += falsedp[i][k-1] * truedp[k+1][j];
						countFalse+= falsedp[i][k-1] * falsedp[k+1][j];
					} else if (c == '&') {
						countTrue += truedp[i][k-1] * truedp[k+1][j];
						countFalse+= truedp[i][k-1] * falsedp[k+1][j];
						countFalse+= falsedp[i][k-1] * falsedp[k+1][j];
						countFalse+= falsedp[i][k-1] * truedp[k+1][j];
					} else if (c == '^') {
						countTrue += truedp[i][k-1] * falsedp[k+1][j];
						countTrue += falsedp[i][k-1] * truedp[k+1][j];
						countFalse+= falsedp[i][k-1] * falsedp[k+1][j];
						countFalse += truedp[i][k-1] * truedp[k+1][j];
					}
				}
				
				truedp[i][j] = truedp[i][j] + countTrue % 1003;
				falsedp[i][j] = falsedp[i][j] + countFalse % 1003;
				
				
			}
		}
		return truedp[0][A.length()-1];
	}

	public int cnttrue0(String A) {
		int c = 0;

		c += findTrue(A, 0, A.length() - 1);

		return c;
	}

	private int findTrue(String A, int indexLeft, int indexRight) {

		if (indexLeft >= A.length()) {
			return 0;
		}

		if (indexLeft == indexRight) {
			if (A.charAt(indexLeft) == 'T') {
				return 1;
			} else {
				return 0;
			}
		}
		int count = 0;
		for (int i = indexLeft; i <= indexRight; i++) {
			char c = A.charAt(i);
			if (c == '|') {
				count += findTrue(A, indexLeft, i - 1) * findFalse(A, i + 1, indexRight);
				count += findTrue(A, indexLeft, i - 1) * findTrue(A, i + 1, indexRight);
				count += findFalse(A, indexLeft, i - 1) * findTrue(A, i + 1, indexRight);
			} else if (c == '&') {
				count += findTrue(A, indexLeft, i - 1) * findTrue(A, i + 1, indexRight);
			} else if (c == '^') {
				count += findTrue(A, indexLeft, i - 1) * findFalse(A, i + 1, indexRight);
				count += findFalse(A, indexLeft, i - 1) * findTrue(A, i + 1, indexRight);
			}
		}
		System.out.println("true l : " + indexLeft + " r : " + indexRight + " c : " + count);
		return count;

	}

	private int findFalse(String A, int indexLeft, int indexRight) {

		if (indexLeft >= A.length()) {
			return 0;
		}

		if (indexLeft == indexRight) {
			if (A.charAt(indexLeft) == 'T') {
				return 0;
			} else {
				return 1;
			}
		}
		int count = 0;
		for (int i = indexLeft; i <= indexRight; i++) {
			char c = A.charAt(i);
			if (c == '|') {
				count += findFalse(A, indexLeft, i - 1) * findFalse(A, i + 1, indexRight);

			} else if (c == '&') {
				count += findTrue(A, indexLeft, i - 1) * findFalse(A, i + 1, indexRight);
				count += findFalse(A, indexLeft, i - 1) * findTrue(A, i + 1, indexRight);
				count += findFalse(A, indexLeft, i - 1) * findFalse(A, i + 1, indexRight);
			} else if (c == '^') {
				count += findFalse(A, indexLeft, i - 1) * findFalse(A, i + 1, indexRight);
				count += findTrue(A, indexLeft, i - 1) * findTrue(A, i + 1, indexRight);
			}
		}
		System.out.println("false l : " + indexLeft + " r : " + indexRight + " c : " + count);
		return count;

	}

	private char solveExp(String S) {
		char c = S.charAt(0);
		for (int i = 1; i < S.length(); i = i + 2) {
			c = solve(c, S.charAt(i), S.charAt(i + 1));
		}
		return c;
	}

	private char solve(char a, char b, char operand) {
		int first = a == 'T' ? 1 : 0;
		int second = b == 'T' ? 1 : 0;
		switch (operand) {
		case '|':
			return (first | second) == 1 ? 'T' : 'F';
		case '&':
			return (first & second) == 1 ? 'T' : 'F';
		case '^':
			return (first ^ second) == 1 ? 'T' : 'F';

		}
		return 0;
	}

}
