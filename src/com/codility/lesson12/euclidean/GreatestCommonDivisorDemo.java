package com.codility.lesson12.euclidean;

public class GreatestCommonDivisorDemo {

	//reference: https://codility.com/media/train/10-Gcd.pdf
	//find greatest common divisor between 2 integers using Euclidean algorithm with subtraction, division
	public int gcdBySubtraction(int A, int B) {
		if(A == B) return A;
		if(A > B)  return gcdBySubtraction(A-B, B);
		else       return gcdBySubtraction(A, B-A);
	}
	
	public int gcdByDivision(int A, int B) {
		if(A % B == 0) return B;
		else           return gcdByDivision(B, A % B);
	}
}
