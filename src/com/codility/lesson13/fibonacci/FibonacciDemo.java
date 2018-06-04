package com.codility.lesson13.fibonacci;

//https://app.codility.com/programmers/lessons/13-fibonacci_numbers/

public class FibonacciDemo {
	public int[] getFibs(int pN) {
		if(pN == 1) { return new int [] { 0 }; }
		if(pN == 2) { return new int [] { 0, 1 }; }
		
		int [] fibs = new int [pN];
		fibs[0] = 0;
		fibs[1] = 1;
		generateFibs(fibs, 2, pN);

		return fibs;
	}
	
	//naive/slowest implementation: fib(n) = fib(n-1) + fib(n-2)
	private void generateFibs(int [] pFibs, int pCurrent, int pMax) {
		int currentFib = pFibs[pCurrent - 1] + pFibs[pCurrent - 2];
		pFibs[pCurrent] = currentFib;

		pCurrent++;
		if(pCurrent == pMax) return;
		else {
			generateFibs(pFibs, pCurrent, pMax);
		}
	}

	//faster implementation - non recursive, uses Fibs of previous 2 elements to calculate current Fib
	public int[] getFibsFast(int pN) {
		if(pN == 1) { return new int [] { 0 }; }
		if(pN == 2) { return new int [] { 0, 1 }; }
		
		int [] fibs = new int [pN];
		fibs[0] = 0;
		fibs[1] = 1;

		for(int i=2; i<fibs.length; i++) {
			fibs[i] = fibs[i-1] + fibs[i-2];
		}
		return fibs;
	}
}
