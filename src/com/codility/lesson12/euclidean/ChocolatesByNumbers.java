package com.codility.lesson12.euclidean;

public class ChocolatesByNumbers {

	public int solve(int N, int M) {
		int counter = 0;
		boolean [] isEaten = new boolean[N];
		
		for(int i=0; i<N; i=((i+M) % N)) {
			if(isEaten[i]) {
				break;
			}
			isEaten[i] = true;
			counter++;
		}
		return counter;
	}
}
