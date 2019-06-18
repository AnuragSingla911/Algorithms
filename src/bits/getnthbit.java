package bits;

public class getnthbit {

	public static void main(String[] args) {
		
		System.out.println(new getnthbit().clearnthbit(8,  5));
		
	}
	
	
	public int getnthbit(int no, int index) {
		return (no >> index)&1;
	}
	
	public int setntbit(int no, int index) {
		return (1 << index) | no;
	}
	
	public int clearnthbit(int no,int index) {
		return (~(1 << index)) & no;
	}
}
