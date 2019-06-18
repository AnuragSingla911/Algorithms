package string;

import java.util.ArrayList;

import algo.Utilities;

public class fulljustify {

	public static void main(String[] args) {
		ArrayList<String> list= Utilities.toList(new String[] {
				"What", "must", "be", "shall", "be."
				});
		Utilities.printArrayList(new fulljustify().fullJustify(list, 12));
	}
	public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
		ArrayList<String> result = new ArrayList<>();

		ArrayList<Integer> size= new ArrayList<>();

		int i =0; 

		while(i < A.size()) {

			StringBuilder builder = new StringBuilder();

			int x=0;
			while(i < A.size() && (builder.length()+A.get(i).length()) <= B) {
				x+= A.get(i).length();
				builder.append(A.get(i++) + " ");

			}

			result.add(builder.toString().substring(0,builder.lastIndexOf(" ")));
			size.add(x);




		}


		for(int j =0; j< result.size()-1 ; j++) {
			String str = result.get(j);
			if(str.length() < B) {
				int spacesRequired = B-size.get(j);
				String[] tokens = str.split(" ");
				StringBuilder builder = new StringBuilder();
				builder.append(tokens[0]);
				int m = 1;
				for(int k = tokens.length-1; k> 0 ; k--) {
					float fraction = spacesRequired*1.0f/(k);
					int no = spacesRequired/k;
					if(fraction > no) {
						no++;
					}
					
					for(int l = 0; l < no ; l++) {
						builder.append(" ");
					}
					builder.append(tokens[m++]);
					
					spacesRequired-= no;
						
					
				}
				result.set(j,builder.toString());


			}
		}

		int yu=0;
		if(yu < result.size()) {
			String build =  result.get(yu);
			if(build.length() < B) {
				int spacesRequireds = B-build.length();
				for(int l =0; l < spacesRequireds; l++) {
					build+= " ";
				}
				result.set(yu, build);
			}
			yu++;
		}


		return result;
	}
}
