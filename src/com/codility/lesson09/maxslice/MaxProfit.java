package com.codility.lesson09.maxslice;

//https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/

public class MaxProfit {

	public int solution(int[] A) {
		if(A.length < 2) return 0; //for empty array or 1 element array, no profit can be realized
		
		//convert profit table to delta table so can use max slice technique
		int [] deltaA = new int[A.length];
		deltaA[0] = 0;
		for(int i=1; i<A.length; i++) {
			deltaA[i] = A[i] - A[i-1];
		}
		
		int absoluteMax = deltaA[0];
		int localMax = deltaA[0];
		int nextSum = 0;
		int currentElement = 0;
		
		for (int i = 1; i < deltaA.length; i++) {
			currentElement = deltaA[i];
			nextSum = localMax + currentElement;
			localMax = Math.max(deltaA[i], nextSum);
			absoluteMax = Math.max(absoluteMax, localMax);
		}
		if(absoluteMax > 0) return absoluteMax;
		
		return 0; 
	}
}
