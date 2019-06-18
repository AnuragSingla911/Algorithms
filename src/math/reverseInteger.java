package math;

public class reverseInteger {
	
	public static void main(String[] args) {
		reverseInteger obj = new reverseInteger();
		System.out.println(obj.reverse(122));
	}
	
	int reverse(int number) {
		
		int length = 0;
		int temp = number;
		while(temp > 0) {
			length++;
			temp = temp/10;
		}
		
		int result = 0;
	    while(number > 0) {
	    		int reminder = number % 10;
	    		result+= reminder * Math.pow(10, --length);
	    		number = number/10;
	    }
	    return result;
	}

}
