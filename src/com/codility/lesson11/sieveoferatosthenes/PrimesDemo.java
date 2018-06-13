package com.codility.lesson11.sieveoferatosthenes;

import java.util.ArrayList;
import java.util.List;

//purpose: for a given integer N, find all primes up to N
//reference: https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/
//reference: https://codility.com/media/train/9-Sieve.pdf
public class PrimesDemo {

	public int[] solution(int N) {
		//make size N+1 so will have direct mapping from array index
		boolean [] arePrimes = new boolean[N+1];

		arePrimes[0] = false; //0 is never prime
		arePrimes[1] = false; //1 is never prime
		for(int i=2; i<arePrimes.length; i++) {
			arePrimes[i] = true;
		}

		int nSquareRoot = (int) Math.sqrt(N);
		for(int i=2; i<=nSquareRoot; i++) {
			if(arePrimes[i]) {
				//start checking from i^2 because lower numbers will have already been checked
				//keep checking very multiple of i
				for(int j=i*i; j<=N; j+=i) {
					arePrimes[j] = false;
				}
			}
		}

		List<Integer> primesList = new ArrayList<Integer>();
		for(int i=2; i<arePrimes.length; i++) {
			if(arePrimes[i]) {
				primesList.add(i);
			}
		}

		//https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java
		int[] primes = primesList.stream().mapToInt(i->i).toArray();
		
		return primes;
	}
}
