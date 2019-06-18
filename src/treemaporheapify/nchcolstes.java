package treemaporheapify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import algo.Utilities;

public class nchcolstes {

	public static void main(String[] args) {
		
		ArrayList<Integer> B = Utilities.toList(new Integer[] { 2147483647, 2000000014, 2147483647});
		System.out.println(new nchcolstes().nchoc(10, B));
		
	}
	
	 public int nchoc(int A, ArrayList<Integer> B) {
         
         PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
         
         for(Integer i : B) {
             queue.add(i);
         }
         
         long total = 0;
         
         for(int i =0; i< A; i++) {
             long x = queue.poll();
            
             total+= x;
             
            
           
             
             queue.offer((int) (x/2));
         }
         
         return (int) (total%1000000007);
            
        }
}
