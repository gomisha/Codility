package com.codility.lesson4.maxcounters;

import java.util.Arrays;
import java.util.HashMap;

//https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/

public class Solution {
	public int[] solution(int N, int[] A) {
		HashMap<Integer, Integer> countersMap = new HashMap<Integer, Integer>();

		int maxCounter = 0; //for the next re-set will know what high score to set all values
		int lastResetCounter = 0; //for setting values that were never explicitly set - at the end
		
		for(int i=0; i<A.length; i++) {
			if(A[i] <= N) {
				if(countersMap.containsKey(A[i])) {
					int currentValue = countersMap.get(A[i]);
					currentValue++; //increment just that value and
					countersMap.put(A[i], currentValue); //re-save it to map
				}
				else {
					//need to start from last "high score" and increment by 1
					int currentValue = lastResetCounter + 1;
					countersMap.put(A[i], currentValue); //re-save it to map
				}
				
				if(countersMap.get(A[i]) > maxCounter) {
					//store max counter in case need to set all counters to this value
					maxCounter = countersMap.get(A[i]); 
				}
			}
			else {
				//set all values to maxCounter
				for(int key : countersMap.keySet()) {
					countersMap.put(key, maxCounter);
				}
				lastResetCounter = maxCounter;
			}
		}
		//first, set all values to last "high score"
		int [] counters = new int[N];
		Arrays.fill(counters, lastResetCounter);

		//second, set all values that were individually incremented since then
		for(int key : countersMap.keySet()) {
			counters[key-1] = countersMap.get(key);
		}
		return counters;
	}
}
