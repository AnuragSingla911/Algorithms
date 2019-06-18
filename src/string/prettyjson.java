package string;

import java.util.ArrayList;

import algo.Utilities;

public class prettyjson {
	
	public static void main(String[] args) {
		Utilities.printArrayList(new prettyjson().prettyJSON(
				"[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]"
				));
	}

	 public ArrayList<String> prettyJSON(String A) {
		 
		 ArrayList<String> result = new ArrayList<String>();
		 
		 StringBuilder line = new StringBuilder();
		 for(int i = 0; i< A.length(); i++) {
			 char c = A.charAt(i);
			 if(c == ' ') {
				 continue;
			 }
			 if(c == '{' ||c  == '[') {
				 
				 if(line.toString().trim().length()>0) {
				 result.add(line.toString());
				 }
				 int index = line.toString().lastIndexOf('\t')+1;
				 line = new StringBuilder();
				 for(int k =0; k < index; k++) {
					 line.append("\t");
				 }
				 line.append(c);
				 result.add(line.toString());
				 line = new StringBuilder();
				 for(int k =0; k < index+1; k++) {
					 line.append("\t");
				 } 
			 }else if(c == '}' || c == ']') {
				 result.add(line.toString());
				 int index = line.toString().lastIndexOf('\t')+1;
				 line = new StringBuilder();
				 for(int k =0; k < index-1; k++) {
					 line.append("\t");
				 }
				 line.append(c);
				 
				 if(i==A.length()-1) {
					 result.add(line.toString());
				 }
			 }else if(c == ',') {
				 line.append(c);
				 result.add(line.toString());
				 
				 int index = line.toString().lastIndexOf('\t')+1;
				 line =new StringBuilder();
				 for(int k =0; k < index; k++) {
					 line.append("\t");
				 }
				 
				 
			 }else {
				 line.append(c);
			 }
			 
			 
		 }
		 
		 if(result.size()>0 && ( result.get(0) == null || result.get(0).length()==0)) {
			 result.remove(0);
		 }
		 return result;
		 
	    }
}
