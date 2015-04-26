package com.github.kr1tya3.api;

import com.github.kr1tya3.core.Sieve;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/primes/{limit}")
@Produces(MediaType.APPLICATION_JSON)
public class PrimeResource {

    private final PrimeListGenerator primeListGenerator;

    public PrimeResource(PrimeListGenerator primeListGenerator) {
        this.primeListGenerator = primeListGenerator;
    }

    @GET
    public PrimeResponse getPrimes(@PathParam("limit") int limit) {
        if (limit < 0) {
            throw new WebApplicationException("Limit must not be negative", 400);
        }
        return new PrimeResponse(limit, primeListGenerator.getPrimes(limit));
    }

}
