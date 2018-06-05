package test.com.codility.lesson06.sorting;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson06.sorting.Triangle;

//https://app.codility.com/programmers/lessons/6-sorting/triangle/

public class TriangleTests {
	private Triangle solution;
	
	@BeforeTest
	public void setUp() {
		solution = new Triangle();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  new int [] { 10, 2, 5, 1, 8, 20 }, 1 }, 
			new Object [] {  new int [] { 10, 50, 5, 1 }, 0 }, 
			new Object [] {  new int [] { 1 }, 0 },
			new Object [] {  new int [] { 1, 1 }, 0 },
			new Object [] {  new int [] { 1, 1, 1, 1 }, 1 }, //1 + 1 > 1
			new Object [] {  new int [] { -5, -3, -1, 2, 3, 5 }, 0 },
			new Object [] {  new int [] { -5, -3, -1, 2, 4, 5 }, 1 },
			new Object [] {  new int [] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }, 1 },
			new Object [] {  new int [] { Integer.MAX_VALUE, Integer.MAX_VALUE-1, Integer.MAX_VALUE-1 }, 1 },
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int[] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
