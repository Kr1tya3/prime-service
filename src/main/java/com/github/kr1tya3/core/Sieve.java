package com.github.kr1tya3.core;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;

public class Sieve implements com.github.kr1tya3.api.PrimeListGenerator {

    /**
     * Calculates all the prime numbers up to a certain limit using the Sieve of Eratosthenes
     * @param limit
     * @return
     */
    @Override
    public List<Integer> getPrimes(int limit) {
        if (limit == 0) {
            return ImmutableList.of();
        }
        return doSieve(limit);
    }

    private List<Integer> doSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        ImmutableList.Builder<Integer> result = ImmutableList.builder();

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                result.add(i);
                setFalseForAllMultiples(limit, isPrime, i);
            }
        }

        return result.build();
    }

    private void setFalseForAllMultiples(int limit, boolean[] isPrime, int i) {
        for (int j = i; (long)i*j <= limit; j++) {
            isPrime[i*j] = false;
        }
    }
}
