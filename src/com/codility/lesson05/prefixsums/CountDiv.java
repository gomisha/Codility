package com.codility.lesson05.prefixsums;

//https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/

public class CountDiv {
	public int solution(int A, int B, int K) {
		int divisors = 0;
		
		//nothing to do when K > B
		if(K > B) {
			if(A == 0 || B == 0) {
				return 1; //K mod 0 == 0 so count a single divisor
			}
			return 0; //no divisors when A, B both != 0
		}

		if(A == 0) {
			divisors++;  //K mod 0 == 0
		}
		
		int updatedA = A;
		if(K > A) {
			updatedA = K; //skip checking all values < K
		}
		
		int firstNonZeroDivisor = 0;
		int lastNonZeroDivisor = 0;
		
		for(int i=updatedA; i<=B; i++) {
			if(i % K == 0) {
				firstNonZeroDivisor = i;
				break;
			}
		}
		
		for(int i=B; i>=updatedA; i--) {
			if(i % K == 0) {
				lastNonZeroDivisor = i;
				break;
			}
		}
		if(firstNonZeroDivisor == 0 && lastNonZeroDivisor == 0) {
			divisors = 0;
		}
		else {
			divisors += ((lastNonZeroDivisor - firstNonZeroDivisor) / K) + 1;
		}
		
		return divisors;
	}
}
