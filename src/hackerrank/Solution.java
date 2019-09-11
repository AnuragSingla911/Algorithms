package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {

        long[] count = new long[container.length];

        long[] totalBalls = new long[container.length];

        for(int i =0; i < container.length ; i++){
            long c = 0;
            long t = 0;
            for(int j =0; j < container.length ; j++){
                c+= container[j][i];
                t+= container[i][j];
            }
            count[i] = c;
            totalBalls[i] = t;

           
        }
        
        Arrays.sort(count);
        Arrays.sort(totalBalls);
        
        for(int i =0; i< count.length ; i++) {
        		if(count[i] != totalBalls[i]) {
        			return "ImPossible";
        		}
        }

        
return "Possible";
        
   
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            System.out.println(result);
           
        }


        scanner.close();
    }
}

