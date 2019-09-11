package geekforgeek;

public class joseph {
	
		
		public static void main(String[] args) {
			joseph obj = new joseph();
			System.out.println(obj.josephus(5, 3)+1);
		}
		
	   public int josephus(int n, int k)
	    {
	        boolean[] arr = new boolean[n];
	        
	        int count = n;
	        int counter = 0;
	        while( count > 1){
	            int x = 0;
	            
	            while(x < k){
	                if(arr[counter]){
	                    counter++;
	                    if(counter == n){
	                        counter=0;
	                    }
	                }else{
	                    x++;
	                    if(x == k){
	                        arr[counter] = true;
	                        break;
	                    }
	                    counter++;
	                    if(counter == n){
	                        counter=0;
	                    }
	                }
	            }
	            
	            count--;
	            
	            
	        }
	        
	        for(int i =0; i < n;i++) {
	        		if(!arr[i]) {
	        			return i+1;
	        		}
	        }
	        return -1;
	    }
	
}
