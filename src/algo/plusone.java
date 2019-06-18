package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class plusone {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 9, 9));
		
		plusone obj = new plusone();
		
		obj.plusOne(list);
		
		for(int i =0;i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}
	
		public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        
        int index = A.size()-1;
        while(true){
            
            if(index == -1){
                A.add(0,1);
                break;
            }
            int digit = A.get(index);
            if(digit == 9){
                A.set(index, 0);
                index--;
            }
            else{
                A.set(index, ++digit);
                break;
            }
        }
        
        int i = 0;
        while(true){
            int digit = A.get(i);
            if(digit == 0){
                A.remove(i);
            }else {
            		break;
            }
            
        }
        
        return A;
        
        
        
    }
}
