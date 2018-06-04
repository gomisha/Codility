package com.codility.practice;

public class Demo {
	public int solution(int[] A) {

		//largest possible value in A[i] - need to have this many "buckets" to check for lowest missing min
		final int MAX = 1000000;
		//will all be set to false
		//set to 1 higher than limit so that index value == number that's missing
		boolean [] isFound = new boolean[MAX+1];
		isFound[0] = true; //mark first element as "found" because lowest possible answer is 1, not 0
		
		for(int i=0; i<A.length; i++) {
			if(A[i] > 0) {
				//mark all values from A as true so can later check for lowest "false" value
				isFound[A[i]] = true;
			}
		}
		
		for(int i=0; i<isFound.length; i++) {
			if(!isFound[i]) return i;
		}
		
		//if no positives contained in A, just return 1
		return 1;
	}
}
