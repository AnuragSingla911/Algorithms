package algo;

public class eggandfloor {

	public static void main(String[] args) {
		
		eggandfloor obj = new eggandfloor();
		
		int h=obj.attemptsDP(10, 2);
		System.out.println(h);
		
	}
	
	int attemptsDP(int floors, int eggs) {
		int[][] dp = new int[floors][eggs];
		
		for(int i=0;i< eggs;i++) {
			dp[0][i] = 1;
		}
		
		for(int i=0;i < floors; i++) {
			dp[i][0] = floors;
		}
		
		for(int i=1;i < floors; i++) {
			for(int j=1;j < eggs; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				
			
				for(int x = 0; x < j ; x++) {
					int max = 1+ Math.max(x-2>= 0 ? dp[x-2][eggs-2] : 0, dp[floors-x-1][eggs-1]);
					if(max < dp[i][j]) {
						dp[i][j] = max;
					}
				}
				
			}
		}
		
		return dp[floors-1][eggs-1];
	}
	
	
	int attempts(int floors,int egg) {
		
		System.out.println(floors + " "+ egg);
		
		if(floors==0||floors==1) {
			return floors;
		}
		
		
			
		if(egg==1) {
			return floors;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 1 ; i< floors ; i++) {
			int max = 1+ Math.max(attempts(i-1, egg-1), attempts( floors-i, egg));
			if(max < min) {
				min = max;
			}
		}
		
		return min;
	}
}
