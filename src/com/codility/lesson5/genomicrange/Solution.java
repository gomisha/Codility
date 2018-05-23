package com.codility.lesson5.genomicrange;

import java.util.HashMap;

//https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/

public class Solution {
	public int[] solution(String S, int[] P, int[] Q) {
		HashMap<Character, Integer> impactFactorMap = new HashMap<Character, Integer>();
		impactFactorMap.put('A', 1);
		impactFactorMap.put('C', 2);
		impactFactorMap.put('G', 3);
		impactFactorMap.put('T', 4);
		final int BEST_MIN = 1;
		
		int [] answers = new int[P.length];
		
		for(int i=0; i<P.length; i++) {
			int bestMin = 4; //start with worst min
			
			for(int j=P[i]; j<=Q[i]; j++) {
				char c = S.charAt(j);
				int min = impactFactorMap.get(c);

				bestMin = Math.min(min, bestMin);
				answers[i] = min;
				if(min == BEST_MIN) break; //can't get any lower than this, so can stop searching if found it
			}
		}
		return answers;
	}
}
