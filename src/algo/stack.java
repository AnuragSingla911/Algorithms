package algo;

import java.util.LinkedList;
import java.util.Stack;

public class stack {

	 Stack<Integer> list = new Stack<Integer>();
	 
	 LinkedList<Integer> sortedList = new LinkedList<Integer>();
	    public void push(int x) {
	        list.push(x);
	       
	        if(sortedList.size() == 0) {
	        		sortedList.add(x);
	        }else {
	        		int i =0;
	        		while(i < sortedList.size()) {
	        			if(sortedList.get(i) > x) {
	        				sortedList.add(i, x);
	        				break;
	        			}
	        		}
	        }
	        
	    }

	    public void pop() {
	        Integer element = list.pop();
	        sortedList.remove((Integer)element);
	    }

	    public int top() {
	        return list.size() > 0 ? list.peek() : -1;
	    }

	    public int getMin() {
	       return sortedList.size() > 0 ? sortedList.get(0) : -1;
	    }
}
