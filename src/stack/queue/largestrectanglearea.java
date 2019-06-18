package stack.queue;

import java.util.Stack;

public class largestrectanglearea {

	public static void main(String[] args) {

		int[] arr = new int[] {

				12,9,11,12,13,14,11,15,16,11,12,33,12
				//				47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 
				//				1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55,
				//				21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71,
				//				92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81,
				//				69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 
				//				72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27

		};

		largestrectanglearea area = new largestrectanglearea();
		System.out.println(area.largestRectangleArea(arr));

	}
	
	public int largestRectangleArea2(int[] A) {
		int maxArea = 0;
		Stack<Integer> indexes = new Stack<>();
		int n = A.length;
		int i = 0;
		while( !indexes.empty() || i < n )
		{
			if(i < n && (indexes.empty() || A[i] < A[indexes.peek()]))
			{
				indexes.push(i++);
			}
			else
			{
				int topIndex = indexes.pop();
				int width = indexes.empty()?i:(i-indexes.peek()-1);
				int currArea = A[topIndex] * width;
				if (currArea > maxArea)
				{
					maxArea = currArea;
				}
			}
		}


		return maxArea;
	}


	public int largestRectangleArea0(int[] A) {
		int maxArea = 0;
		Stack<Integer> indexes = new Stack<>();
		int n = A.length;
		int i = 0;
		while( !indexes.empty() || i < n )
		{
			if(i < n && (indexes.empty() || A[i] > A[indexes.peek()]))
			{
				indexes.push(i++);
			}
			else
			{
				int topIndex = indexes.pop();
				int width = indexes.empty()?i:(i-indexes.peek()-1);
				int currArea = A[topIndex] * width;
				if (currArea > maxArea)
				{
					maxArea = currArea;
				}
			}
		}


		return maxArea;
	}



	public int largestRectangleArea(int[] A) {


		int maxArea = A[0];

		Stack<Integer> stack = new Stack<>();
		for(int i =0;i < A.length ; i++) {
			if(!stack.isEmpty() && A[i] < A[stack.peek()]) {



				while(!stack.empty() && A[stack.peek()] >= A[i]) {

					System.out.println(" running for : "+ A[stack.peek()] + " "+ A[i]);

					int count = 0;

					int index = stack.peek()-1;



					while(index >= 0 && A[index] >= A[stack.peek()]) {
						count++;
						index--;
					}


					maxArea = Math.max(maxArea, A[stack.peek()] * (i-stack.peek()+count));

					if(A[stack.peek()] == 11) {
						System.out.println(i);
						System.out.println(count);
					}
					System.out.println(" max area is "+ maxArea + " "+ A[stack.peek()] +" "+i+ " "+ (i-stack.peek()+count));



					System.out.println("remove" + stack.peek() + " "+ A[stack.pop()]  );


				}

				stack.push(i);




			}else 
			{

				if(stack.size() > 0) {

					while(!stack.isEmpty()) {
						int count = 0;

						int index = stack.peek();



						while(index >= 0 && A[index] >= A[stack.peek()]) {
							count++;
							index--;
						}
						maxArea = Math.max(maxArea, A[stack.peek()] * (i-stack.peek()+count));
						System.out.println(" max area is "+ maxArea + " "+ A[stack.peek()] + " "+ (i-stack.peek()+count));
						stack.pop();
					}
				}
				stack.push(i);
			}
		}

		return maxArea;
	}
}
