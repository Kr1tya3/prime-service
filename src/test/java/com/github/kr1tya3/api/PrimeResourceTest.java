package com.github.kr1tya3.api;

import com.google.common.collect.ImmutableList;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.glassfish.jersey.client.ClientResponse;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PrimeResourceTest {

    private static final PrimeListGenerator primeListGenerator = mock(PrimeListGenerator.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PrimeResource(primeListGenerator))
            .build();

    private final PrimeResponse expectedResponse = new PrimeResponse(5, ImmutableList.of(2, 3, 5));

    @Test
    public void shouldReturnPrimesUpToLimit() {
        when(primeListGenerator.getPrimes(5)).thenReturn(ImmutableList.of(2, 3, 5));

        PrimeResponse response = resources.client().target("/primes/5").request().get(PrimeResponse.class);

        assertThat(response).isEqualTo(expectedResponse);
        verify(primeListGenerator).getPrimes(5);
    }

    @Test(expected = javax.ws.rs.BadRequestException.class)
    public void shouldReturn400IfNegativeNumber() {
        resources.client().target("/primes/-1").request().get(ClientResponse.class);
    }
}