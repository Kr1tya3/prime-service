package com.github.kr1tya3;

import com.github.kr1tya3.api.PrimeResponse;
import com.google.common.collect.ImmutableList;
import org.junit.Test;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeServiceIT {

    @Test
    public void shouldReturnPrimes() throws Exception {
        new PrimeService().run("server");

        Client client = ClientBuilder.newClient();
        PrimeResponse primeResponse = client.target("http://localhost:8080/primes/10").request().get(PrimeResponse.class);

        PrimeResponse expectedResponse = new PrimeResponse(10, ImmutableList.of(2, 3, 5, 7));

        assertThat(primeResponse).isEqualTo(expectedResponse);

    }
}
