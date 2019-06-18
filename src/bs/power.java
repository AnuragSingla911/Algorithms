package bs;

public class power {
	
	public static void main(String[] args) {
		System.out.println(new power().power(71045970, 41535484));
		System.out.println(Math.pow(71045970, 41535484));
		System.out.println(71045970L*71045970L );
	}
	
	long power(long x,long y) {
		
		
		if(y == 0) {
			return 1;
		}
		
		if(y == 1) {
			return x;
		}
		if(y % 2 == 0) {
			long x1 = power(x, y/2);
			System.out.println(x1);
			return x1* x1;
		}else {
			long x1 = power(x,y/2);
			System.out.println(x1);
			return x1*x1*x;
		}
	}

}
