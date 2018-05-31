package test.com.codility.lesson10.primecomposite;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codility.lesson10.primecomposite.MinPerimeterRectangle;

//https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/

public class MinPerimeterRectangleTests {
	private MinPerimeterRectangle solution;
	
	@BeforeTest
	public void setUp() {
		solution = new MinPerimeterRectangle();
	}

	@DataProvider(name = "test1")
	public Object [][] createData1() {
		return new Object [][] {
			new Object [] {   1, 4 }, //2x(1+1)=4
			new Object [] {   2, 6 }, //2x(1+2)=6
			new Object [] {   3, 8 }, //2x(1+3)=8
			new Object [] {   4, 8 }, //2x(1+4)=10, 2x(2+2)=8
			new Object [] {  10, 14 }, //2x(1+10)=22, 2x(2+5)=14
			new Object [] {  24, 20 }, //2x(1+24)=50, 2x(2+12)=48, 2x(3+8)=22, 2x(4+6)=20

			new Object [] {  25, 20 }, //2x(1+25)=52, 2x(5+5)=20, 
			new Object [] {  30, 22 }, //2x(1+30)=62, 2x(2+15)=34, 2x(3+10)=26, 2x(5+6)=22 
			new Object [] {  36, 24 }, //2x(1+36)=72, 2x(2+18)=40, 2x(3+12)=30, 2x(4+9)=26, 2x(6+6)=24, 
			new Object [] {  56, 30 }, //2x(7+8)=30
			new Object [] { 100, 40 }, //2x(10+10)=40
		};
	}

	@Test(dataProvider = "test1")
	public void verifySolution(int pA, int pExpected) {		
		Assert.assertEquals(solution.solution(pA), pExpected);
	}	
}
