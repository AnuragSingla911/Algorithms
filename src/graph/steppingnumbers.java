package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class steppingnumbers {

	public ArrayList<Integer> stepnum(int A, int B) {


		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> dirQueue = new LinkedList<Integer>();



		for(int i = 1; i < 10 ; i++) {
			queue.add(i);
			dirQueue.add(0);
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int no = queue.poll();
			int dir = dirQueue.poll();

			if(no >= A && no <= B) {
				result.add(no);
			}

			if(dir == 0) {
				int no0 = no % 10;

				int decNo = no * 10 + (no0-1);
				if(decNo <= B) {
					queue.add(decNo);
					dirQueue.add(-1);
				}

				int incNo = no * 10 + (no0 + 1);
				if(incNo<= B) {
					queue.add(incNo);
					dirQueue.add(1);
				}
			}


			if(dir == -1) {
				int no0 = no % 10;

				int decNo = no * 10 + (no0-1);
				if(decNo <= B) {
					queue.add(decNo);
					dirQueue.add(-1);
				}
			}

			if(dir == 1) {
				int no0 = no % 10;
				int incNo = no * 10 + (no0 + 1);
				if(incNo<= B) {
					queue.add(incNo);
					dirQueue.add(1);
				}
			}
		}
		return result;


	}


}
