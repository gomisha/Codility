package com.codility.lesson4.countingelements;

import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/

public class MissingInteger {
	public int solution(int[] A) {
		Set<Integer> testedSet = new HashSet<Integer>();
		Set<Integer> perfectSet = new HashSet<Integer>();
		
		
		for(int i=0; i<A.length; i++) {
			testedSet.add(A[i]);   //convert array to set to get rid of duplicates, order int's
			perfectSet.add(i+1);  //create perfect set so can find missing int 
		}
		
		for(int current : perfectSet) {
			if(!testedSet.contains(current)) {
				return current;
			}
		}

		if(perfectSet.size() == testedSet.size()) {
			return perfectSet.size() + 1;  //e.g. {1, 2, 3} should return 4
		}
		
		return 1; //default - e.g. if A array has negative values or just a single positive value like 10
	}
}
