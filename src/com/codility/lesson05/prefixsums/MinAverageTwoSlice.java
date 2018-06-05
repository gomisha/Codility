package com.codility.lesson05.prefixsums;

//https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/

public class MinAverageTwoSlice {
	public int solution(int[] A) {

		//main idea: will find min average by checking only 2 and 3 contiguous elements at a time
		//reference: https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/
		int sum1, sum2 = 0;
		double minAverage = Double.MAX_VALUE;
		double currentAverage1 = Double.MAX_VALUE;
		double currentAverage2 = Double.MAX_VALUE;
		int minAverageSliceIndex = 0; //for size 2 arrays, this will always be true

		//if array is > 2 elements
		for(int i=0; i<A.length-2; i++) {
			sum1 = A[i] + A[i+1];
			currentAverage1 = sum1 / 2.0d;
			if(currentAverage1 < minAverage) {
				minAverage = currentAverage1;
				minAverageSliceIndex = i;
			}

			sum2 = sum1 + A[i+2];
			currentAverage2 = sum2 / 3.0d;
			if(currentAverage2 < minAverage) {
				minAverage = currentAverage2;
				minAverageSliceIndex = i;
			}
		}

		//check last 2 contiguous elements from the end - they won't otherwise be checked because 
		//when checking 2 and 3 contiguous elements at a time, will stop checking 3 elements from the end 
		currentAverage1 = (A[A.length-2] + A[A.length-1]) / 2.0d;
		if(currentAverage1 < minAverage) {
			minAverage = currentAverage1;
			minAverageSliceIndex = A.length-2;
		}
		
		return minAverageSliceIndex;
	}
}
