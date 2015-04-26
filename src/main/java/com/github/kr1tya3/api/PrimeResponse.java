package com.github.kr1tya3.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class PrimeResponse {

    @JsonProperty
    private final int initial;

    @JsonProperty
    private final List<Integer> primes;

    @JsonCreator
    public PrimeResponse(@JsonProperty("initial") int initial, @JsonProperty("primes") List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public int getInitial() {
        return initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return "PrimeResponse{" +
                "initial=" + initial +
                ", primes=" + primes +
                '}';
    }
}
