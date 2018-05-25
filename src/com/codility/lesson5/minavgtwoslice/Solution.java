package com.codility.lesson5.minavgtwoslice;

//https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/

public class Solution {
	public int solution(int[] A) {
		int [][] prefixSumA = createPrefixSum(A);
		double minAverage = Double.MAX_VALUE;
		double currentAverage = Double.MAX_VALUE;
		int minAverageSliceIndex = Integer.MAX_VALUE;
		
		for(int i=0; i<prefixSumA.length-1; i++) {
			for(int j=i+1; j<prefixSumA[i].length; j++) {
				currentAverage = (prefixSumA[i][j] / (double) (j - i + 1));
				if(currentAverage < minAverage) {
					minAverage = currentAverage;
					minAverageSliceIndex = i;
				}
			}
		}
		return minAverageSliceIndex;
	}
	
	//for array: { 4, 2, 2,  5,  1,  5,  8 } will create prefix sum pyramid:
	//             4, 6, 8, 13, 14, 19, 27
	//             0, 2, 4,  9, 10, 15, 23
	//             0, 0, 2,  7,  8, 13, 21
	//             0, 0, 0,  5,  6, 11, 19
	//             0, 0, 0,  0,  1,  6, 14
	//             0, 0, 0,  0,  0,  5, 13
	
	private int [][] createPrefixSum(int [] pA) {
		int [][] prefixSum = new int[pA.length][pA.length];
		
		for(int i=0; i<pA.length; i++) {
			int runningSum = 0;
			for(int j=i; j<pA.length; j++) {
				prefixSum[i][j] = runningSum + pA[j];
				runningSum = prefixSum[i][j]; 
			}
		}
		return prefixSum;
	}
}
