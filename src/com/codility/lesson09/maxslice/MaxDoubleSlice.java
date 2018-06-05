package com.codility.lesson09.maxslice;

//reference: https://stackoverflow.com/questions/25726735/maxdoubleslicesum-codility-algorithm
//reference: https://rafal.io/posts/codility-max-double-slice-sum.html
//https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
//strategy:
//Compute local max (not less than 0) up to each element in A going a) forward and b) backward
//find absolute max double slice by going through a) and b) to compute each double slice sum
//
//e.g.         A = {  3,  2,  6, -1,  4,  5, -1, 2 }
//slice1LocalMax = {  0,  2,  8,  7, 11, 16, 15, 0 }
//slice2LocalMax = {  0, 16, 14,  8,  9,  5,  0, 0 }

public class MaxDoubleSlice {
	public int solution(int[] A) {
		int[] slice1LocalMax = new int[A.length];
		int[] slice2LocalMax = new int[A.length];
		
		//start from i=1 because slice can't start at index 0
		for(int i = 1; i < A.length-1; i++) {
			slice1LocalMax[i] = Math.max(slice1LocalMax[i-1] + A[i], 0);
		}
		  
		//start from i=A.length-2 because slice can't end at index A.length-1
		for(int i = A.length-2; i > 0; i--){
			slice2LocalMax[i] = Math.max(slice2LocalMax[i+1]+A[i], 0);
		}
		
		int maxDoubleSliceSum = 0;
		
		//compute sums of all slices to find absolute max
		for(int i = 1; i < A.length-1; i++) {
			maxDoubleSliceSum = Math.max(maxDoubleSliceSum, slice1LocalMax[i-1] + slice2LocalMax[i+1]);
		}
		
		return maxDoubleSliceSum;
	}
}
