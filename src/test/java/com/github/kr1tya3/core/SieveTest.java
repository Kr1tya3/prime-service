package com.github.kr1tya3.core;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SieveTest {

    private Sieve sieve;

    @Before
    public void setUp() throws Exception {
        sieve = new Sieve();
    }

    @Test
    public void shouldReturnEmptyListIfLimitIsZero() throws Exception {
        List<Integer> primes = sieve.getPrimes(0);
        assertThat(primes).isEmpty();
    }

    @Test
    public void shouldReturnPrimesUpTo5() throws Exception {
        List<Integer> primes = sieve.getPrimes(5);
        assertThat(primes).containsExactly(2, 3, 5);
    }

    @Test
    public void shouldNotHaveIntegerOverFlow() {
        List<Integer> primes = sieve.getPrimes(1000000);
        assertThat(primes).isNotEmpty();
    }
}