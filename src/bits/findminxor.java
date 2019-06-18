package bits;

import java.util.Arrays;

public class findminxor {
	
	public static void main(String[] args) {
		findminxor obj = new findminxor();
		int[] arr = new int[] {15, 5, 1, 10, 2};
		System.out.println(obj.findMinXor(arr));
	}

	
public int findMinXor(int[] A) {
        
        Arrays.sort(A);
        
        int min = Integer.MAX_VALUE;
        
        
        int no = 0;
        
        for(int i =0;i < A.length-1 ; i++){
            int cuno = A[i];
            int nextno = A[i+1];
            
          
                    int xor = cuno ^ nextno;
                    System.out.println(xor + " "+ cuno + " "+ nextno);
                    if(xor < min){
                        min = xor;
                    }

        }
        
        return min;
    }
}
