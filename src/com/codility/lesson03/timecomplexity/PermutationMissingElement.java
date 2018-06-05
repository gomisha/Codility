package com.codility.lesson03.timecomplexity;

import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/

public class PermutationMissingElement {
	public int solution(int[] A) {
		int max = A.length + 1;
		
		//load array elements into array so would be quick to check if elements exist
		Set<Integer> incompleteSet = new HashSet<Integer>();
		for(int i=0; i<A.length; i++) {
			incompleteSet.add(A[i]);
		}

		for(int i=1; i<max+1; i++) {
			if(!incompleteSet.contains(i)) {
				return (i);
			}
		}
		throw new RuntimeException("shouldn't reach here");
	}
}
