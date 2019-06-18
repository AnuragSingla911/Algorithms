package testChallange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        
        int noofTestCases = sc.nextInt();
        
        for(int i =0; i< noofTestCases ; i++) {
        	
        			int N = sc.nextInt();
        			
        			int Q = sc.nextInt();
        			
        			int[] happiness = new int[N];
        			
        			for(int j =0; j< N; j++) {
        				happiness[j] = sc.nextInt();
        			}
        			
        			ChoosenList choosenList = new ChoosenList();
        			for(int j =0;  j< Q; j++) {
        				int first = sc.nextInt();
        				int second = sc.nextInt();
        				
        				choosenList.addPair(first, second, happiness);
        				
        				System.out.print(choosenList.H + " ");
        				
        				System.out.print(choosenList.getC() + " ");
        				
        				System.out.println(choosenList.getP());
        				
        			}
        }
        
        sc.close();
        
        
        
    }
}
class ChoosenList{
	ArrayList<Data> choosenList = new ArrayList<>();
	
	int H = 0;
	
	void addPair(int first,int second, int[] happiness) {
		if(choosenList.isEmpty()) {
			Data pair = new Data(first, second, happiness);
			choosenList.add(pair);
			H = H > pair.H ? H : pair.H;
        			return;
		}
		boolean isAdded = false;
		Data alreadyAdded = null;
		for(int i =0; i< choosenList.size() ; i++) {
			Data data = choosenList.get(i);
			if(!isAdded && (data.choosen.contains(first) || data.choosen.contains(second))) {
				isAdded = true;
				data.addMember(first, happiness);
				data.addMember(second, happiness);
				alreadyAdded = data;
				H = H > data.H ? H : data.H;
        			
			}else if(isAdded && ((data.choosen.contains(first) || data.choosen.contains(second)))){
				if(alreadyAdded != null) {
					for(Integer member : data.choosen) {
					alreadyAdded.addMember(member, happiness);
					}
				}
				choosenList.remove(data);
			}
		}
		
		if(!isAdded) {
			Data pair = new Data(first, second, happiness);
			choosenList.add(pair);
			H = H > pair.H ? H : pair.H;
		}
		
	}
	
	int getH() {
		return H;
	}
	
	int getP() {
		int P = 1;
		for(Data data : choosenList) {
			P = P * data.getNoOfMembers();
		}
		return P;
	}
	
	int getC() {
		
		int count =0;
		
		for(Data data : choosenList) {
			if(data.isPrime()) {
				count++;
			}
		}
		
		return count;
		
	}
}

class Data {
	HashSet<Integer> choosen = new HashSet<>();
	int H;
	int P;
	int C;
	
	Data(int first,int second, int[] happiness){
		choosen.add(first);
		choosen.add(second);
		H = happiness[first-1] > happiness[second-1] ? happiness[first-1] : happiness[second-1];
	}
	
	void addMember(int extra, int[] happiness){
		choosen.add(extra);
		H = H > happiness[extra-1] ? H : happiness[extra-1];
	}
	
	int getNoOfMembers() {
		return choosen.size();
	}
	
	boolean isPrime()
	{
		int no = choosen.size();
		for(int i = 2 ; i<= Math.sqrt(no); i++){
			if(no % i == 0) {
				return false;
			}
		}
		return true;
	}
}
