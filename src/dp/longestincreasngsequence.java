package dp;

import java.util.List;

import algo.Utilities;

public class longestincreasngsequence {

	public static void main(String[] args) {
		List<Integer> list = Utilities.toList(new Integer[] {
				// 0, 8, 4, 12, 2, 10, 6, 14, 1, 9,
				5, 13, 3, 11, 7, 15 });

		System.out.println(new longestincreasngsequence().lis0(list));
	}
	
	public int lis(final List<Integer> A) {
		
		int size = A.size();
		
		int[] arr = new int[size];
		for(int i =0;i < arr.length ; i++) {
			arr[i] = 1;
			
		}
		
		for(int i = 1; i< A.size() ; i++) {
			for(int j=0;j < i; j++) {
				if(A.get(i) > A.get(j)) {
					if(arr[j]+1 > arr[i]) {
						arr[i] = arr[j]+1;
					}
				}
			}
		}
		
		return arr[size-1];
	}
	

	public int lis0(final List<Integer> A) {
		return findRec(A, 0, null);
	}

	private int findRec(List<Integer> A, int index, Integer val) {

		if (index >= A.size()) {
			return 0;
		}

		if (index == A.size() - 1) {
			if (val == null || A.get(index) > val) {
				return 1;
			} else {
				return 0;
			}
		}

		while (index < A.size() - 1 && val != null && A.get(index) < val) {
			index++;
		}

		int v = Math.max(1 + findRec(A, index + 1, A.get(index)), findRec(A, index + 1, val));
		return v;

	}
}
