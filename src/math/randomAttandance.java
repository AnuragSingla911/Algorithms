package math;

import java.util.ArrayList;
import java.util.Collections;

import algo.Utilities;

public class randomAttandance {
	
	public static void main(String[] args) {
		randomAttandance obj = new randomAttandance();
		ArrayList<Integer> list  = Utilities.toList(new Integer[] {
				
500
		});
		
		System.out.println(obj.solve(100000, list));
	}
	
	 private long poz(int n) {
	        long res = n;
	        long k = 1;
	        n /= 10;
	        while (n > 0) {
	            res += (n % 10) * k + 1;
	            System.out.println(res);
	            n /= 10;
	            k = k * 10 + 1;
	        }
	        return res;
	    }
	    
	    private long max(int n) {
	        long res = 0;
	        while (n > 0) {
	            res = res * 10 + 9;
	            n /= 10;
	        }
	        return res;
	    }
	    
	    private String find(long p, long max) {
	        // System.out.println("-> " + p + " " + max);
	        if (max < 10)
	            return "" + p;
	        
	        long groupSize = max / 9;
	        long group = p / groupSize;
	        long offset = p % groupSize;
	        if (offset == 0)
	            return "" + group;
	        else
	            return "" + group + find(offset - 1, max / 10);
	    }
	    
	    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        long pozA = poz(A);
	        System.out.println(pozA);
	        long max = max(A);
	        for (int b : B) {
	            long p = b - 1 + max / 9;
	            if (p <= pozA) {
	                res.add(Integer.parseInt(find(p, max)));
	            } else {
	                res.add(Integer.parseInt(find(p - A - 1, max / 10)));
	                // System.out.println(A+" "+b+" "+p+" "+max+" "+pozA);
	            }
	        }
	        return res;
	    }

//	 public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
//	        
//		 ArrayList<String> list = new ArrayList<String>();
//	        for(int i =1; i <= A;i++){
//	            list.add(""+i);
//	        }
//	        
//	        Collections.sort(list);
//	        
//	        ArrayList<Integer> result = new ArrayList<Integer>();
//	        
//	        for(int i =0; i < B.size(); i++){
//	            int no = B.get(i);
//	            result.add(Integer.parseInt(list.get(no-1)));
//	        }
//	        return result;
//	    }
}
