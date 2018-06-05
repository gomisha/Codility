package test.com.codility.lesson05.prefixsums;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson05.prefixsums.PassingCars;

//https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/

public class PassingCarsTests {
	private PassingCars solution;
	
	@BeforeTest
	public void setUp() {
		solution = new PassingCars();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {  new int [] {    0, 1, 0, 1, 1 }, 5 },
			new Object [] {  new int [] { 1, 0, 0, 1, 0, 1 }, 5 },
			new Object [] {  new int [] { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 }, 15 },
			new Object [] {  new int [] { 1, 1, 0, 1 }, 1 },
			new Object [] {  new int [] { 0, 1, 1, 1 }, 3 },
			new Object [] {  new int [] { 0, 1, 1, 1, 0 }, 3 },
			new Object [] {  new int [] { 0, 1, 1, 1, 0, 1 }, 5 },
			new Object [] {  new int [] { 0, 1, 1, 1, 0, 1, 1 }, 7 },
			new Object [] {  new int [] { 0, 1, 1, 1, 0, 1, 1, 1 }, 9 },
			new Object [] {  new int [] { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 9 },
			new Object [] {  new int [] { 0, 1, 1, 1, 0, 1, 1, 1, 0, 0 }, 9 },
			new Object [] {  new int [] { 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1 }, 13 },
			
			//no passing cars
			new Object [] {  new int [] {       1 }, 0 },
			new Object [] {  new int [] {       0 }, 0 },
			new Object [] {  new int [] {    0, 0 }, 0 },
			new Object [] {  new int [] {    1, 1 }, 0 },
			new Object [] {  new int [] { 1, 1, 0 }, 0 },
			
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int [] pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);	
	}		
}
