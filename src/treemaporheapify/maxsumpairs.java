package treemaporheapify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import algo.Utilities;

public class maxsumpairs {
	
	public static void main(String[] args) {
		ArrayList<Integer> A = Utilities.toList(new Integer[] {3,2,4,2});
		ArrayList<Integer> B = Utilities.toList(new Integer[] {4,3,1,2});
		Utilities.printArrayList(new maxsumpairs().solve(A, B));
	}
	
	class Pair {
		int x;
		int y;
		Pair(){}
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			int sum = x + (31 * y);
			int prod = (x * 31)+ y;
			return sum+prod;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Pair) {
				return ((Pair) obj).x == this.x &&((Pair) obj).y == this.y ;
			}else {
				return false;
			}
		}
		
		
	}

	  public ArrayList<Integer> solve(final ArrayList<Integer> A, final ArrayList<Integer> B) {
	        
	        Collections.sort(A);
	        Collections.sort(B);
	        
	        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
	        	
	        	 public int compare(Pair p1, Pair p2)
		            {
		                int x = A.get(p1.x)+B.get(p1.y);
		                int y = A.get(p2.x)+B.get(p2.y);
		                if(x>y)
		                    return -1;
		                else if(x==y)
		                    return 0;
		                else
		                    return 1;
		            }
			});
	        
	        int x = A.size()-1;
	        int y = B.size()-1;
	        
	        HashMap<Pair,Boolean> map = new HashMap<>();
	        Pair pair = new Pair();
	        pair.x = x;
	        pair.y = y;
	        queue.add(pair);
	        map.put(pair, true);
	        
	       
	        ArrayList<Integer> result1 = new ArrayList<Integer>();
	        int count = 0;
	        while(count < A.size()) {
	        	
	        	
	        		
	        		Pair temp = queue.poll();
	        		
	        		result1.add(A.get(temp.x) + B.get(temp.y));
	        		
	        		Pair left = new Pair();
	     	        left.x = temp.x;
	     	        left.y = temp.y-1;
	        		if(map.get(left) == null && temp.y > 0) {
	     	        queue.add(left);
	     	        map.put(left, true);
	        		}
	        		
	        		Pair right = new Pair();
	     	        right.x = temp.x-1;
	     	        right.y = temp.y;
	        		if(map.get(right) == null && temp.x > 0) {
	        			
	     	        queue.add(right);
	     	        map.put(right, true);
	        		}
	        		
	        		count++;
	        		
	        }
	        
	       
	       
	      
	        
	        
	        return result1;
	        
	       
	        
	        
	        
	  }
	  
	      public ArrayList<Integer> solve1(final ArrayList<Integer> A,final ArrayList<Integer> B) {
	        int n = A.size();
	        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(2*n, new Comparator<Pair>()
	        {
	            public int compare(Pair p1, Pair p2)
	            {
	                int x = A.get(p1.x)+B.get(p1.y);
	                int y = A.get(p2.x)+B.get(p2.y);
	                if(x>y)
	                    return -1;
	                else if(x==y)
	                    return 0;
	                else
	                    return 1;
	            }
	        });
	        Collections.sort(A);
	        Collections.sort(B);
	        ArrayList<Integer> ans = new ArrayList();
	        HashSet<Pair> hs = new HashSet();
	        int count = 0;
	        int i=n-1, j=n-1;
	        pq.offer(new Pair(i, j) );
	        hs.add(new Pair(i, j) );
	        while(count < n)
	        {
	        	Pair p = pq.poll();
	            int x = p.x;
	            int y = p.y;
	            ans.add(A.get(x)+B.get(y) );
	            if(x-1>=0)
	            {
	            	Pair p1 = new Pair(x-1, y);
	                if(!hs.contains(p1) )
	                {
	                    pq.offer(p1);
	                    hs.add(p1);
	                }
	            }
	            if(y-1>=0)
	            {
	            	Pair p2 = new Pair(x, y-1);
	                if(!hs.contains(p2) )
	                {
	                    pq.offer(p2);
	                    hs.add(p2);
	                }
	            }
	            count++;
	        }
	        //Collections.sort(ans, new Comparator<Integer>)
	        return ans;
	    }
	  
	  
	
}
