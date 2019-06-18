package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nextPermu {
	
	public static void main(String[] args) {
		nextPermu obj=new nextPermu();
		ArrayList<Integer> a=Utilities.toList(new Integer[] {1,3,2});
		obj.nextPermutation(a);
		Utilities.printArrayList(a);
	}
	
	  public void nextPermutation(ArrayList<Integer> a) {
		  
		  
		 int index = -1;
		 
		 for(int j=a.size()-1;j>0;j--) {
			 if(a.get(j)>a.get(j-1)) {
				 index=j;
				 break;
			 }
		 }
		 
		 if(index==-1) {
			 Collections.sort(a);
		 }else {
			 int no =a.get(index-1);
			 int current = index;
			 for(int i=index+1;i<a.size();i++) {
				 if(a.get(i)>no&&a.get(i)<a.get(current)) {
					 current=i;
					 break;
				 }
			 }
			 int temp=a.get(current);
			 a.set(current, no);
			 a.set(index-1, temp);
			 
			 
			 List<Integer> sublist = a.subList(index, a.size());
			 
			 
			 
			 Collections.sort(sublist);
			 
			 
		 }
	    }

}
