package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mergeIntervals {

	public static void main(String[] args) {
		
		ArrayList<Interval> list = new ArrayList<>();
		
		list.add(new Interval(1,2));
		list.add(new Interval(2,3));
		list.add(new Interval(3,4));
		
		mergeIntervals obj = new mergeIntervals();
		obj.merge(list);
		
		Utilities.printArrayList(list);
		
	}
	
	 public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 
		 Collections.sort(intervals, new Comparator<Interval>() {
			 @Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start > o2.start ? 1 : -1;
			}
		});
		 
		 int i =0;
		 int overlapiing = 0;
		 while(i < intervals.size()-1) {
			 Interval current = intervals.get(i);
			 Interval next = intervals.get(i+1);
			 
			 if(current.end >= next.start) {
				 current.end = next.end > current.end ? next.end : current.end;
				 intervals.remove(i+1);
				 overlapiing++;
			 }else {
				 i++;
			 }
		 }
		 
		 return intervals;

	    }
	
	 public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		 
		 
		 for(int i =0; i< intervals.size() ; i++) {
			 Interval interval = intervals.get(i);
			 if(newInterval.start > interval.end) {
				 
				 if(i == intervals.size()-1) {
					 intervals.add(interval);
					 break;
				 }
				 continue;
			 }
			 
			 if(newInterval.end < interval.start) {
				 intervals.add(i, newInterval);
				 break;
			 }else
			 if(newInterval.start < interval.start) {
				 
				interval.start = newInterval.start;
				
				if(newInterval.end < interval.end) {
					//donothing
					break;
				}else {
					boolean isFound = false;
					
					while(!isFound) {
						if(i == intervals.size() -1) {
							interval.end = newInterval.end;
							break;
						}
						Interval intervalNext = intervals.get(i+1);
						if(intervalNext.start > newInterval.end) {
							interval.end = newInterval.end;
							isFound = true;
							break;
						}else if(intervalNext.end > newInterval.end) {
							interval.end = intervalNext.end;
							intervals.remove(i+1);
							break;
						}else {
							intervals.remove(i+1);
						}
						
					}
					
					
						break;
					
				}
				 
			 }else {
				 if(newInterval.end < interval.end) {
						//donothing
					 break;
					}else {
						boolean isFound = false;
						
						while(!isFound) {
							if(i == intervals.size() -1) {
								interval.end = newInterval.end;
								break;
							}
							Interval intervalNext = intervals.get(i+1);
							if(intervalNext.start > newInterval.end) {
								interval.end = newInterval.end;
								isFound = true;
								break;
							}else if(intervalNext.end > newInterval.end) {
								interval.end = intervalNext.end;
								intervals.remove(i+1);
								break;
							}else {
								intervals.remove(i+1);
							}
							
						}
						
						
							break;
						
					}
			 }
		 }
		 
		 
		 
		 return intervals;

	    }
	
	
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return start + " "+ end;
    }
}
