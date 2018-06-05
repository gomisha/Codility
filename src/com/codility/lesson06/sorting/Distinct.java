package com.codility.lesson06.sorting;

import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/6-sorting/distinct/
//main idea:
//use Set to store only distinct elements

public class Distinct {
	public int solution(int[] A) {
		if(A.length == 0) return 0;

		Set<Integer> aSet = new HashSet<Integer>();
		for(int i=0; i<A.length; i++) {
			aSet.add(A[i]);
		}
		return aSet.size();
	}
}
