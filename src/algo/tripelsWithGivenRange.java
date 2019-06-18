package algo;

import java.util.ArrayList;
import java.util.HashMap;

public class tripelsWithGivenRange {

	public static void main(String[] args) {
		
		ArrayList<String> list = Utilities.toList(new String[] { "0.365324", "0.240027", "0.436859", "0.046575", "0.059988", "0.302172", "0.145662", "0.238757", "0.087429", "0.243201" });
		tripelsWithGivenRange obj = new tripelsWithGivenRange();
		System.out.println(obj.solve(list));
		
				

	}

	public int solve(ArrayList<String> A) {

		HashMap<String, ArrayList<Float>> bucket = new HashMap<>();
		bucket.put("A", new ArrayList<Float>());
		bucket.put("B", new ArrayList<Float>());

		bucket.put("C", new ArrayList<Float>());



		for(int i =0; i< A.size() ; i++) {
			float value = Float.parseFloat(A.get(i));

			if(value < 0.66) {
				ArrayList<Float> bucketA = bucket.get("A");
				bucketA.add(value);
			}else if(value >= 0.66 && value < 1.33) {
				ArrayList<Float> bucketB = bucket.get("B");
				bucketB.add(value);
			}else if(value >= 1.33 && value < 2) {
				ArrayList<Float> bucketC = bucket.get("C");
				bucketC.add(value);
			}
		}


		//AAA
		{
		ArrayList<Float> bucketA = bucket.get("A");
		if(bucketA.size() >= 3) {

			float highest = 0;
			float secondHighest = 0 ;
			float thirdHighest = 0;

			for(int i = 0; i< bucketA.size() ; i++) {
				float value = bucketA.get(i);
				
				if(value > highest) {
					thirdHighest = secondHighest;
					secondHighest = highest;
					highest = value;
				}else if(value > secondHighest) {
					thirdHighest = secondHighest;
					secondHighest = value;
				} else if(value > thirdHighest) {
					thirdHighest = value;
				}
				
			}
		
			
			float sum = highest + secondHighest + thirdHighest;
			
			if(sum > 1 && sum < 2) {
				System.out.println("AAA");
				return 1;
			}

		}
		}
		
		//AAC
		{
			
			ArrayList<Float> bucketA = bucket.get("A");

		ArrayList<Float> bucketC = bucket.get("C");
		if(bucketA.size() >= 2 && bucketC.size() >= 1) {

			float minimumA = 2;
			float secondminimuma = 2;
			float minC = bucketC.get(0);

			for(int i =0; i< bucketA.size() ; i++) {
				
				float value = bucketA.get(i);
				
				if(value < minimumA ) {
					secondminimuma = minimumA;
					minimumA = value;
				}else if(value < secondminimuma) {
					secondminimuma = value;
				}
				
			}
			
			for(int i =0; i< bucketC.size() ; i++) {
				
				float value = bucketC.get(i);
				
				if(value < minC ) {
					minC = value;
				}
				
			}
			
			float sum = minC + minimumA + secondminimuma;
			
			if(sum > 1 && sum < 2) {
				System.out.println("AAC");
				return 1;
			}
		}
		}
		
		{
			
			//ABB
			ArrayList<Float> bucketB = bucket.get("B");
			ArrayList<Float> bucketA = bucket.get("A");

			if(bucketA.size() >= 1 && bucketB.size() >= 2) {

				float minB = 2;
				float secMinB = 2;
				float minA = bucketA.get(0);

				for(int i =0; i< bucketB.size() ; i++) {
					
					float value = bucketB.get(i);
					
					if(value < minB ) {
						secMinB = minB;
						minB = value;
					}else if(value < secMinB) {
						secMinB = value;
					}
					
				}
				
				for(int i =0; i< bucketA.size() ; i++) {
					
					float value = bucketA.get(i);
					
					if(value < minA ) {
						minA = value;
					}
					
				}
				
				System.out.println(minA + " "+ minB+ " "+ secMinB);
				
				float sum = minA + minB + secMinB;
				
				if(sum > 1 && sum < 2) {
					System.out.println("ABB");
					return 1;
				}

		}
			
		}
			
			{
				//AAB
				//overflow
				
				ArrayList<Float> bucketA = bucket.get("A");

				ArrayList<Float> bucketB = bucket.get("B");
				if(bucketA.size() >= 2 && bucketB.size() >= 1) {

					float minimumA = 2;
					float secondminimuma = 2;
					float minB = bucketB.get(0);

					float maxA = 0;
					float secondMaxA = 0;
					float maxB = bucketB.get(0);

					for(int i =0; i< bucketA.size() ; i++) {
						
						float value = bucketA.get(i);
						
						if(value < minimumA ) {
							secondminimuma = minimumA;
							minimumA = value;
						}else if(value < secondminimuma) {
							secondminimuma = value;
						}
						
						if(value > maxA) {
							secondMaxA = maxA;
							maxA = value;
						}else if(value > secondMaxA) {
							secondMaxA = value;
						}
						
					}
					
					for(int i =0; i< bucketB.size() ; i++) {
						
						float value = bucketB.get(i);
						
						if(value < minB ) {
							minB = value;
						}
						
						if(value > maxB) {
							maxB = value;
						}
						
					}
					
					float overflowSum = minB + minimumA + secondminimuma;	
					float underFlowSum = maxB + maxA + secondMaxA;
					
					if(underFlowSum > 1 && overflowSum < 2) {
						return 1;
					}
					
				}
				
			}
		
		return 0;
	}



}
