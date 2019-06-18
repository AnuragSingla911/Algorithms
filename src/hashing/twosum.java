package hashing;

import java.util.HashMap;

import algo.Utilities;

public class twosum {
	
	public static void main(String[] args) {
		int[] arr = new int[] {
				4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8
		};
		
		new twosum().twoSum(arr, -3);
	}

public int[] twoSum(final int[] A, int B) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int start = -1;
        int end = -1;
        
        for(int i = 0; i< A.length ; i++){
            int no = B - A[i];
            
            if(map.containsKey(no)){
                int s = map.get(no);
                int e = i;
                
                if(start == -1) {
                		start = s;
                		end =e;
                }else
                if(e < end){
                    end = e;
                }else if(e == end){
                    if(s < start){
                        start =s;
                    }
                }
               
            }else{
                map.put(A[i], i);
            }
        }
        
        if(start == -1){
            return new int[]{};
        }else{
            return new int[]{start,end};
        }
    }

}
