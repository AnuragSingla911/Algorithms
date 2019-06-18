package bs;

public class painters {

	public static void main(String[] args) {
		painters obj = new painters();
		int[] x = new int[] {1,8,2,9,3,7};
		System.out.println(obj.paint(3, 5, x));
	}
	
	 public int paint(int A, int B, int[] C) {
	        long total = 0, max = Long.MIN_VALUE;
	        for(Integer c : C){
	            total += c;
	            max = Math.max(max,c);
	        }
	        long l = 0, h = total;
	        System.out.println(total);
	        while(l<h){
	            long mid = (l + (h-l)/2);
	            System.out.println(l + " "+ h + " "+mid);
	            long reqPainters = getRequiredPainters(C,mid);
	            System.out.println(" x "+ reqPainters);
	            if(reqPainters <= A) h = mid;
	            else l = mid + 1;
	        }
	        long ans = ((l%10000003)*(B%10000003))%10000003;
	        return (int)ans;
	    }
	    public long getRequiredPainters(int[] A , long k){
	        long total = 0, reqPainters = 1;
	        for(Integer a : A){
	            total += a;
	            if(total > k){
	                total = a;
	                reqPainters++;
	            }
	        }
	        return reqPainters;
	    }
}
