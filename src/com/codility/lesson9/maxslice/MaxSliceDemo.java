package com.codility.lesson9.maxslice;

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
    public int solution(int a[]) {
		int absoluteMax = a[0];
		int localMax = a[0];
		int nextSum = 0;
		int currentElement = 0;
		
		for (int i = 1; i < a.length; i++) {
			currentElement = a[i];
			nextSum = localMax + currentElement;
			localMax = Math.max(a[i], nextSum);
			absoluteMax = Math.max(absoluteMax, localMax);
		}
		return absoluteMax;
    }
}
