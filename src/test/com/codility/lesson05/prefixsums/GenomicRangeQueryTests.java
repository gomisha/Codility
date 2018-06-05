package test.com.codility.lesson05.prefixsums;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson05.prefixsums.GenomicRangeQuery;

//https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/

public class GenomicRangeQueryTests {
	private GenomicRangeQuery solution;
	
	@BeforeTest
	public void setUp() {
		solution = new GenomicRangeQuery();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  "C", new int [] { 0, 0, 0 }, new int [] { 0, 0, 0 }, new int [] { 2, 2, 2} },
			new Object [] {  "AA", new int [] { 0, 1, 0 }, new int [] { 0, 1, 1 }, new int [] { 1, 1, 1} },
			new Object [] {  "CC", new int [] { 0, 1, 0 }, new int [] { 0, 1, 1 }, new int [] { 2, 2, 2} },
			new Object [] {  "GG", new int [] { 0, 1, 0 }, new int [] { 0, 1, 1 }, new int [] { 3, 3, 3} },
			new Object [] {  "TT", new int [] { 0, 0, 0 }, new int [] { 1, 1, 1 }, new int [] { 4, 4, 4} },
			new Object [] {  "ATT", new int [] { 0, 0, 0 }, new int [] { 1, 1, 1 }, new int [] { 1, 1, 1} },
			new Object [] {  "CAGCCTA", new int [] { 2, 5, 0 }, new int [] { 4, 5, 6 }, new int [] { 2, 4, 1} },
			new Object [] {  "CAGTCAT", new int [] { 0, 1, 3 }, new int [] { 0, 5, 4 }, new int [] { 2, 1, 2} },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(String pS, int[] pP, int[] pQ, int [] pExpected) {		
		int [] actual = solution.solution(pS, pP, pQ);	
		Assert.assertEquals(actual.length, pExpected.length);	
		for(int i=0; i<actual.length; i++) {	
			Assert.assertEquals(actual[i], pExpected[i]);
		}	
	}		
}
