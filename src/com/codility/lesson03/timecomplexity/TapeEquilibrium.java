package com.codility.lesson03.timecomplexity;

//https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/

public class TapeEquilibrium {
	public int solution(int[] A) {
		long sumAllElements = 0;
		for(int i=0; i<A.length; i++) {
			sumAllElements += A[i];
		}
		
		int minDifference = Integer.MAX_VALUE;
		int currentDifference = Integer.MAX_VALUE;
		long sumFirstPart = 0;
		long sumSecondPart = 0;

		for(int p=0; p<A.length-1; p++) {
			sumFirstPart += A[p];
			sumSecondPart = sumAllElements - sumFirstPart;
			currentDifference = (int) Math.abs(sumFirstPart - sumSecondPart);
			minDifference = Math.min(currentDifference, minDifference);
		}
		return minDifference;
	}
}
