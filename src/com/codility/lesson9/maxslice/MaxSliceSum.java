package com.codility.lesson9.maxslice;

//https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/

public class MaxSliceSum {
	public int solution(int[] A) {
		int absoluteMax = A[0];
		int localMax = A[0];
		int nextSum = 0;
		int currentElement = 0;
		
		for (int i = 1; i < A.length; i++) {
			currentElement = A[i];
			nextSum = localMax + currentElement;
			localMax = Math.max(A[i], nextSum);
			absoluteMax = Math.max(absoluteMax, localMax);
		}
		return absoluteMax;
	}
}
