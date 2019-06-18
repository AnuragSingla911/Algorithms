package dp;

import java.util.HashMap;

public class ndigitnumberofmsum {

	public static void main(String[] args) {
		System.out.println(new ndigitnumberofmsum().solve(75, 22));
	}

	public int solve(int A, int B) {

		

		long count = 0;
		int index = 0;
		for(int i = 1; i< 10; i++) {
			
			long sum0 =  find(A, B-i, index+1);
			int s = (int)(sum0 % 1000000007l);
			count+= s;
		}
		return (int)(count%1000000007l);

	}
	
	HashMap<String, Integer> map = new HashMap<>();

	private int find(int A, int B, int index){

		
		
		if(B < 0){
			return 0;
		}

		if(B == 0) {
			
			return 1;
		}
		
		if(index >= A) {
			return 0;
		}
		
		String key =  B + " "+ index;
		
		if(map.containsKey(key)) {
			return map.get(key);
		}

		long count = 0;

		for(int i = 0 ; i < 10 ; i++){
			
			if(index <= A-1) {
				long sum0 = find(A, B - i, index+1);
				int s = (int)(sum0 % 1000000007l);
				//System.out.println(s);
				count+= (s);
			}
			
		}
		
		int c = (int) (count % 1000000007l);
		map.put(key, c);
		return c;
	}
}
