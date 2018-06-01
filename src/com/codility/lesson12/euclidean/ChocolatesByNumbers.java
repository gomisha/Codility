package com.codility.lesson12.euclidean;

//https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
//
//reference: https://codesays.com/2014/solution-to-chocolates-by-numbers-by-codility/
public class ChocolatesByNumbers {
	public int solve(int N, int M) {
		return N / gcdByDivision(N, M);
	}
	
	int gcdByDivision(int A, int B) {
		if(A % B == 0) return B;
		else           return gcdByDivision(B, A % B);
	}
	
}
