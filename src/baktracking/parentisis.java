package baktracking;

import java.util.ArrayList;

import algo.Utilities;

public class parentisis {

	public static void main(String[] args) {
		Utilities.printArrayList(new parentisis().generateParenthesis(3));
	}

	public ArrayList<String> generateParenthesis(int A) {


		int totalRemaiinnig = A;

		int currentTotalOpen = 0;

		find(totalRemaiinnig, currentTotalOpen, "");

		return result;
	}

	ArrayList<String> result = new ArrayList<>();
	private void find(int totalRemain, int currentTotalOpen, String current) {

		if(totalRemain == 0) {
			for(int i =0; i< currentTotalOpen ; i++) {
				current+= ")";
				
			}
			result.add(current);
		}else {
			String open = current + "(";
			find(totalRemain-1, currentTotalOpen+1, open);
			if(currentTotalOpen > 0) {
				String close = current + ")";
				find(totalRemain, currentTotalOpen-1, close);
			}
		}

	}
}
