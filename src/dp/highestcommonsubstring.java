package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import algo.Utilities;

public class highestcommonsubstring {
	
	
	public static void main(String[] args) {
		ArrayList<String> list = Utilities.toList(new String[] {
				"qfgxmuvgfaj", "lfvenhyuhuor", "osamibdnj", "beyhkbso"
		});
		
		System.out.println(new highestcommonsubstring().solve(list));
	}
	
	public int solve(ArrayList<String> A) {
		
		return find(A);
		
		
	}
	
	
	private int find(ArrayList<String> A) {
		
		Queue<String> queue = new LinkedList<>();
		Queue<ArrayList<String>> indexList = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		int p = 0;
		for(int i =0 ; i < A.size() ; i++) {
			queue.add(A.get(i));
			
			ArrayList<String> s = new ArrayList<>(A);
			s.remove(A.get(i));
			indexList.add(s);
		}
		
		int finallength = Integer.MAX_VALUE;
		
		
		while(!queue.isEmpty()) {
			String s = queue.poll();
			set.add(s);
			p++;
			ArrayList<String> leftStrings = indexList.poll();
			System.out.println(p +" "+ set.size()+ " "+ s.hashCode());
			if(s.length() > finallength) {
				continue;
			}
			
			
			if(leftStrings.size() == 0) {
				if(s.length() < finallength) {
					finallength = s.length();
					//System.out.println(s);
					continue;
				}
			}
			
			for(String str : leftStrings) {
				
				
				StringBuilder builder = new StringBuilder(s);
				int index = 0;
	            int matchIndex = -1;

	            while(index < str.length()){
	                String subString = str.substring(0,index+1);
	                //System.out.println(subString);
	                if(builder.indexOf(subString) < 0) {
	                    //System.out.println(" matcgh index : "+ matchIndex);
	                    if(matchIndex == builder.length())
	                        builder.append(str.substring(index));
	                    else
	                        builder.append(str);
	                    break;
	                }else {
	                    matchIndex = builder.indexOf(subString) + subString.length();
	                    //System.out.println(matchIndex);
	                }

	                index++;
	            }
	            
	            
	            queue.add(builder.toString());
	            
	            ArrayList<String> strs = new ArrayList<String>(leftStrings);
	            strs.remove(str);
	            
	            indexList.add(strs);
				
				
			}
			
		}
		
		return finallength;
		
		
	}
	
	
	
	private void findCommonSuffix(String a,String b) {
		int i = 0;
		int j = 0;
		
		while(true) {
			if(a.charAt(i) == b.charAt(j)) {
				i++;
				j++;
			}else {
				i++;
				j=0;
			}
		}
	}

}
