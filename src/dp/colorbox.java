package dp;

import java.util.HashMap;

public class colorbox {

	int[] color = new int[] {1,2,3,4};
	
	public static void main(String[] args) {
		System.out.println(new colorbox().solve(87));
	}
	
	public int solve(int A) {
		
		int[][] fill = new int[A][3];
		
		return (int)(fillCol(fill, 0, 0));
    }
	
	private HashMap<String,Long> mem = new HashMap<>();
	
	private long fillCol(int[][] fill,int index, int row) {
		String key = "start";
		if(index > 0 && row==0) {
		key = fill[index-1][0] + " "+ fill[index-1][1] + " "+ fill[index-1][2] + " "+ index + " "+ row;
		
		}
		if(mem.containsKey(key)) {
			return mem.get(key);
		}
		
		long count = 0;
		for(int i =0; i< color.length ; i++) {
			if(isValidColor(fill, index, row, color[i])) {
				fill[index][row] = color[i];
				if(row < 2) {
					count+= fillCol(fill, index, row+1);
				}else if(index < fill.length-1){
					count+= fillCol(fill, index+1, 0);
				}else {
					count+=1;
				}
				fill[index][row] = 0;
			}
		}
		if(!"start".equalsIgnoreCase(key)) {
			mem.put(key, count);
		}
		
		return count%1000000007L;
	}
	
	
	private boolean isValidColor(int[][] fill, int i,int j, int color) {
		if(j > 0 && fill[i][j-1] == color) {
			return false;
		}
		
		if(i > 0 && fill[i-1][j] == color) {
			return false;
		}
		
		if(j < fill[0].length-1 && fill[i][j+1] == color) {
			return false;
		}
		
		if(i < fill.length-1 && fill[i+1][j] == color) {
			return false;
		}
		
		return true;
	}
}
