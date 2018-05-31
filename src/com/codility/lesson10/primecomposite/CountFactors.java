package com.codility.lesson10.primecomposite;

//https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/

//strategy: can find all factors by only checking up to square root of N
//reference: https://codility.com/media/train/8-PrimeNumbers.pdf

public class CountFactors {
	public int solution(int N) {
		int factors = 0;
		int squareRootN = (int) Math.sqrt(N);
		if(Math.pow(squareRootN, 2) != N) {
			squareRootN++; //round up for any non-perfect squares
		}
		else { //perfect squares have an additional factor
			factors++;
		}
		
		for(int i=1; i<squareRootN; i++) {
			if(N % i == 0) {
				factors += 2;
			}
		}

		return factors;
	}
}
