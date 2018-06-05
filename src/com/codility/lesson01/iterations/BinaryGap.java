package com.codility.lesson01.iterations;

import java.util.ArrayList;
import java.util.List;

//https://app.codility.com/programmers/lessons/1-iterations/
public class BinaryGap {
	public int solution(int N) {
		String binaryString = Integer.toBinaryString(N);
		
		int longestBinaryGap = 0;
		List<Integer> onesList = new ArrayList<Integer>();
		
		for(int i=0; i<binaryString.length(); i++) {
			if(binaryString.charAt(i) == '0') continue;
			onesList.add(i);
		}
		
		for(int i=0; i<onesList.size() - 1; i++) {
			//subtract 1 so that don't count 1's next to each other as having any gap
			int indicesDiff = onesList.get(i+1) - onesList.get(i) - 1;
			
			//if 1's are next to each other, there's no gap
			if(indicesDiff == 0) continue;
			
			//if current binary gap less than previous record, don't record it
			if(longestBinaryGap > indicesDiff) continue;
			
			longestBinaryGap = indicesDiff;
		}

		return longestBinaryGap;
	}
}
