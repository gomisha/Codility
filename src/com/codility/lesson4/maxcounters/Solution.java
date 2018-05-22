package com.codility.lesson4.maxcounters;

//https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/

public class Solution {
	public int[] solution(int N, int[] A) {
		int [] counters = new int[N];
		
		int maxCounter = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] <= N) {
				counters[A[i]-1]++; //increment counter
				
				if(counters[A[i]-1] > maxCounter) {
					//store max counter in case need to set all counters to this value
					maxCounter = counters[A[i]-1];
				}
			}
			else {
				for(int j=0; j<counters.length; j++) {
					counters[j] = maxCounter;
				}
			}
		}
		return counters;
	}
}
