package algo;

import java.util.HashMap;

public class tinyUrl {
	
	public static void main(String[] args) {
		tinyUrl obj = new tinyUrl();
		System.out.println(obj.insert("https://google.com"));
		System.out.println(obj.idFromUrl(obj.insert("https://google.com")));
	}
	
	private HashMap<Integer, String> cache = new HashMap<>();
	
	int primary_counter = 10000;
	
	String insert(String largeUrl) {
		
		cache.put(primary_counter, largeUrl);
		
		return shortUrl(primary_counter++);
		
	}
	
	int idFromUrl(String shortUrl) {
		String s = "abcdefghijklmnopqrstuvwxyzABCVDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		int no =0;
		int pointer = 1;
		for(int i = 0 ; i< shortUrl.length() ; i++) {
			char c = shortUrl.charAt(i);
			int index = s.indexOf(c);
			no+= index * pointer;
			
			pointer = pointer * 62;
			
			
			
		}
		return no;
	}
	
	String shortUrl(int number) {
		String s = "abcdefghijklmnopqrstuvwxyzABCVDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		String shortUrl = "";
		
		while(number > 0) {
			int reminder = number % 62;
			shortUrl+= s.charAt(reminder);
			number = number/62;
		}
		
		return shortUrl;
	}

}
