package test.com.codility.lesson5.genomicrange;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson5.genomicrange.Solution;

//https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/

public class SolutionTests {
	private Solution solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Solution();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
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
