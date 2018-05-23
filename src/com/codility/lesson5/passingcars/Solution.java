package com.codility.lesson5.passingcars;

import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/

public class Solution {
	public int solution(int[] A) {
		Set<Integer> zeroIndicesSet = new HashSet<Integer>();
		int carPasses = 0;
		
		for(int i=0; i<A.length; i++) {
			if(A[i] == 0) {
				zeroIndicesSet.add(i);
			}
		}
		for(int currentZeroIndex : zeroIndicesSet) {
			for(int i = currentZeroIndex + 1; i<A.length; i++) {
				if(A[i] == 1) {
					carPasses++;
				}
			}
		}
		
		return carPasses;
	}
}
