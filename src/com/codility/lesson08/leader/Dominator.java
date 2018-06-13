package com.codility.lesson08.leader;

import java.util.Stack;

//https://app.codility.com/programmers/lessons/8-leader/dominator/

//main strategy: if there's a dominator (number occurs more than half the time), then it will be the only 
//number on a stack to find candidates
//keep a stack of duplicate candidates; if encounter a number that doesn't exist on top of stack,
//pop the stack; if encounter number that equals the top of stack number, push that number on top of stack
//if the stack is not empty after going through all the array elements, then we have a candidate (not necessarily a dominator)
//go through array again counting number of occurences of candidate to decide if it's dominator
//
//reference: https://codility.com/media/train/6-Leader.pdf

public class Dominator {

	public int solution(int[] A) {
		Stack <Integer>stack = new Stack<Integer>();
		
		for(int i=0; i<A.length; i++) {
			if(stack.isEmpty()) {
				stack.push(A[i]);
			}
			else {
				if(stack.peek().intValue() == A[i]) {
					stack.push(A[i]);
				}
				else {
					stack.pop();
				}
			}
		}
		//no candidate if stack is empty
		if(stack.isEmpty()) return -1;
		int candidate = stack.peek().intValue();
		int count = 0;
		int candidateIndex = -1;
		for(int i=0; i<A.length; i++) {
			if(A[i] == candidate) {
				count++;
				if(candidateIndex < 0) {
					candidateIndex = i; //only store index of first occurence of candidate
				}
			}
		}

		//works for even and odd number of A elements
		//e.g. if A.length = 4, count needs to be > 2
		//e.g. if A.length = 5, count needs to be > 2
		if(count > (A.length / 2)) return candidateIndex;

		return -1; //no dominator found
	}
}
