package com.codility.lesson06.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://app.codility.com/programmers/lessons/6-sorting/triangle/

public class Triangle {
    public int solution(int[] A) {
    	if(A.length < 3) return 0;
    	
		List<Integer> aList = new ArrayList<Integer>();
		for(int i=0; i<A.length; i++) {
			aList.add(A[i]);
		}
		Collections.sort(aList);

		//made long array because each int element can be as high as Integer.MAX_VALUE so when add them
		//can overflow int
		long [] aOrdered = new long[A.length];
		int index = 0;
		for(Integer i : aList) {
			aOrdered[index++] = i;
		}

		//start from the end (largest)
		//if previous 2 elements have sum > current element, found a triangle 
		for(int i=aOrdered.length-1; i>=2; i--) {
			if(aOrdered[i-1] + aOrdered[i-2] > aOrdered[i]) {
				return 1;
			}
		}
    	return 0;
    }
}
