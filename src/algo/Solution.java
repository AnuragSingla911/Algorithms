package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arrive = Utilities.toList(new Integer[] {
				 Integer.MAX_VALUE, 47, 17, 39, 35, Integer.MIN_VALUE, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27
				});
		ArrayList<Integer> depart = Utilities.toList(new Integer[] {
				Integer.MAX_VALUE, 82, 39, 86, 81, 58, Integer.MIN_VALUE, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38
				});
				Solution s = new Solution();
				
				System.out.println(s.hotel(arrive, depart, 16));
	}
	
	
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        
        ArrayList<Point> list = new ArrayList<>();
        for(int i =0; i< arrive.size(); i++){
            list.add(new Point(arrive.get(i), true));
        }
        
        for(int i =0; i< depart.size(); i++){
            list.add(new Point(depart.get(i), false));
        }
        
        Collections.sort(list, new Comparator<Point>() {
        	@Override
        	public int compare(Point o1, Point o2) {
        		// TODO Auto-generated method stub
        		return o1.value > o2.value ? 1 : -1;
        	}
        });
        
        
        int noofguest = 0;
        
        for(int i =0; i< list.size() ; i++) {
        	
        	Point point = list.get(i);
        	
        	if(point.isStart) {
        		noofguest++;
        		if(noofguest > K) {
        			return false;
        		}
        	}else {
        		noofguest--;
        	}
        	
        }
        
        return true;
        
        
    }
    
   }

class Point {
    int value;
    boolean isStart;
    Point(int value, boolean isStart) { this.value = value ; this.isStart = isStart; }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return value + " "+ isStart;
    }
}
