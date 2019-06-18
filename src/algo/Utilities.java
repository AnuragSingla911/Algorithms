package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class Utilities {
	
	public static <T> void printArrayList(ArrayList<T> list) {
		for(int i =0; i < list.size() ; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	public static <T> ArrayList<T> toList(T[] arr){
		return new ArrayList<>(Arrays.asList(arr));
	}
	
	public static <T> ArrayList<ArrayList<T>> toList(T[][] arr){
		ArrayList<ArrayList<T>> result = new ArrayList<>();
		
		for(int i = 0;i < arr.length ; i++) {
			ArrayList<T> row = new ArrayList<>();
			for(int j =0; j <arr[i].length ; j++) {
				row.add(arr[i][j]);
			}
			result.add(row);
		}
		return result;
	}
	
	public static <T> void print2DArrayList(ArrayList<ArrayList<T>> arr){
		
		for(int i = 0;i < arr.size() ; i++) {
			for(int j =0; j <arr.get(i).size() ; j++) {
				System.out.print(arr.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}
	
public static <T> void print2DArray(T[][] arr){
		
		for(int i = 0;i < arr.length ; i++) {
			for(int j =0; j <arr[i].length ; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static <T> void printArr(int[] depth){
		for(int i =0; i < depth.length ; i++) {
			System.out.println(depth[i]);
		}
	}

}
