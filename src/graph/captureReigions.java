package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class captureReigions {

	public static void main(String[] args) {
		ArrayList<String> list1 = algo.Utilities.toList(new String[] {
				"O",
				
		});

		ArrayList<ArrayList<Character>> list = new ArrayList<>();

		for(String s : list1) {
			ArrayList<Character> c = new ArrayList<Character>();
			for(int i =0; i < s.length() ; i++) {
				c.add(s.charAt(i));
			}
			list.add(c);

		}

		new captureReigions().solve(list);
		System.out.println();
		algo.Utilities.print2DArrayList(list);
		System.out.println("end");
	}





	public void solve(ArrayList<ArrayList<Character>> a) {


		for(int i = 0; i< a.size(); i++) {
			char c = a.get(i).get(0);
			if(c == 'O') {	                	 	
				searchSorroundings(a, i, 0);
			}
		}
		
		for(int i = 0; i< a.get(0).size(); i++) {
			char c = a.get(0).get(i);
			if(c == 'O') {	                	 	
				searchSorroundings(a, 0, i);
			}
		}
		
		for(int i = 0; i< a.get(a.size()-1).size(); i++) {
			char c = a.get(a.size()-1).get(i);
			if(c == 'O') {	                	 	
				searchSorroundings(a, a.size()-1, i);
			}
		}
		
		for(int i = 0; i< a.get(0).size(); i++) {
			char c = a.get(i).get(a.get(a.size()-1).size()-1);
			if(c == 'O') {	                	 	
				searchSorroundings(a,i, a.get(a.size()-1).size()-1);
			}
		}
		algo.Utilities.print2DArrayList(a);
		for(int i =0; i< a.size() ; i++) {
			for(int j =0; j < a.get(i).size() ; j++) {
				if(a.get(i).get(j) == 'O') {
					a.get(i).set(j, 'X');
				}
			}
		}
		
		for(int i =0; i< a.size() ; i++) {
			for(int j =0; j < a.get(i).size() ; j++) {
				if(a.get(i).get(j) == 'B') {
					a.get(i).set(j, 'O');
				}
			}
		}
	}



	private void searchSorroundings(ArrayList<ArrayList<Character>> a, int x,int y) {
		System.out.println(x + " "+ y);
		ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();
		for(int i =0; i< a.size() ; i++) {
			ArrayList<Boolean> list =  new ArrayList<Boolean>();
			for(int j =0; j< a.get(i).size() ; j++) {
				list.add(false);
			}
			visited.add(list);
		}

		Queue<Integer> xQueue = new LinkedList<Integer>(); 
		xQueue.add(x);
		Queue<Integer> yQueue = new LinkedList<Integer>(); 
		yQueue.add(y);

		visited.get(x).set(y, true);

		while(!xQueue.isEmpty()) {


			int x0 = xQueue.poll();
			int y0 = yQueue.poll();
			System.out.println(x0 + " "+ y0);
			a.get(x0).set(y0, 'B');


			
			if(x0 > 1 && a.get(x0-1).get(y0) == 'O' && !visited.get(x0-1).get(y0)) {
				visited.get(x0-1).set(y0, true);
				xQueue.add(x0-1);
				yQueue.add(y0);
			}

			if(y0 > 1 && a.get(x0).get(y0-1) == 'O' && !visited.get(x0).get(y0-1)) {
				visited.get(x0).set(y0-1, true);
				xQueue.add(x0);
				yQueue.add(y0-1);
			}

			if(x0 < a.size()-2 && a.get(x0+1).get(y0) == 'O' && !visited.get(x0+1).get(y0)) {
				visited.get(x0+1).set(y0, true);
				xQueue.add(x0+1);
				yQueue.add(y0);
			}

			if(y0 < a.get(x0).size()-2 && a.get(x0).get(y0+1) == 'O' && !visited.get(x0).get(y0+1)) {
				visited.get(x0).set(y0+1, true);
				xQueue.add(x0);
				yQueue.add(y0+1);
			}


		}
	}
}
