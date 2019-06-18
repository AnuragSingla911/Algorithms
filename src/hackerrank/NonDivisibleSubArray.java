package hackerrank;

public class NonDivisibleSubArray {
	public static void main(String[] args) {
		
	}
	
	static int nonDivisibleSubset(int k, int[] S) {

        for(int i = 0; i < S.length ; i++){
            int[] input = new int[S.length];
            
            
            
        }

    }
	
	private void rec(int[] S, int startindex, int endindex, int k) {
		
		for(int i = endindex; i < S.length ; i++) {
			if(canBeAdded(S, startindex, i, k)) {
				
			}
		}
	}
	
	private boolean canBeAdded(int[] S, int startindex, int endindex, int k) {
		int element = S[endindex+1];
		
		for(int i = startindex ; i<= endindex; i++) {
			if((S[i] + element) % k == 0) {
				return false;
			}
		}
		
		return true;
		
	}
}
