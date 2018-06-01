package com.codility.lesson10.primecomposite;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

//https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/

public class CountSemiprimes {
	public int[] solution(int N, int[] P, int[] Q) {
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

		//populate semi primes set in order
		SortedSet<Integer> semiPrimeSet = new TreeSet<Integer>();
		for(int i=0; i<primes.length-1; i++) {
			semiPrimeSet.add(primes[i] * primes[i]); //square of the prime
			for(int j=i+1; j<primes.length; j++) {
				semiPrimeSet.add(primes[i] * primes[j]);
			}
		}
		
		int [] semiPrimes = new int[P.length];
		
		for(int i=0; i<P.length; i++) {
			int countSemiPrimes = 0;
			
			for(int semiPrime : semiPrimeSet) {
				if(semiPrime < P[i]) continue; //haven't reached range of semi primes yet
				if(semiPrime > Q[i]) {  //passed range of semi primes - stop searching
					semiPrimes[i] = countSemiPrimes; 
					break;
				}
				countSemiPrimes++;
			}
		}
		return semiPrimes;
	}
}
