package com.codility.lesson07.stacksqueues;

//https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/

import java.util.Stack;

public class Fish {
	public int solution(int[] A, int[] B) {
		final int UPSTREAM = 0;
		
		Stack<Fish1> fishStack = new Stack<Fish1>();
		fishStack.push(new Fish1(A[0], B[0]));

		for(int i=1; i<A.length; i++) {
			if(B[i] == fishStack.peek().direction) { //same direction, so put another fish on stack
				fishStack.push(new Fish1(A[i], B[i]));
			}
			//if top of stack fish is upstream, not right condition to see who's eating who
			else if(fishStack.peek().direction == UPSTREAM) {
				fishStack.push(new Fish1(A[i], B[i]));
			}
			else { //figure out who's eating who
				while(!fishStack.isEmpty()) {
					//current fish is swimming in same direction as top of stack fish - they can't eat other
					if(fishStack.peek().direction == B[i]) {
						fishStack.push(new Fish1(A[i], B[i]));
						break;
					}
					else {
						//existing fish that was on stack eats latest fish
						if(fishStack.peek().size > A[i]) {
							break; //eating finished
						}
						else {
							fishStack.pop();
							continue; //keep checking other elements on stack
						}
					}
				}
				if(fishStack.isEmpty()) {
					fishStack.push(new Fish1(A[i], B[i])); //current fish ate all the fish in the stack
				}
			}
		}
		return fishStack.size();
	}
	
	class Fish1 {
		private int size;
		private int direction;
		
		Fish1(int pSize, int pDirection) {
			size = pSize;
			direction = pDirection;
		}
	}
}
