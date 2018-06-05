package com.codility.lesson05.prefixsums;

//https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
//references: 
//https://rafal.io/posts/codility-genomic-range-query.html (Java)
//https://codesays.com/2014/solution-to-genomic-range-query-by-codility/ (Python)

public class GenomicRangeQuery {
	//main idea: keep running occurrence count of each nucleotide (A/C/G/T) at every position in S
	public int[] solution(String S, int[] P, int[] Q) {
		int [] answers = new int[P.length];
		int stringLength = S.length();
		
		int [][] occurrences = new int [stringLength][4];
		
		//step 1 - for each row, count occurrences of each nucleotide (can only have 1 occurrence / row)
		//e.g. if S=CAGCCTA array will be
		//{ 
		//  {0,1,0,0}  C 
		//  {1,0,0,0}  A
		//  {0,0,1,0}  G
		//  {0,1,0,0}  C
		//  {0,1,0,0}  C
		//  {0,0,0,1}  T
	    //  {1,0,0,0}  A
		// }
		for(int i=0; i<occurrences.length; i++) {
			char c = S.charAt(i);
			if(c == 'A')      occurrences[i][0] = 1;
			else if(c == 'C') occurrences[i][1] = 1;
			else if(c == 'G') occurrences[i][2] = 1;
			else if(c == 'T') occurrences[i][3] = 1;
		}

		//step 2 - for each row (starting from 2nd row), add up occurrences of each nucleotide by adding
		//occurrences from previous row to current row
		//now have running sum of each nucleotide for any row
		//e.g. if S=CAGCCTA array will be
		//{ 
		//  {0,1,0,0}  C 
		//  {1,1,0,0}  A
		//  {1,1,1,0}  G
		//  {1,2,1,0}  C
		//  {1,3,1,0}  C
		//  {1,3,1,1}  T
	    //  {2,3,1,1}  A
		// }
		for(int i=1; i<stringLength; i++) {
			for(int j=0; j<4; j++) {
				occurrences[i][j] += occurrences[i-1][j];
			}
		}

		//check each slice for min by simple subtraction
		for(int i=0; i<P.length; i++) {
			int index1 = P[i];
			int index2 = Q[i];

			for(int j=0; j<4; j++) {
				int lowerIndexCount = 0;
				//when index1 not at beginning of String - need to get occurrences from just before
				//beginning of slice - to see if that nucleotide occurred within slice
				//e.g. if slice is (2, 4), need to check for occurrences of A, C, G, T from index 1 to 4
				if(index1-1 >= 0) { 
					lowerIndexCount = occurrences[index1-1][j];
				}
				
				if(occurrences[index2][j] - lowerIndexCount > 0) {
					answers[i] = j+1; //nucleotide value is 1 more than loop value (A=1, C=2, G=3, T=4)
					//no need to keep checking since always checking from smallest impact factor
					//as soon as find occurrence, that has to be minimum, cause subsequent nucleotides have
					//larger impact factor
					break; 
				}
			}
		}
		return answers;
	}
}
