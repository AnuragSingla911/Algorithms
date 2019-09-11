package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class chessboardqueenobstacle {
	
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);


        scanner.close();
    }

	
	     static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

	       

	       

	        int total = 0;

	        for(int j =0;j < 8; j++){
	            boolean isFound = false;
	            int diff = Integer.MAX_VALUE;
	        for(int i =0; i< obstacles.length ; i++){
	            int x = obstacles[i][0] - r_q;
	            int y = obstacles[i][1] - c_q;
	            
	            //System.out.println("x "+ x+ " y "+ y);

	            if(j == 0 && Math.abs(x) == Math.abs(y) && obstacles[i][0] < r_q && obstacles[i][1] < c_q){
	                isFound = true;
	                if(Math.abs(x)-1 < diff) {
	                		diff = Math.abs(x)-1;
	                }
	                
	            }else
	            if(j == 1 && Math.abs(x) == Math.abs(y) && obstacles[i][0] > r_q && obstacles[i][1] > c_q){
	                 isFound = true;
	                 if(Math.abs(x)-1 < diff) {
	                		diff = Math.abs(x)-1;
	                }
	                
	            }else
	            if(j == 2 && Math.abs(x) == Math.abs(y) && obstacles[i][0] > r_q && obstacles[i][1] < c_q){
	                 isFound = true;
	                 if(Math.abs(x)-1 < diff) {
	                		diff = Math.abs(x)-1;
	                }
	               
	            }else
	            if(j == 3 && Math.abs(x) == Math.abs(y) && obstacles[i][0] < r_q && obstacles[i][1] > c_q){
	                 isFound = true;
	                 if(Math.abs(x)-1 < diff) {
	                		diff = Math.abs(x)-1;
	                }
	               
	            }
	            else
	            if(j == 4 && obstacles[i][0] == r_q && obstacles[i][1] > c_q){
	            	isFound = true;
	            	if(Math.abs(y)-1 < diff) {
                		diff = Math.abs(y)-1;
                }
	               
	            }
	            else
	            if(j == 5 && obstacles[i][0] == r_q && obstacles[i][1] < c_q){
	                 isFound = true;
	                 if(Math.abs(y)-1 < diff) {
	                		diff = Math.abs(y)-1;
	                }
	               
	            }
	            else
	            if(j == 6 && obstacles[i][1] == c_q && obstacles[i][0] < r_q){
	               
	                isFound = true;
	                if(Math.abs(x)-1 < diff) {
                		diff = Math.abs(x)-1;
                }
	                 
	            }
	            else
	            if(j == 7 && obstacles[i][1] == c_q && obstacles[i][0] > r_q){
	                 isFound = true;
	                 if(Math.abs(x)-1 < diff) {
	                		diff = Math.abs(x)-1;
	                }
	               
	            }

	        }
	        
	        if(isFound) {
	        	total+= diff;
	        }else
	        if(!isFound){
	            if(j == 0) {
	              total+= (c_q > r_q ? r_q-1 : c_q-1);   
	            }else if(j == 1){
	                total+= (n-c_q) > (n-r_q) ? (n-r_q) : (n-c_q);   
	            }else if(j == 2){
	                total+= (n-r_q)<c_q? (n-r_q) : c_q-1;
	            }else if(j==3){
	                 total+= (n-c_q) < r_q? (n-c_q) : r_q-1;
	            }else if(j==4){
	                 total+= (n-c_q);
	            }else if(j==5){
	                total+= (c_q-1);
	            }else if(j==6){
	                total+= (r_q-1);
	            }else if(j==7){
	                total+= (n-r_q);
	            }
	        }
	        
	      //  System.out.println("total : "+ total);
	     }
	     return total;
	     }
	     

	

}
