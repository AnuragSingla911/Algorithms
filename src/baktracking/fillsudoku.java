package baktracking;

import java.util.ArrayList;
import java.util.HashMap;

import algo.Utilities;


public class fillsudoku {

	public static void main(String[] args) {

		ArrayList<ArrayList<Character>> list = Utilities.toList(new Character[][] {
			{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		});
		Utilities.print2DArrayList(list);
		new fillsudoku().solveSudoku(list);
		Utilities.print2DArrayList(list);
	}

	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		
		HashMap<Character, ArrayList<Pointer>> map = fillMap(a);
		solve(a, map,0,0);
		
	}
	
	private HashMap<Character, ArrayList<Pointer>> fillMap(ArrayList<ArrayList<Character>> a) {
		HashMap<Character, ArrayList<Pointer>> map = new HashMap<>();
		for(int i =0; i< a.size(); i++) {
			for(int j =0; j< a.get(i).size() ; j++) {
				Character c = a.get(i).get(j);
				
				if(c != '.') {
					if(!map.containsKey(c)) {
						map.put(c, new ArrayList<Pointer>());
					}	
					
					ArrayList<Pointer> list = map.get(c);
					Pointer pointer = new Pointer();
					pointer.x = i;
					pointer.y = j;
					list.add(pointer);
				}	
				
			}
		}
		return map;
	}
	
	
	
	
	private boolean solve(ArrayList<ArrayList<Character>> a,HashMap<Character, ArrayList<Pointer>> map, int row, int col) {
		for(int i =0; i< a.size(); i++) {
			for(int j = 0; j< a.get(i).size() ; j++) {
				
				Character c = a.get(i).get(j);
				char filled = '1';
				while(a.get(i).get(j) == '.') {
					HashMap<Character, ArrayList<Pointer>> maptwo = new HashMap<>(map);
					
					filled = tryFill(a, i, j, maptwo, (char) (filled));
					if(filled == '.') {
						//System.out.println("srart returning i = "+ i + " j = "+ j);
						return false;
					}else {
						ArrayList<Pointer> pointer = maptwo.get(filled);
						if(pointer == null) {
							pointer = new ArrayList<>();
							map.put(filled, pointer);
						}
						Pointer point  = new Pointer();
						point.x = i;
						point.y = j;
						
						pointer.add(point);
						
						a.get(i).set(j, filled);
						//System.out.println(" i= "+ i + " j= "+ j + " filled "+ filled);
						if(i==8&&j==6) {
							//Utilities.print2DArrayList(a);
						}
						boolean solved = solve(a, maptwo, i,j);
						if(!solved) {
							a.get(i).set(j, '.');
							if(map.get(filled) != null) {
								Pointer p = null;
							for(Pointer points : maptwo.get(filled)) {
								if(points.x == i && points.y == j) {
									p = points;
									break;
								}
							}
							if(p != null)
							map.get(filled).remove(p);
							}
							filled++;
						}else {
							//System.out.println(" i= "+ i + " j= "+ j + " c "+ c);
						}
					}
					
				}
			}
		}
		return true;
	}
	
	
	class Pointer {
		int x;
		int y;
	}

		private char tryFill(ArrayList<ArrayList<Character>> a, int i, int j,HashMap<Character, ArrayList<Pointer>> map, char c) {
			

			while(c <= '9') {


				

				ArrayList<Pointer> pointer = map.get(c);
				
				boolean isFound = false;

				

				for(Pointer point : pointer) {

//					System.out.÷println(c + " " + point.x + " "+ point.y);
					if(point.x == i) {
						isFound = true; break;
					}else if(point.y == j) {
						isFound = true; break;
					}else if(getBox(point.x, point.y) == getBox(i, j)){
						isFound = true; break;
					}

				}

				
				if(!isFound) {
					
					
					return c;
				}
				
				c++;


			}
			return '.';
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
}
