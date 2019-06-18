package string;

public class comaopreVersions {
	
	

	public static void main(String[] args) {
		System.out.println(new comaopreVersions().compareVersion("13.01", "13.001"));
	}
	
	  public int compareVersion(String A, String B) {
	        
		  String first = "";
		  String second = "";
		  
		  int x = 0;
		  int y = 0;
		  while(x < A.length() || y < B.length()) {
			  
			  while(x < A.length() && A.charAt(x) != '.') {
				  first+= ""+ A.charAt(x);
				  x++;
			  }
			  
			  while(y < B.length() && B.charAt(y) != '.') {
				  second+= ""+ B.charAt(y);
				  y++;
			  }
			  
			  int no = compareStrings(first, second);
			  
			  if(no == 1) {
				  return 1;
			  }else if(no == -1) {
				  return -1;
			  }else {
				  x++;
				  y++;
				  first = "";
				  second = "";
			  }
			  
			  
		  }
		  
		  return 0;
	        
	    }
	  
	  	int compareStrings(String x,String y){
	  		
	  		 int index = 0;
             for(int i=0;i < x.length();i++){
                 if(x.charAt(i)=='0'){
                     index++;
                 }else{
                     break;
                 }
             }
             x = x.substring(index);
             
               index = 0;
             for(int i=0;i < y.length();i++){
                 if(y.charAt(i)=='0'){
                     index++;
                 }else{
                     break;
                 }
             }
             y = y.substring(index);
	  		if(x.length() > y.length()) {
	  			return 1;
	  		}else if(x.length() < y.length()) {
	  			return -1;
	  		}else {
	  			for(int i =0 ; i < x.length() ; i++) {
	  				if(x.charAt(i) > y.charAt(i)) {
	  					return 1;
	  				}else if(x.charAt(i) < y.charAt(i)) {
	  					return -1;
	  				}
	  			}
	  			return 0;
	  		}
	  	}
}
