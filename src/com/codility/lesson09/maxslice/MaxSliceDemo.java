package com.codility.lesson09.maxslice;

//practice Max Slice implementation from https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//reference: https://codility.com/media/train/7-MaxSlice.pdf
//main idea: calculate local max between (up to current element) to (up to current element + 1)
//e.g. max slice sum for { -2, -3, 4, -1, -2, 1, 5, -3 } is 7
//
// A[i]     nextSum     localMax
// --------------------------------
// -2         NA           -2
// -3         -5           -3
//  4          1            4 <------- start of Max Slice
// -1          3            3
// -2          1            1
//  1          2            2
//  5          7            7 <-------- MAX (end of Max Slice)
// -3          4            4

public class MaxSliceDemo {
    public int solution(int A[]) {
		int absoluteMax = A[0];
		int localMax = A[0];
		int nextSum = 0;
		int currentElement = 0;
		
		for (int i = 1; i < A.length; i++) {
			currentElement = A[i];
			nextSum = localMax + currentElement;
			localMax = Math.max(A[i], nextSum);
			absoluteMax = Math.max(absoluteMax, localMax);
		}
		return absoluteMax;
    }
}
