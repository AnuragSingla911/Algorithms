package twopiinters;

import java.util.Arrays;

public class targetthressum {

	public static void main(String[] args) {

		targetthressum obj = new targetthressum();
		int[] arr = new int[] {
				-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3

		};
		System.out.println(obj.threeSumClosest(arr, -1));

	}


	public int threeSumClosest(int[] A, int B) {

		if(A.length < 2){
			return 1000000000;
		}
		Arrays.sort(A);

		
		long resultSum =0;
		long diffSum=Integer.MAX_VALUE;
		for(int i=0;i < A.length-2;i++) {
			if(i== 25) {
				System.out.println();
			}
			int x =i;
			int y =i+1;
			int z = A.length-1;
			
			
			while(y < z) {
				long sum = (long)A[x]+ (long)A[y]+ (long)A[z];
				if(Math.abs(sum - B) < diffSum) {
					diffSum = Math.abs(sum-B);
					resultSum = sum;
				}
				if(sum > B) {
					z--;
				}else {
					y++;
				}
			}
		}
		
		





		return resultSum >= Integer.MIN_VALUE && resultSum <= Integer.MAX_VALUE ? 
				(int)resultSum : 1000000000;


	}


}
