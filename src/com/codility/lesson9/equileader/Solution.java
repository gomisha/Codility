package com.codility.lesson9.equileader;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://app.codility.com/programmers/lessons/8-leader/equi_leader/

public class Solution {
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
		//no equi leaders if stack is empty
		if(stack.isEmpty()) return 0;
		int candidate = stack.peek().intValue();
		int count = 0;

		Map<Integer, Integer> dominatorMap = new HashMap<Integer, Integer>();
		for(int i=0; i<A.length; i++) {
			if(A[i] == candidate) {
				count++;
				dominatorMap.put(i, count);
			}
		}

		//works for even and odd number of A elements
		//e.g. if A.length = 4, count needs to be > 2
		//e.g. if A.length = 5, count needs to be > 2
		int equiLeaders = 0;
		if(count > (A.length / 2)) {
			//find all equi leader sequences
			
			int lastCandidateOccurenceIndex = 0;
			for(int i=0; i<A.length-1; i++) {
				if(A[i] == candidate) {
					lastCandidateOccurenceIndex = i;
					int occurrences = dominatorMap.get(i).intValue();
					
					if(occurrences > (i+1)/2) {
						if((count - occurrences) > (A.length - (i+1))/2 ) {
							equiLeaders++;
						}
					}
				}
				else if(dominatorMap.get(lastCandidateOccurenceIndex) != null) {
					int occurrences = dominatorMap.get(lastCandidateOccurenceIndex).intValue();
					if(occurrences > (i+1)/2) {
						if((count - occurrences) > (A.length - (i+1))/2 ) {
							equiLeaders++;
						}
					}
				}
			}
		}
		return equiLeaders; //no dominator found
	}
}
