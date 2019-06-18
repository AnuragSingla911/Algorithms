package bs;

public class sqrt {
	
	public static void main(String[] args) {
		sqrt obj = new sqrt();
		System.out.println(obj.sqrt(2147483647));
	}

public int sqrt(int a) {
	
	if(a==0 || a==1) {
		return a;
	}
        
        long low = 1;
        long high = a;
        long mid = 0;
        long ans = 0;
        while(low < high){
        mid =	(low+high)/2;

            long prod = (long)mid * (long)mid;
            if(prod == a){
                return (int)mid;
            }else if(prod < a){
                low = mid+1;
                ans = mid;
            }else{
                high = mid;

            }
        }
        
        return (int)ans;
        
    }
}
