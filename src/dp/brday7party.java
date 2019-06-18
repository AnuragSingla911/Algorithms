package dp;

import java.util.HashMap;
import java.util.List;

import algo.Utilities;

public class brday7party {
	public static void main(String[] args) {
		List<Integer> l = Utilities.toList(new Integer[] {
				37, 913, 795, 973, 515, 129, 317, 882, 562, 186, 444, 223, 667, 269, 678, 260, 327
		});
		List<Integer> m = Utilities.toList(new Integer[] {
				1, 245, 16, 15, 38, 915, 221, 745, 55
		});
		List<Integer> n = Utilities.toList(new Integer[] {
				860, 952, 687, 787, 390, 442, 419, 904, 134
		});
		System.out.println(new brday7party().solve(l, m, n));
	}

	public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {




		int totalCost = 0;
		for(int i : A) {
			//  System.out.println("looking for "+ i);
			long k =  knapSack(i, C, B, B.size());
			//System.out.println("totslcost is "+ k);
			// System.out.println();
			totalCost+= k;
		}

		return totalCost;


	}


	private static long max = Integer.MAX_VALUE;


	private static HashMap<String, Long> map = new HashMap<>();



	static long knapSack(int totalRequired, List<Integer> cost, List<Integer> fill, int n) 
	{ 
		

		if(totalRequired <= 0) {
			return 0L;
		}

		String key = totalRequired + " "+ n;
		long first = 0;
		if(totalRequired >= fill.get(n-1) && n-1 == 0) {
			first =  cost.get(n-1) + knapSack(totalRequired- fill.get(n-1), cost, fill, n);
		}else if(n-1 == 0) {
			return max; 
		}else if(map.containsKey(key)) {
			return map.get(key);
		}
		else  if (fill.get(n-1) > totalRequired) {

			return knapSack(totalRequired, cost, fill, n-1); 
		}else if(totalRequired - fill.get(n-1) >= fill.get(n-1)) {
				//System.out.println("nested required");
				long first0 = cost.get(n-1) + knapSack(totalRequired- fill.get(n-1), cost, fill, n);
				long second0 =  cost.get(n-1) + knapSack(totalRequired - fill.get(n-1), cost, fill, n-1);

				//System.out.println(" first0 : "+ first0 + " second0 : "+ second0);

				first = Math.min(first0,second0);
			}else {
				first = cost.get(n-1) + knapSack(totalRequired- fill.get(n-1), cost, fill, n-1);
			}


		long second =  n-1 > 0 ? knapSack(totalRequired, cost, fill, n-1) : max;
		map.put(key, Math.min(first,second));
				//System.out.println(" first : "+ first + " second : "+ second);

		return Math.min(first,second);
	}
}
