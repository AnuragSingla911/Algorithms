package dpagain;

import java.util.ArrayList;
import java.util.Collections;

import algo.Utilities;

public class averageknaosack {

	public static void main(String[] args) {
		ArrayList<Integer> A = Utilities.toList(new Integer[] {19, 5, 38, 22, 44, 12, 17, 35});
		Utilities.print2DArrayList(new averageknaosack().avgset(A));
	}

	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {

		int sum = 0;
		int count = 0;

		for (int k : A) {
			sum += k;
			count++;
		}

		int average = sum / count;

		int[] arr = new int[A.size()];
		arr[arr.length - 1] = A.get(A.size() - 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i] = arr[i + 1] + A.get(i);
		}

		int left = -1;
		int length = Integer.MAX_VALUE;

		ArrayList<Integer> leftA = new ArrayList<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			int no = A.get(i);
			if (no == average && (length > 1 || (length == 1 && left > i))) {
				left = i;
				length = 1;
				leftA.clear();
				leftA.add(left);
			}
			for (int j = i + 1; j < arr.length; j++) {
				int av = (no + arr[j] * (arr.length - j)) / (arr.length - j + 1);
				if (av == average && (length > (arr.length - j + 1) || (length == (arr.length - j + 1) && left > i))) {
					left = i;
					length = arr.length - j + 1;
					leftA.clear();
					leftA.add(left);
					for (int k = j; k < A.size(); k++) {
						leftA.add(k);
					}
				}
			}
		}
		if (leftA.size() > 0) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			
			ArrayList<Integer> rightA = new ArrayList<Integer>();
			ArrayList<Integer> lefftA = new ArrayList<Integer>();
			
			result.add(lefftA);
			result.add(rightA);
			
			for(int i =0; i< A.size() ; i++) {
				if(leftA.contains(i)) {
					lefftA.add(A.get(i));
				}else {
					rightA.add(A.get(i));
				}
				
			}
			return result;
		}

		return new ArrayList<>();

	}

}
