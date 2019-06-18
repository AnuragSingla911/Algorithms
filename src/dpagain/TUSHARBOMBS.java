//package dpagain;
//
//import java.util.ArrayList;
//
//import algo.Utilities;
//
//public class TUSHARBOMBS {
//
//	public static void main(String[] args) {
//		ArrayList<Integer> list = Utilities.toList(new Integer[] { 8, 8, 6, 5, 4 });
//		// System.÷out.println(new TUSHARBOMBS().solve(12, list));
//		Utilities.printArrayList(new TUSHARBOMBS().solve(10, list));
//	}
//
//	private ArrayList<Integer> solve(int A, ArrayList<Integer> list) {
//
//		int[][] dp = new int[list.size() + 1][A + 1];
//
//		for (int i = list.size() - 1; i >= 0; i--) {
//			for (int j = 1; j <= A; j++) {
//				int result = 0;
//				for (int k = list.size() - 1; k >= i; k--) {
//
//					if (list.get(k) <= j) {
//						int temp = 1;
//
//						temp += dp[k + 1][j - list.get(k)];
//
//						if (temp > result) {
//							result = temp;
//						}
//
//						temp = 1;
//						if (j - list.get(k) >= list.get(k)) {
//							temp += dp[k][j - list.get(k)];
//							if (temp > result) {
//								result = temp;
//							}
//						}
//
//					}
//				}
//				// System.out.println(index + " "+ result0.size() + " "+ result.size());
//				dp[i][j] = result;
//			}
//		}
//
//		int count = dp[0][A];
//
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		
//
//		count = dp[0][A];
//		int i = 0;
//		int j = A;
//
//		while (count > 0) {
//			int i0 = i;
//			int j0 = j;
//			int r = 0;
//			int fI = i;
//			for (int k = list.size() - 1; k >= i0; k--) {
//
//				
//					int temp1 = 1;
//					
//					temp1 += dp[k + 1][j0 - list.get(k)];
//
//					if(temp1 > r) {
//						fI = k;
//					}
//					
//						
//					
//
//					int temp2 = 1;
//					if (j0 - list.get(k) >= list.get(k)) {
//						temp2 += dp[k][j0 - list.get(k)];
//						if(temp2 < k)
//						
//					}
//
//				}
//			
//			
//			}
//		}
//
//		return result;
//	}
//
//	public ArrayList<Integer> solve0(int A, ArrayList<Integer> B) {
//
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		for (int i = 0; i < B.size(); i++) {
//			if (B.get(i) <= A) {
//				if (i == 4) {
//					// System.out.println();
//				}
//				ArrayList<Integer> temp = new ArrayList<Integer>();
//				temp.add(i);
//				find(A - B.get(i), B, i, temp);
//				// System.out.println(" finally temp size "+ temp.size() + " "+ i);
//				if (temp.size() > result.size()) {
//					result = temp;
//				}
//			}
//		}
//
//		return result;
//	}
//
//	private void find(int A, ArrayList<Integer> B, int index, ArrayList<Integer> result) {
//		// System.out.println("find "+index + " "+ result.size() + " "+ A);
//		if (index >= B.size()) {
//			return;
//		}
//		ArrayList<Integer> result0 = new ArrayList<Integer>();
//		for (int i = index; i < B.size(); i++) {
//
//			if (B.get(i) <= A) {
//				ArrayList<Integer> temp = new ArrayList<Integer>();
//				temp.add(i);
//
//				find(A - B.get(i), B, i + 1, temp);
//
//				if (temp.size() > result0.size()) {
//					result0 = temp;
//				}
//				temp = new ArrayList<Integer>();
//				temp.add(i);
//				if (A - B.get(i) >= B.get(i)) {
//					find(A - B.get(i), B, i, temp);
//				}
//
//				if (temp.size() > result0.size()) {
//					result0 = temp;
//				}
//			}
//		}
//		// System.out.println(index + " "+ result0.size() + " "+ result.size());
//		result.addAll(result0);
//
//	}
//}
