package com.codility.lesson5.countdiv;

//https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/

public class Solution {
	public int solution(int A, int B, int K) {
		int divisors = 0;
		
		if(K > B) return 0; //nothing to do when K > B

		for(int i=A; i<=B; i++) {
			if(i < K) continue; //no sense in checking when i < K
			
			if(i % K == 0) {
				divisors++;
			}
		}
		return divisors;
	}
}
