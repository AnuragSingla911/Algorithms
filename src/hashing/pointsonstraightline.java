package hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class pointsonstraightline {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		int no = sc.nextInt();
		ArrayList<Integer> list= new ArrayList<>();
		ArrayList<Integer> list2= new ArrayList<>();
		for(int i=0;i< no;i++) {
			list.add(sc.nextInt());
			list2.add(sc.nextInt());
		}
		
		
		System.out.println(new pointsonstraightline().maxPoints(list, list2));
		
		sc.close();
		
	}
	
	 public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		 
		 HashMap<String,Integer> count = new HashMap<>();
		 
		 for(int i =0; i< a.size() ; i++) {
			 
			 if(count.containsKey("X"+a.get(i))) {
				 count.put("X"+a.get(i), count.get("X"+a.get(i)) + 1);
			 }else {
				 count.put("X"+a.get(i), 1);
			 }
		 }
		 
		 
		 for(int i =0; i< b.size() ; i++) {
			 
			 if(count.containsKey("Y"+b.get(i))) {
				 count.put("Y"+b.get(i), count.get("Y"+b.get(i)) + 1);
			 }else {
				 count.put("Y"+b.get(i), 1);
			 }
		 }
		 
		 for(int i =0; i< b.size() ; i++) {
			 
			 for(int j =0;j < b.size() ; j++) {
			 
			 if( (a.get(j)-a.get(i)) == 0 || (b.get(j)-b.get(i)==0)){
                 continue;
             }
			 
			 
			 
			 float no = (float)(b.get(j)-b.get(i))/(float)(a.get(j)-a.get(i));
					 
			 if(count.containsKey("Z"+no)) {
				 count.put("Z"+no, count.get("Z"+no) + 1);
			 }else {
				 count.put("Z"+no, 2);
			 }
			 }
		 }
		 return Collections.max(count.values());
		 
		 
	        
	        
	    }
}
