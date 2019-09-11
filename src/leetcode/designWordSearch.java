package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class designWordSearch {
	
	
	
	public static void main(String[] args) {
		WordDictionary d = new WordDictionary();
		String[] arr = new String[] {"bad","dad","mad"};
		for(String str : arr) {
			d.addWord(str);
		}
		
		String[] arr2 = new String[]{"pad","bad",".ad","b"};
		for(String str : arr2) {
			System.out.println(d.search(str));
		}

		
	}
	
}
	class WordDictionary {
	    
	    private Dic object = null;

	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        object = new Dic();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        object.addWord(word);
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return object.searchWord(word);
	    }
	}


	class Dic {
	    
	    Node root = new Node();
	    
	    
	    public boolean searchWord(String word){
	         if(word == null || word.length() == 0){
	            return false;
	        }
	        
	        return searchAplha(word, 0, root);
	        
	    }
	    
	    private boolean searchAplha(String word, int index, Node root){
	        
	    	System.out.println(word + " "+ index);
	    		
	         if(word == null || word.length() <= index){
	        	 return root.isEnd;
	        }
	        
	        char c = word.charAt(index);
	        
	        if(c == '.'){
	            
	            boolean is = false;
	            Iterator<Map.Entry<Character,Node>> itr = root.links.entrySet().iterator();
	            while(itr.hasNext()){
	                is = is || searchAplha(word, index+1, itr.next().getValue());
	                if(is) {
	                	break;
	                }
	            }
	            
	            return is;
	            
	            
	        }else{
	            
	            if(root.links.containsKey(c)){
	                return searchAplha(word, index+1, root.links.get(c));
	            }else{
	                return false;
	            }
	            
	        }
	        
	    }
	    
	    public void addWord(String word){
	        
	        if(word == null || word.length() == 0){
	            return;
	        }
	        
	       addWordAlphaBet(word,0,root);
	    }
	    
	    private void addWordAlphaBet(String word, int index, Node root){
	        
	    		if(word != null && word.length() == index) {
	    			root.isEnd = true;
	    		}
	        if(word == null || word.length() <= index){
	            return;
	        }
	        
	      
	         char c = word.charAt(index);
	        
	        if(root.links.containsKey(c)){
	            addWordAlphaBet(word, index+1, root.links.get(c));
	        }else{
	            Node temp = new Node();
	            temp.c = c;
	            root.links.put(c, temp);
	            addWordAlphaBet(word, index+1, root.links.get(c));
	        }
	    }
	    
	    
	}


	class Node {
	    
	    char c;
	    boolean isEnd = false;
	    HashMap<Character, Node> links = new HashMap<>();
	    
	}

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */

