package algo;

import java.util.ArrayList;

public class rotatematrix {
	
	public static void main(String[] args) {
		rotatematrix obj= new rotatematrix();
		
		
		obj.rotate(Utilities.toList(new Integer[][] {{1,2,3},{4,5,6},{7,8,9}}));
	}
	
	public void rotate(ArrayList<ArrayList<Integer>> a) {
		
		int size=a.size();

		for(int j=0; j < size ; j++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for(int i = size-1; i >= 0 ; i--) {
				int no = a.get(i).get(j);
				row.add(no);
			}
			a.add(row);
		}
		
		for(int i=0;i < size;i++) {
			a.remove(0);
		}
		
		
	}

}
