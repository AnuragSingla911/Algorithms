package graph;

import java.util.LinkedList;
import java.util.Queue;

import algo.firstrepeatingnumber;

public class presentinfabonici {

	public static void main(String[] args) {
		int t=new presentinfabonici().fibsum(22);
		System.out.println(t);
	}
	
	 public int fibsum(int A) {
		 
		 int[] arr = new int[A];
		 
		 arr[0] = 1;
		 arr[1] = 1;
		 int minnorequired = -1;
		 for(int i = 2; i< arr.length ; i++) {
			 arr[i] = arr[i-1] + arr[i-2];
			 if(arr[i] % A == 0)
			 {
				 int val = arr[i] / A;
				 if(minnorequired == -1 || minnorequired > val)
				 minnorequired =  val;
			 }
		 }
		 
		 if(minnorequired> -1 && minnorequired < 3) {
			 return minnorequired;
		 }
		 
		 LinkedList<Integer> numberQueue = new LinkedList<Integer>();
		 LinkedList<Integer> countQueue = new LinkedList<Integer>();
		 int index = 1;
		 numberQueue.add(arr[index]);numberQueue.add(arr[index]+ arr[index++]);
		 countQueue.add(1); countQueue.add(2);
		 while(!numberQueue.isEmpty()) {
			
			 int size = numberQueue.size();
			// System.out.println(" index : "+ index + " size : "+ size);
			 for(int i =0; i< size; i++) {
				int no =  numberQueue.removeFirst();
				
				int count = countQueue.removeFirst();
			//	System.out.println(no + " "+ count);	
				if(no == A) {
				
					if( minnorequired==-1 || count < minnorequired) {
						minnorequired=count;
					}
					
				}
				
				if(index == arr.length) {
					break;
				}
				if(no == 2 && arr[index] == 5) {
				//	System.out.println("pakka");
				}
				numberQueue.addLast(no + arr[index]);
				countQueue.addLast(count+1);
				
				
				numberQueue.addLast(no + arr[index]+ arr[index]);
				countQueue.addLast(count+2);
				
				

			 }
			 

			 numberQueue.addLast(arr[index]);
			 if(arr[index] == 2) {
				// System.out.println("idhar");
			 }
			 
			  numberQueue.addLast(arr[index]+ arr[index]);
              countQueue.addLast(2);
             countQueue.addLast(1);
			 
			 index++;
			 if(index >= arr.length) {
					break;
				}
			 
			 
			 
		 }
		 
		 return minnorequired;
		 
		
		 
	        
	    }
	 
	 
	 
}
