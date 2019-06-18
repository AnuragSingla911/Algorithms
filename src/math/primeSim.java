package math;

public class primeSim {

	public static void main(String[] args) {
		
		primeSim obj = new primeSim();
		for(int i = 2; i < 50; i++) {
			System.out.println(i+ " is "+obj.isPrime(i));
		}
		
	}
	
	boolean isPrime(int no)
	{
		for(int i = 2 ; i<= Math.sqrt(no); i++){
			if(no % i == 0) {
				return false;
			}
		}
		return true;
	}
}
