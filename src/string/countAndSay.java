package string;

public class countAndSay {

	public static void main(String[] args) {
		System.out.println(new countAndSay().countAndSay(5));
	}

	public String countAndSay(int A) {

		if(A == 1){
			return "1";
		}


		String prev = countAndSay(A-1);
		int count = 0;
		String result = "";
		for(int i =0; i< prev.length()-1; i++){
			if(prev.charAt(i) == prev.charAt(i+1)){
				count++;
			}else{
				count++;
				result+= ""+count+prev.charAt(i);
				count = 0;
			}
		}
		count++;
		result += ""+count + prev.charAt(prev.length()-1);

		return result;
	}

}
