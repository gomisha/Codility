package com.codility.lesson3.frogjmp;

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/

public class Solution {
	public int solution(int X, int Y, int D) {
		int distanceToJump = Y - X;
		int jumpsRequired = distanceToJump / D;
		if(distanceToJump % D != 0) {
			jumpsRequired++; //only add extra jump if remainder exists
		}
		return jumpsRequired;
	}
}
