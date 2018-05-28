package com.codility.lesson5.minavgtwoslice;

//https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/

public class Solution {
	public int solution(int[] A) {

		//main idea: will find min average by checking only 2 contiguous elements at a time
		int sum = 0;
		double minAverage = Double.MAX_VALUE;
		double currentAverage = Double.MAX_VALUE;
		int minAverageSliceIndex = Integer.MAX_VALUE;

		for(int i=0; i<A.length-1; i++) {
			sum = A[i] + A[i+1];
			currentAverage = sum / 2.0d;
			if(currentAverage < minAverage) {
				minAverage = currentAverage;
				minAverageSliceIndex = i;
			}
		}
		return minAverageSliceIndex;
	}
}
