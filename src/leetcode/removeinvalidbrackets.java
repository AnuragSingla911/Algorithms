package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

import algo.Utilities;

public class removeinvalidbrackets {

	public static void main(String[] args) {
		SolutionW obj = new SolutionW();
		Utilities.printArrayList(new ArrayList<String>(obj.removeInvalidParentheses(")()()()()()()()()()()")));
	}
}

class SolutionW{
	
	private boolean isValid(String s){
        int start = 0;
        int end = 0;
        
        for(int i =0; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                start++;
            }else if(s.charAt(i) == ')' && end < start){
                end++;
            }else if(s.charAt(i) == ')'){
                return false;
            }
        }
        
        if(start == end){
            return true;
        }else{
            return false;
        }
    }

	public List<String> removeInvalidParentheses(String s) {
		
	
		TreeMap<Integer,HashSet<String>> set = new TreeMap<Integer,HashSet<String>>();
		for(int i = s.length() ; i>= 0 ;i--) {
			recv(s.substring(0, i),0,0,0,set,s.length()-i);
		}
		
		
		if(set.size() == 0) {
			ArrayList<String> list = new ArrayList<String>();
			StringBuilder builder = new StringBuilder();
			for(int i =0; i< s.length() ; i++) {
				if(s.charAt(i) == '(' || s.charAt(i) == ')') {
					
				}else {
					builder.append(s.charAt(i));
				}
				
			}
			list.add(builder.toString());
			return list;
		}
		
		return new ArrayList<String>(set.firstEntry().getValue());
	}
	
	private HashMap<String, String> map = new HashMap<>();
	
	private void recv(String s,int starting,int startCount, int endCount, TreeMap<Integer,HashSet<String>> set, int noofremain) {
		System.out.println(s + " "+ startCount + " "+ endCount + " "+ noofremain);
		if(s.length() <= 1) {
			return;
		}
		
		if(set.containsKey(noofremain-1)) {
			return;
		}
		
	String key = s;
		
		if(map.containsKey(key)) {
			return;
		}
		
		
		
		if(isValid(s)) {
			map.put(key, s);
			if(set.containsKey(noofremain)) {
				set.get(noofremain).add(s);
			}else {
				HashSet<String> sett = new HashSet<>();
				sett.add(s);
				set.put(noofremain, sett);
			}
			return;
		}
		
		recv(s.substring(1), 0,startCount,endCount,set,noofremain+1);
		for(int i = starting; i< s.length()-1 ; i++) {
			if(s.charAt(i) == '(') {
				if(startCount == endCount) {
					recv(s.substring(0, i) + s.substring(i+1), i, startCount,endCount,
							set,noofremain+1);
				}
				recv(s, i+1, startCount+1,endCount,set,noofremain);
			}else if(s.charAt(i) == ')'){
				if(endCount<startCount)
				recv(s, i+1,startCount,endCount+1,set,noofremain);
				recv(s.substring(0, i) + s.substring(i+1), i,startCount,endCount,set,noofremain+1);
			}else {
				
			}
			
		}
		
	}
	
}

class SolutionR {
    
    private String removeUnwanted(String s){
        
         int start = 0;
        int end = 0;
        StringBuilder builder = new StringBuilder();
        for(int i =0; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                start++;
                builder.append(s.charAt(i));
            }else if(s.charAt(i) == ')' && start==0){
                
            }else{
           
                builder.append(s.charAt(i));
            }
            
           
        }
        
        s = builder.toString();
        System.out.println(s);
        start=0;end=0;
        builder = new StringBuilder();
        for(int i =s.length()-1; i>=0; i--){
            if(s.charAt(i) == ')'){
                end++;
                builder.append(s.charAt(i));
            }else if(s.charAt(i) == '(' && end == 0){
                
            }else{
            	start++;
                builder.append(s.charAt(i));
            }
            
           
        }
        return builder.reverse().toString();
        
        
    }
    public List<String> removeInvalidParentheses(String s) {
        
        
        s = removeUnwanted(s);
        
        
        if(isValid(s)){
            List<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }else{
             int start = 0;
        int end = 0;
        
        for(int i =0; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                start++;
            }else if(s.charAt(i) == ')' && start > 0){
                end++;
            }
            
           
        }
        if(end == 0) {
    		 List<String> list = new ArrayList<String>();
            StringBuilder builder = new StringBuilder();
             for(int i =0; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                
            }else if(s.charAt(i) == ')'){
                
            }else{
                builder.append(s.charAt(i));
            }
            
           
        }
            list.add(builder.toString());
            return list;
    }
            HashSet<String> set = new LinkedHashSet<String>();
            diff(start>end?start-end:end-start
                                             ,s,set,start>end);
            return new ArrayList<String>(set);
        }
        
        
        
    }
    
    private void diff(int diff, String s, HashSet<String> set, boolean start){
    	System.out.println(diff + " "+ s + " "+ start);
        char c = start? '(' : ')';
        if(diff == 0 ){
        		if(isValid(s)) {
        			System.out.println("valid : "+ s);
        			set.add(s);
        		}
            return;
        }
        
        for(int i = 0 ; i < s.length()-1 ; i++){
            if(s.charAt(i) == c){
                String next = s.substring(0, i)+ s.substring(i+1);
                diff(diff-1, next, set, start);
            }
        }
    }
    
    
    private boolean isValid(String s){
        int start = 0;
        int end = 0;
        
        for(int i =0; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                start++;
            }else if(s.charAt(i) == ')' && end < start){
                end++;
            }else if(s.charAt(i) == ')'){
                return false;
            }
        }
        
        if(start == end){
            return true;
        }else{
            return false;
        }
    }
}