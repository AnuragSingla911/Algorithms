package dp;

import java.util.Collections;
import java.util.List;

import algo.Utilities;

public class fliparrknapsack {

	public static void main(String[] args) {
		List<Integer> list = Utilities.toList(new Integer[] {5, 4, 6, 8, 7, 2, 3 });

		System.out.println(new fliparrknapsack().solve(list));
	}

	public int solve(final List<Integer> A) {
		int sum = 0;
		for (int a : A) {
			sum += a;
		}

		int medium = sum / 2;

		System.out.println("medium is : " + medium);

		int[][] noofelementsused = new int[A.size()][medium + 1];

		int[][] sumleft = new int[A.size()][medium + 1];

		for (int i = 0; i < A.size(); i++) {

			for (int j = 0; j < noofelementsused[i].length; j++) {
				sumleft[i][j] = medium;
			}
		}

		for (int i = 0; i < A.size(); i++) {
			noofelementsused[i][0] = 0;
		}

		Collections.sort(A, Collections.reverseOrder());

		for (int i = 0; i < A.size(); i++) {

			for (int j = 0; j < noofelementsused[i].length; j++) {

				if (i == 0) {
					if (medium - A.get(i) >= 0) {
						noofelementsused[i][j] = 1;
						sumleft[i][j] = sumleft[i][j] - A.get(i);
					}
				} else {

					if (j > A.get(i)) {
						int first =  sumleft[i - 1][j - A.get(i)] - A.get(i);
						int second = sumleft[i-1][j];
						
						if(first >= 0 && first < second) {
							noofelementsused[i][j] = noofelementsused[i][j-A.get(i)] + 1;
							sumleft[i][j] = first;
						}else {
							noofelementsused[i][j] = noofelementsused[i-1][j];
							sumleft[i][j] = sumleft[i-1][j];
						}
					} else {
						noofelementsused[i][j] = noofelementsused[i - 1][j];
						sumleft[i][j] = sumleft[i-1][j];
					}
				}
			}
		}

		return noofelementsused[A.size() - 1][medium];

	}
}
