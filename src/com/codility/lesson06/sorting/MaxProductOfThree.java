package com.codility.lesson06.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/

//main idea:
//the largest 3 elements product will be one of these 4 values, assuming we have an ordered list:
//1. first 3 elements (highest values)
//2. last 3 elements (lowest values - can have 2 large negative values that create a positive and then multipled by a positive)
//3. first element and last 2 elements
//4. first 2 elements and last element
//so we first add all the array elements into a list, order the list and then find the max of the above 4 values
//it has to be a list and not a set because duplicate elements ARE allowed so we don't want to presever them

public class MaxProductOfThree {
	public int solution(int[] A) {
		List<Integer> aList = new ArrayList<Integer>();
		for(int i=0; i<A.length; i++) {
			aList.add(A[i]);
		}
		Collections.sort(aList);
		
		int product1, product2, product3, product4 = 0;

		product1 = aList.get(0) * aList.get(1) * aList.get(2); //first 3 elements
		product2 = aList.get(aList.size()-3) * aList.get(aList.size()-2) * aList.get(aList.size()-1); //last 3 elements
		product3 = aList.get(0) * aList.get(1) * aList.get(aList.size()-1); //first 2 and last element
		product4 = aList.get(0) * aList.get(aList.size()-2) * aList.get(aList.size()-1); //first and last 2 elements

		int max1 = Math.max(product1, product2);
		int max2 = Math.max(product3, product4);
		
		return Math.max(max1, max2);
	}
}
