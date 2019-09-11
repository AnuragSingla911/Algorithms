package leetcode;

public class MedianOFTwoSortedArray {
	
	public static void main(String[] args) {
		int[] first = new int[] {1,3,4};
		int[] sec = new int[] {2};
		MedianOFTwoSortedArray obj = new MedianOFTwoSortedArray();
		
		System.out.println(obj.findMedianSortedArrays(first, sec));
	}

	
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        return findMedian(nums1,nums2,0,nums1.length-1,0,nums2.length-1);
	    }
	    
	    private double findMedian(int[] num1, int[] num2, int firstleft, int firstright
	                             , int secondleft, int secondright){
	    		System.out.println(firstleft + " "+  firstright + " "+ secondleft + " "+ secondright);
	    		
	        int firstlength = firstright-firstleft+1;
	        double first = (firstlength)%2 != 0 ? num1[firstlength/2 + firstleft] : 
	            ((double)(num1[firstlength/2 + firstleft]+num1[firstlength/2-1+ firstleft]))/2;
	        
	        int secondlength = secondright-secondleft+1;
	        double second = (secondlength)%2 != 0 ? num2[secondlength/2 + secondleft] : 
	            ((double)(num2[secondlength/2 + secondleft]+num2[secondlength/2-1+ secondleft]))/2;
	        
	        if(first == second){
	            return first;
	        }else if(first > second){
	        		if(0 == firstlength/2) {
	        			return num2[secondright-secondlength/2];
	        		}else if((secondright+1)==secondlength/2) {
	        			return num1[firstlength/4];
	        		}
	            return findMedian(num1, num2, 0, firstlength/2, secondlength/2, secondright);
	        }else{
	        	if(0 == secondlength/2) {
        			return num2[secondlength/4];
        		}else if(firstright==firstlength/2) {
        			return num1[firstright-firstlength/2];
        		}
	            return findMedian(num1,num2,firstlength/2, firstright, 0, secondlength/2);
	        }
	    }
	}

