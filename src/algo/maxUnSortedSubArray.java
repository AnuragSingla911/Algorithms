package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class maxUnSortedSubArray {
	
	public static void main(String[] args) {
	   
		ArrayList<ArrayList<Integer>> arr = Utilities.toList(new Integer[][] {{1},{0},{1}}); 
		maxUnSortedSubArray obj = new maxUnSortedSubArray();
		obj.setZeroes(arr);
	}
	
	class Point {
		int i;
		int j;
		
		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return i+ " "+ j;
		}
	}
	
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		
		
		
		
		
		
		
			boolean isRowZero= false;
			
			for(int i =0; i< a.get(0).size() ; i++) {
				if(a.get(0).get(i) == 0) {
					isRowZero=true;
					break;
				}
			}
			
			boolean isColumnZero=false;
				for(int i=0;i<a.size(); i++) {
					if(a.get(i).get(0) == 0) {
						isColumnZero = true;
						break;
					}
				}
			
			
		
		
			
		
			for(int i = 1; i < a.get(0).size() ; i++) {
				boolean isZeroFound = false;
				for(int j = 1; j < a.size() ; j++) {
					if(a.get(j).get(i) == 0) {
						isZeroFound = true;
						break;
					}
				}
				
				if(isZeroFound) {
					
					a.get(0).set(i, 0);
				}
			}
			
			
			for(int i = 1; i < a.size() ; i++) {
				boolean isZeroFound = false;
				for(int j = 1; j < a.get(i).size() ; j++) {
					if(a.get(i).get(j) == 0) {
						isZeroFound = true;
						break;
					}
				}
				
				if(isZeroFound) {
					a.get(i).set(0, 0);
				}
			}
			
			
			for(int i = 1; i< a.size() ; i++) {
				for(int j =1; j < a.get(i).size();j++) {
					a.get(i).set(j, a.get(0).get(j) == 1 && a.get(i).get(0) == 1 ? 1 : 0);
				}
			}
			
			
		
			
				if(isColumnZero) {
				for(int i=1;i < a.size() ; i++) {
					a.get(i).set(0, 0);	
				}
				}
				if(isRowZero) {
				for(int i =1; i< a.get(0).size() ; i++) {
					a.get(0).set(i, 0);
				}
				}
		
			
			if(isRowZero||isColumnZero) {
				a.get(0).set(0, 0);
			}
			
			
			
			
			
		
		
		
		
		
    }
	
	 public int maximumGap(final List<Integer> A) {
		 
		 ArrayList<Integer> B =  new ArrayList<Integer>();
		 
		 for(int i =0; i< A.size() ; i++) {
			 B.add(A.get(i));
		 }
		 
		 Collections.sort(B);
		 
		 int maxGap = 0;
		 
		 for(int i =0; i< A.size() ;i++) {
			 int diff = A.get(i) - B.get(i);
			 if(maxGap < diff) {
				 maxGap = diff;
			 }
		 }
		 
		 return maxGap;
		 
		 
	    }
	
	 public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
	        
	        ArrayList<Integer> B = new ArrayList<Integer>();
	        
	        for(int i=0;i< A.size() ; i++) {
	        	B.add(A.get(i));
	        }
	        
	        Collections.sort(B);
	        
	        int mismatchStart =-1;
	        for(int i=0;i<A.size() ; i++) {
	        		if(A.get(i)!= B.get(i)) {
	        			mismatchStart = i;
	        			break;
	        		}
	        }
	        
	        int mismatchEnd = -1;
	        for(int i = A.size()-1;i>=0;i--) {
	        	if(A.get(i)!= B.get(i)) {
	        		mismatchEnd = i;
	        		break;
	        	}
	        }
	        
	        ArrayList<Integer> result= new ArrayList<Integer>();
	        if(mismatchStart == -1 || mismatchEnd == -1) {
	        		result.add(-1);
	        }else {
	        		result.add(mismatchStart);
	        		result.add(mismatchEnd);
	        }
	        return result;
	    }

}
