package com.github.kr1tya3.core;


import com.github.kr1tya3.api.PrimeListGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;


public class SieveTest {

    private Sieve sieve;

    @Before
    public void setUp() throws Exception {
        sieve = new Sieve();
    }

    @Test
    public void shouldReturnEmptyListIfLimitIsZero() throws Exception {
        List<Integer> primes = sieve.getPrimes(0);
        assertThat(primes, is(empty()));
    }

    @Test
    public void shouldReturnPrimesUpTo5() throws Exception {
        List<Integer> primes = sieve.getPrimes(5);
        assertThat(primes, contains(2, 3, 5));
    }
}