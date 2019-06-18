package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class validSudoku {

	public static void main(String[] args) {
		String[] arr = new String[] {
				"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"
		};
		
						
		System.out.println(new validSudoku().isValidSudoku(arr));
	}
	
	private int getBox(int x,int y) {
		if(x <= 2 ) {
			if(y <= 2) {
				return 1;
			}else if(y <= 5) {
				return 4;
			}else {
				return 7;
			}
		}else if(x <= 5) {
			if(y <= 2) {
				return 2;
			}else if(y <= 5) {
				return 5;
			}else {
				return 8;
			}
			
		}else {
			if(y <= 2) {
				return 3;
			}else if(y <= 5) {
				return 6;
			}else {
				return 9;
			}
		}
	}
	
	public int isValidSudoku(final String[] A) {
		
		HashMap<Character, ArrayList<Pointer>> map = new HashMap<>();
		
		for(int i =0; i< A.length ; i++) {
			for(int j =0; j < A.length ; j++) {
				char c = A[i].charAt(j);
				
				if(c == '.') {
					continue;
				}
				
				if(map.containsKey(c)) {
					ArrayList<Pointer> pointer = map.get(c);
					
					
					for(Pointer point : pointer) {
						
						if(point.x == i) {
							return 0;
						}else if(point.y == j) {
							return 0;
						}else if(getBox(point.x, point.y) == getBox(i, j)){
							return 0;
						}
						
					}
					
					Pointer point  = new Pointer();
					point.x = i;
					point.y = j;
					
					pointer.add(point);
					
					
					
				}else {
					Pointer pointer  = new Pointer();
					pointer.x = i;
					pointer.y = j;
					ArrayList<Pointer> p = new ArrayList<>();
					p.add(pointer);
					map.put(c, p);
				}
			}
		}
		
		return 1;
		
		
    }
	
	class Pointer {
		int x;
		int y;
		
	}
}
