package com.codility.lesson02.arrays;

import java.util.HashMap;
import java.util.Set;

public class OddOccurrencesInArray {
	public int solution(int[] A) {
		HashMap <Integer, Integer> occurrencesMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<A.length; i++) {
			if(occurrencesMap.containsKey(A[i])) {
				int occurrences = occurrencesMap.get(A[i]);
				occurrences++;
				occurrencesMap.put(A[i], occurrences); //increment occurrence counter and store it
			}
			else {
				occurrencesMap.put(A[i], 1); //1st occurrences of this value
			}
		}

		Set<Integer> keySet = occurrencesMap.keySet();
		
		for(int currentKey : keySet) {
			int occurrences = occurrencesMap.get(currentKey);
			
			//if occurs odd number of times, we found the unpaired value - no need to continue checking
			if(occurrences % 2 != 0) return currentKey;
		}
		//should never get to here
		throw new RuntimeException("shouldn't get to here - should've return unpaired value by now");
	}
}
