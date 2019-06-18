package stack.queue;

import java.util.Stack;

public class unixpath {
	
	public static void main(String[] args) {
		unixpath obj = new unixpath();
		
		System.out.println(obj.simplifyPath("/a/./b/../../c/"));
	}

public String simplifyPath(String A) {
        
        
        String result = "";
        
        Stack<String> stack = new Stack<String>();
        
        String[] tokens = A.split("/");
        
        for(String s : tokens){
            if(s.equals("") || s.equals(".")){
                continue;
            }else if(s.equals("..")){
                stack.pop();
            }else{
                stack.push(s);
            }
        }
        
       
        while(!stack.isEmpty()){
             result +=( "/"+stack.pop());
            
        }
        
        return result;
        
        
        
        
        
    }

}
