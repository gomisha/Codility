package com.codility.lesson6.distinct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://app.codility.com/programmers/lessons/6-sorting/distinct/
//main idea:
//can easily count number of distinct elements if have ordered list, so
//1. add all the array elements into a list
//2. order the list 
//3. count number of distinct elements in the ordered list using simple loop 
//Note: it has to be a list and not a set because duplicate elements ARE allowed

public class Solution {
	public int solution(int[] A) {
		if(A.length == 0) return 0;

		List<Integer> aList = new ArrayList<Integer>();
		for(int i=0; i<A.length; i++) {
			aList.add(A[i]);
		}
		Collections.sort(aList);

		int [] aOrdered = new int[A.length];
		int index = 0;
		for(Integer i : aList) {
			aOrdered[index++] = i;
		}

		int distinctValues = 1;
		int lastDistinctValue = aOrdered[0];
		
		for(int i=1; i<aOrdered.length; i++) {
			if(aOrdered[i] != lastDistinctValue) {
				distinctValues++;
				lastDistinctValue = aOrdered[i];
			}
		}
		return distinctValues;
	}
}
