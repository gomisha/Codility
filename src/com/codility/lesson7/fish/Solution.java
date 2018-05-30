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
			if(fishStack.isEmpty() && B[i] == DOWNSTREAM) {
				//don't count this fish yet - need to see if it will survive
				fishStack.push(new Fish(A[i], B[i]));
			}
			else if(fishStack.isEmpty() && B[i] == UPSTREAM) {
				//this fish will survive because it's UPSTREAM and there's no DOWNSTREAM fish above it
				aliveUpstreamFishCounter++;
			}
			else {
				Fish stackFish = fishStack.peek();
				if(B[i] == stackFish.direction) { //same direction, so put another fish on stack
					fishStack.push(new Fish(A[i], B[i]));
				}
				//if top of stack fish is upstream, not right condition to see who's eating who
				else if(stackFish.direction == UPSTREAM) {
					fishStack.push(new Fish(A[i], B[i]));
				}
				else { //figure out who's eating who
					while(!fishStack.isEmpty()) {
						Fish topOfStackFish = fishStack.peek();
						if(topOfStackFish.direction != B[i]) {
							//existing fish that was on stack eats latest fish
							if(topOfStackFish.size > A[i]) {
								//fishStack.push(topOfStackFish);
								break; //eating finished
							}
							else {
								fishStack.pop();
								continue; //keep checking other elements on stack
								//fishStack.push(new Fish(A[i], B[i]));
							}
						}
						else {
							fishStack.push(new Fish(A[i], B[i]));
							break;
						}
					}
					if(fishStack.isEmpty()) {
						fishStack.push(new Fish(A[i], B[i])); //current fish ate all the fish in the stack
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
