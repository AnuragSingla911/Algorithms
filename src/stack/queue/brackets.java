package stack.queue;

import java.util.Stack;

public class brackets {

	public static void main(String[] args) {
		System.out.println(new brackets().braces("((A+B)+C)"));
	}
	
public int braces(String A) {
        
        int noofopenbracket=0;
        int noofopetaors = 0;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i < A.length() ; i++){
            char c = A.charAt(i);
            
            if(c != ')'){
                stack.push(c);
            }else {
                StringBuilder s = new StringBuilder();
                while(!stack.isEmpty()){
                    
                    char c0 = stack.pop();
                    
                    s.append(c0);
                    if(c0 == '('){
                        break;
                    }
                   
                }
                s.append(c);
                if(s.toString().equals("()")){
                    return 0;
                }
            }
        }
        
        return  1;
    }
}
