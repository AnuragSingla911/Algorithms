package askedbyG;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class bracksts {
    private static final Scanner scanner = new Scanner(System.in);

	 public static void main(String[] args) throws IOException {

	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            String s = scanner.nextLine();

	            String result = isBalanced(s);
	            System.out.println(result);
	          
	        }

	       

	        scanner.close();
	    }

	 static String isBalanced(String s) {

	        Stack<Character> stack = new Stack<Character>();

	        for(int i =0; i < s.length() ; i++){
	            char c = s.charAt(i);

	            if(c == '(' || c == '{' || c == '['){
	                stack.push(c);
	            }else if(c == ')'){
	                if(!stack.isEmpty() && stack.peek() == '('){
	                    stack.pop();
	                }else{
	                    stack.push(c);
	                }
	            }else if(c == '}'){
	                if(!stack.isEmpty() && stack.peek() == '{'){
	                    stack.pop();
	                }else{
	                    stack.push(c);
	                }
	            }else if(c == ']'){
	                if(!stack.isEmpty() && stack.peek() == '['){
	                    stack.pop();
	                }else{
	                    stack.push(c);
	                }
	            }
	        } 

	        return stack.isEmpty() ? "Yes" : "No";


	    }
}
