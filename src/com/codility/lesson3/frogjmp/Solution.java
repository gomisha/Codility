package com.codility.lesson3.frogjmp;

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/

public class Solution {
	public int solution(int X, int Y, int D) {
		int jumps = 0;

		while(X < Y) {
			X += D;
			jumps++;
		}

		return jumps;
	}
}
