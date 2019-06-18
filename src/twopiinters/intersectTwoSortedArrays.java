package twopiinters;

public class intersectTwoSortedArrays {

public int[] intersect(final int[] A, final int[] B) {
        
        int x = 0;
        int y = 0;
        
        int[] arr = new int[A.length > B.length ? B.length : A.length];
        int count = 0;
        while(x < A.length && y < B.length){
            if(A[x] == B[y]) {
            		arr[count++] = A[x];
            		x++;
            		y++;
            }else if(A[x] > B[y]) {
            		y++;
            }else {
            		x++;
            }
        }
        
        int[] result = new int[count];
        
        for(int i =0; i< result.length ; i++) {
        		result[i] = arr[i];
        }
        
        return result;
    }
}
