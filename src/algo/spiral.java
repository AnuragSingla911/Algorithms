package algo;

import java.util.ArrayList;

public class spiral {
	
	public static void main(String[] args) {
		
		spiral obj= new spiral();
		
		
		obj.diagonal(Utilities.toList(new Integer[][] {{1,2},{3,4}}));
		
	}
	
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		
		 ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		 
		 int i=0;int j=0;
		 while(i < A.size() && j < A.get(i).size()) {
			 int k=i;int l=j;
			 
			 
			 ArrayList<Integer> rows = new ArrayList<Integer>();
			 
			 while(k < A.size() && l >= 0) {
				 rows.add(A.get(k).get(l));
				 k++;
				 l--;
				 
			 }
			 
			 list.add(rows);
			 
			 if(j < A.get(i).size()-1) {
				 j++;
			 }else {
				 i++;
			 }
			 
			 
		 }
		 
		 Utilities.print2DArrayList(list);

		 return list;
		
    }
	
	 public ArrayList<ArrayList<Integer>> solve(int A) {
		 
		 ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		 
		 if(A< 1) {
			 return list;
		 }
		 ArrayList<Integer> firstrow = new ArrayList<Integer>();
firstrow.add(1);
list.add(firstrow);
		 for(int i= 1; i< A;i++) {
			 ArrayList<Integer> row = new ArrayList<Integer>();
				  for(int j=0 ;j < i+1;j++) {
					  int no = 0;
					  int prev_j_minus_1 = j > 0? list.get(i-1).get(j-1) : 0;
					  int prev_j = list.get(i-1).size() > j ? list.get(i-1).get(j) :0;
					  no = prev_j_minus_1 + prev_j;
					  row.add(no);
				  }
				  list.add(row);
			 
		 }
		 
		 Utilities.print2DArrayList(list);
		 return list;
		 
	    }
	
	 public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		 
		 int dir= 1;
		 
		 
		int[][] arr= new int[A][A];
		
		int counter = 1;
		
		for(int i=0;i< A;i++) {
			arr[0][i]= counter++;
		}
		
		int i=0;int j=A-1;
		dir=2;
		
		int noOfTimesRun = A-1;
		
		while(counter <= A*A) {
			
			if(dir==2) {
				
				for(int k=0;k<noOfTimesRun;k++) {
					arr[++i][j]= counter++;
				}
			
				for(int k=0;k<noOfTimesRun;k++) {
					arr[i][--j]=counter++;
				}
				
				dir=4;
			}else if(dir == 3) {
				for(int k=0;k<noOfTimesRun;k++) {
					arr[i][--j]=counter++;
				}
				
				for(int k=0;k<noOfTimesRun;k++) {
					arr[--i][j]= counter++;
				}
				
				dir=1;
				
			}else if(dir==4) {
				for(int k=0;k<noOfTimesRun;k++) {
					arr[--i][j]= counter++;
				}
				
				for(int k=0;k<noOfTimesRun;k++) {
					arr[i][++j]=counter++;
				}
				
				dir=2;	
				
			} else {
				for(int k=0;k<noOfTimesRun;k++) {
					arr[i][++j]=counter++;
				}
				

				for(int k=0;k<noOfTimesRun;k++) {
					arr[++i][j]= counter++;
				}
				
				dir=3;
				
				
			}
			
			noOfTimesRun--;
			
			
		}
		
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		for(int m=0; m<arr.length;m++) {
			ArrayList<Integer> row=new ArrayList<Integer>();
			for(int n=0;n<arr.length;n++) {
				row.add(arr[m][n]);
			}
			result.add(row);
		}
		
		 
		 return result;
	    }

}
