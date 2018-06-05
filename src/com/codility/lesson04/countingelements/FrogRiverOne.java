package com.codility.lesson04.countingelements;

import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/

public class FrogRiverOne {
	public int solution(int X, int[] A) {
		Set<Integer>requiredLeavesSet = new HashSet<Integer>();
		for(int i=1; i<=X; i++) {
			requiredLeavesSet.add(i);
		}
		
		Set<Integer>currentLeavesSet = new HashSet<Integer>();
		
		for(int p=0; p<A.length; p++) {
			currentLeavesSet.add(A[p]);
			//keep adding to current leaves set until it's at least the same size as required leaves set
			if(currentLeavesSet.size() < requiredLeavesSet.size()) continue;
			
			if(currentLeavesSet.containsAll(requiredLeavesSet)) {
				return p;
			}
		}
		return -1;
	}
}
