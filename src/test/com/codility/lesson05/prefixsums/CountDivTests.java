package test.com.codility.lesson05.prefixsums;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson05.prefixsums.CountDiv;

//https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/

public class CountDivTests {
	private CountDiv solution;
	
	@BeforeTest
	public void setUp() {
		solution = new CountDiv();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  5, 11, 2,  3 },
			new Object [] {  6, 11, 2,  3 },
			new Object [] {  0, 11, 5,  3 },
			new Object [] {  0, 11, 12, 1 }, //K>B, A==0
			new Object [] {  1, 11, 12, 0 }, //K>B, A>0
			new Object [] {  0, 0,  12, 1 }, //K>B, A==0, B==0
			new Object [] { 11, 33, 3, 8 },
			
			new Object [] { 10, 10,  5, 1 }, //A = 10, B = 10, K in {5,7,20}
			new Object [] { 10, 10,  7, 0 }, //A = 10, B = 10, K in {5,7,20}
			new Object [] { 10, 10, 20, 0 }, //A = 10, B = 10, K in {5,7,20}
			
			new Object [] { 33, 33, 33, 1 }, //A == B
			new Object [] { 100000, 1000000, 1000, 901 },
			new Object [] { 1000, 10000, 10, 901 },
			new Object [] { 100, 1000, 1, 901 },
			new Object [] { 0, 2000000000, 2000000000, 2 }, //max B
			new Object [] { 2000000000, 2000000000, 2000000000, 1 }, //max A, B
			new Object [] { 100, 123000000, 2, 61499951 }, //A = 100, B=123M+, K=2
			new Object [] { 101, 123000000, 10000, 12300 }, //A = 101, B = 123M+, K = 10K
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int pA, int pB, int pK, int pExpected) {
		Assert.assertEquals(solution.solution(pA, pB, pK), pExpected);
	}
}
