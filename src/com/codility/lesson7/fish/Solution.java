package com.codility.lesson7.fish;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/

import java.util.Stack;

public class Solution {
	public int solution(int[] A, int[] B) {
		final int UPSTREAM = 0;
		final int DOWNSTREAM = 1;
		
		Stack<Fish> fishStack = new Stack<Fish>();

		int aliveUpstreamFishCounter = 0;
		for(int i=0; i<A.length; i++) {
			if(fishStack.isEmpty()) {
				if(B[i] == DOWNSTREAM) {
					//don't count this fish yet - need to see if it will survive
					fishStack.push(new Fish(A[i], B[i]));
				}
				else {
					//this fish will survive because it's UPSTREAM and there's no DOWNSTREAM fish above it
					aliveUpstreamFishCounter++;
				}
			}
			else {
				Fish stackFish = fishStack.peek();
				if(B[i] == stackFish.direction) { //same direction, so need to take latest fish
					//fishStack.pop();
					fishStack.push(new Fish(A[i], B[i]));
				}
				else { //figure out who's eating who
					if(stackFish.size < A[i]) {
						fishStack.pop();
						fishStack.push(new Fish(A[i], B[i]));
					}
				}

			}
		}
		
		return aliveUpstreamFishCounter + fishStack.size();
	}
	
	class Fish {
		private int size;
		private int direction;
		
		Fish(int pSize, int pDirection) {
			size = pSize;
			direction = pDirection;
		}
	}
}
