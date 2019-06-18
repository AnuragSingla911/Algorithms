package math;

import java.util.ArrayList;

public class rearrangeArr {

	public static void main(String[] args) {
		
	}
	
	public void arrange(ArrayList<Integer> a) {
        for(int i =0; i< a.size(); i++) {
        		int no = a.get(i) % a.size();
        		int index = a.get(no) % a.size();
        		
        		a.set(i, no + (index * a.size()));
        }
        
        for(int i =0; i< a.size() ; i++) {
        		a.set(i, a.get(i)/a.size());
        }
    }
}
