package algo;

import java.util.ArrayList;

public class maxSpecialProduct {
	
	public maxSpecialProduct() {
		
	}

	
	public static void main(String[] args) {
		
		int x = 1000000007;
		
		System.out.println(x);
		
		maxSpecialProduct p = new maxSpecialProduct();
		ArrayList<Integer> A = new ArrayList<>();
		
		for(int i = 0; i< 99997 ; i++) {
			A.add(100000);
		}
		
		A.add(100000000);
		A.add(1000);
		A.add(100000000);
		
		long l = 99997l*99999l;
		System.out.println("start" + Long.valueOf(l));
		
		System.out.println(p.maxSpecialProduct(A));
		
	}
	
	
	 public long maxSpecialProduct(ArrayList<Integer> A) {
		  
		 int[] leftProd = new int[A.size()];
		 leftProd[0] =0;
		 
		 for(int i = 1 ; i < A.size() ; i++) {
			 
			 if(A.get(i) < A.get(i-1)) {
				 leftProd[i] = i-1;
			 }else {
				 boolean isFound = false;
				 int j = i-1;
				 while(j > 0) {
					 if(A.get(leftProd[j]) > A.get(i)) {
						 isFound = true;
						 leftProd[i] = leftProd[j];
						 break;
					 }
					 j = leftProd[j];
				 }
				 if(!isFound) {
				     leftProd[i] = 0;
				 }
			 }
		 }
		 
		 
		 int[] rightProd = new int[A.size()];
		 
		 rightProd[A.size()-1] = 0;
		 
		for(int i = A.size()-2 ; i >= 0 ; i--) {
			 
			 if(i-1 >= 0 && A.get(i) < A.get(i+1)) {
				 rightProd[i] = i+1;
			 }else {
				 boolean isFound = false;
				 int j = i+1;
				 while(j < A.size()) {
					 if(A.get(rightProd[j]) > A.get(i)) {
						 isFound = true;
						 rightProd[i] = rightProd[j];
						 break;
					 }
					 if(rightProd[j] > 0) {
						 j = rightProd[j];
					 }else {
						 rightProd[i] = 0;
						 break;
					 }
				 }
				 if(!isFound) {
				     rightProd[i] = 0;
				 }
			 }
		 }
		
		long product = 0;
		for(int i =0; i < A.size(); i++) {
			
			long tempProd = (long)leftProd[i] * (long)rightProd[i];
			
			if(tempProd > product) {
				product = tempProd;
			}
		}
		 
		 
		 
		 
		 
		 return product;
		 
		 
		 
		 
	    }
	 
	
	 
	 
		 
		 
	 
}
