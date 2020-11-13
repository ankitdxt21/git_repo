package com.prac.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AddFractions {

	public static void main(String[] args) {
		int[][] fractions = new int[][] { new int[] { 5, 4 }, new int[] { 1, 6 }, new int[] { 1, 3 },
				new int[] { 3, 4 } };
		int[] nums = new int[fractions.length];
		int[] denos = new int[fractions.length];

		for (int i = 0; i < fractions.length; i++) {
			nums[i] = fractions[i][0];
			denos[i] = fractions[i][1];
		}
		System.out.println("LCM : " + lcm(denos));
		System.out.println("HCF : " + reduceToMinWithPrime(summation(nums, denos, lcm(denos)), lcm(denos)));
		System.out.println("Addition of Fractions = " + Arrays.toString(new int[] {
				summation(nums, denos, lcm(denos))
						/ reduceToMinWithPrime(summation(nums, denos, lcm(denos)), lcm(denos)),
				lcm(denos) / reduceToMinWithPrime(summation(nums, denos, lcm(denos)), lcm(denos)) }));

	}

	private static int lcm(int[] denos) {
		int cal = 1;
		for (int deno : denos)
			cal = cal * deno;
		return cal;
	}

	private static int summation(int[] nums, int[] denos, int lcm) {
		int cal = 0;
		for (int i = 0; i < nums.length; i++)
			cal = cal + nums[i] * (lcm / denos[i]);
		return cal;

	}

	private static int reduceToMinWithPrime(int num, int deno) {

		int small = num > deno ? deno : num;
		int[] primes = prime((int) Math.sqrt(small));
		int primeCounter = 0;
		int finalNo = 1;
		while (small >= primes[primeCounter]) {
			if (num % primes[primeCounter] == 0 && deno % primes[primeCounter] == 0) {
				num = num / primes[primeCounter];
				deno = deno / primes[primeCounter];
				small = small / primes[primeCounter];
				finalNo = finalNo * primes[primeCounter];
				continue;
			} else {
				primeCounter++;
			}
		}
		return finalNo;
	}

	private static int[] prime(int prime) {

		List<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 2; i < prime; i++, count = 0) {
			for (int j = 2; j < Math.sqrt(i); j++) {
				if (i % j == 0)
					count++;
			}

			if (count == 0)
				list.add(i);

		}
		return list.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
	}
}
